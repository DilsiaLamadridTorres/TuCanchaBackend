package com.generation.tucancha.service;

import com.generation.tucancha.dto.request.HorarioRequest;
import com.generation.tucancha.dto.response.HorarioResponse;
import com.generation.tucancha.model.entity.Cancha;
import com.generation.tucancha.model.entity.Horario;
import com.generation.tucancha.model.enums.EstadoHorario;
import com.generation.tucancha.repository.CanchaRepository;
import com.generation.tucancha.repository.HorarioRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


/**
 * Servicio encargado de manejar la lógica de negocio
 * relacionada con los horarios de las canchas.
 */
@Service
public class HorarioService {

    private final HorarioRepository horarioRepository;

    private final CanchaRepository canchaRepository;


    /* =========================================================
       INYECCIÓN DE DEPENDENCIAS
       ========================================================= */

    public HorarioService(
            HorarioRepository horarioRepository,
            CanchaRepository canchaRepository
    ) {
        this.horarioRepository = horarioRepository;
        this.canchaRepository = canchaRepository;
    }


    /* =========================================================
       CREAR HORARIO
       ========================================================= */

    public HorarioResponse crearHorario(
            HorarioRequest request
    ) {

        /*
         * 1. Verificamos que la cancha exista.
         */
        Cancha cancha =
                buscarCancha(
                        request.getCanchaId()
                );


        /*
         * 2. Validamos las horas.
         *
         * La hora de inicio siempre debe ser
         * menor que la hora de finalización.
         */
        validarRangoHorario(
                request.getHoraInicio(),
                request.getHoraFin()
        );


        /*
         * 3. Verificamos que no exista
         * otro horario que se cruce.
         */
        boolean existeSolapamiento =
                horarioRepository
                        .existeSolapamiento(
                                cancha,
                                request.getFecha(),
                                request.getHoraInicio(),
                                request.getHoraFin()
                        );


        if (existeSolapamiento) {

            throw new IllegalArgumentException(
                    "Ya existe un horario registrado "
                            + "que se cruza con el horario solicitado"
            );
        }


        /*
         * 4. Creamos la entidad.
         */
        Horario horario = new Horario();


        horario.setCancha(
                cancha
        );

        horario.setFecha(
                request.getFecha()
        );

        horario.setHoraInicio(
                request.getHoraInicio()
        );

        horario.setHoraFin(
                request.getHoraFin()
        );


        /*
         * Todo horario nuevo comienza disponible.
         */
        horario.setEstado(
                EstadoHorario.DISPONIBLE
        );


        /*
         * 5. Guardamos.
         */
        Horario horarioGuardado =
                horarioRepository.save(
                        horario
                );


        /*
         * 6. Convertimos a Response.
         */
        return convertirAResponse(
                horarioGuardado
        );
    }


    /* =========================================================
       OBTENER HORARIO POR ID
       ========================================================= */

    public HorarioResponse obtenerPorId(
            Long idHorario
    ) {

        Horario horario =
                buscarHorario(
                        idHorario
                );


        return convertirAResponse(
                horario
        );
    }


    /* =========================================================
       LISTAR TODOS LOS HORARIOS
       ========================================================= */

    public List<HorarioResponse> listarTodos() {

        return horarioRepository
                .findAll()
                .stream()
                .map(this::convertirAResponse)
                .toList();
    }


    /* =========================================================
       LISTAR HORARIOS POR CANCHA
       ========================================================= */

    public List<HorarioResponse> listarPorCancha(
            Long canchaId
    ) {

        Cancha cancha =
                buscarCancha(
                        canchaId
                );


        return horarioRepository
                .findByCancha(cancha)
                .stream()
                .map(this::convertirAResponse)
                .toList();
    }


    /* =========================================================
       LISTAR HORARIOS POR CANCHA Y FECHA
       ========================================================= */

    public List<HorarioResponse> listarPorCanchaYFecha(
            Long canchaId,
            LocalDate fecha
    ) {

        Cancha cancha =
                buscarCancha(
                        canchaId
                );


        return horarioRepository
                .findByCanchaAndFecha(
                        cancha,
                        fecha
                )
                .stream()
                .map(this::convertirAResponse)
                .toList();
    }


    /* =========================================================
       LISTAR HORARIOS DISPONIBLES
       ========================================================= */

    public List<HorarioResponse> listarDisponibles(
            Long canchaId,
            LocalDate fecha
    ) {

        Cancha cancha =
                buscarCancha(
                        canchaId
                );


        return horarioRepository
                .findByCanchaAndFechaAndEstado(
                        cancha,
                        fecha,
                        EstadoHorario.DISPONIBLE
                )
                .stream()
                .map(this::convertirAResponse)
                .toList();
    }


    /* =========================================================
       ACTUALIZAR HORARIO
       ========================================================= */

    public HorarioResponse actualizarHorario(
            Long idHorario,
            HorarioRequest request
    ) {

        /*
         * Buscamos el horario que queremos modificar.
         */
        Horario horario =
                buscarHorario(
                        idHorario
                );


        /*
         * Verificamos que la cancha enviada exista.
         */
        Cancha cancha =
                buscarCancha(
                        request.getCanchaId()
                );


        /*
         * Validamos las horas.
         */
        validarRangoHorario(
                request.getHoraInicio(),
                request.getHoraFin()
        );


        /*
         * Validamos solapamiento ignorando
         * el horario que estamos modificando.
         */
        boolean existeSolapamiento =
                horarioRepository
                        .existeSolapamientoExcluyendoHorario(
                                cancha,
                                request.getFecha(),
                                request.getHoraInicio(),
                                request.getHoraFin(),
                                idHorario
                        );


        if (existeSolapamiento) {

            throw new IllegalArgumentException(
                    "El horario actualizado se cruza "
                            + "con otro horario existente"
            );
        }


        /*
         * Actualizamos los datos.
         */
        horario.setCancha(
                cancha
        );

        horario.setFecha(
                request.getFecha()
        );

        horario.setHoraInicio(
                request.getHoraInicio()
        );

        horario.setHoraFin(
                request.getHoraFin()
        );


        /*
         * No cambiamos el estado aquí.
         *
         * El estado se modifica mediante
         * otro método específico.
         */
        Horario horarioActualizado =
                horarioRepository.save(
                        horario
                );


        return convertirAResponse(
                horarioActualizado
        );
    }


    /* =========================================================
       CAMBIAR ESTADO
       ========================================================= */

    public HorarioResponse cambiarEstado(
            Long idHorario,
            EstadoHorario nuevoEstado
    ) {

        Horario horario =
                buscarHorario(
                        idHorario
                );


        horario.setEstado(
                nuevoEstado
        );


        Horario horarioActualizado =
                horarioRepository.save(
                        horario
                );


        return convertirAResponse(
                horarioActualizado
        );
    }


    /* =========================================================
       ELIMINAR HORARIO
       ========================================================= */

    public void eliminarHorario(
            Long idHorario
    ) {

        Horario horario =
                buscarHorario(
                        idHorario
                );


        horarioRepository.delete(
                horario
        );
    }


    /* =========================================================
       BUSCAR HORARIO
       MÉTODO INTERNO
       ========================================================= */

    private Horario buscarHorario(
            Long idHorario
    ) {

        return horarioRepository
                .findById(idHorario)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Horario no encontrado con id: "
                                        + idHorario
                        )
                );
    }


    /* =========================================================
       BUSCAR CANCHA
       MÉTODO INTERNO
       ========================================================= */

    private Cancha buscarCancha(
            Long canchaId
    ) {

        return canchaRepository
                .findById(canchaId)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Cancha no encontrada con id: "
                                        + canchaId
                        )
                );
    }


    /* =========================================================
       VALIDAR RANGO DE HORARIO
       ========================================================= */

    private void validarRangoHorario(
            LocalTime horaInicio,
            LocalTime horaFin
    ) {

        /*
         * isBefore pregunta:
         *
         * ¿horaInicio está antes de horaFin?
         *
         * Si la respuesta es NO,
         * el horario no es válido.
         */
        if (!horaInicio.isBefore(horaFin)) {

            throw new IllegalArgumentException(
                    "La hora de inicio debe ser "
                            + "menor que la hora de fin"
            );
        }
    }


    /* =========================================================
       CONVERTIR ENTITY → RESPONSE
       ========================================================= */

    private HorarioResponse convertirAResponse(
            Horario horario
    ) {

        HorarioResponse response =
                new HorarioResponse();


        response.setIdHorario(
                horario.getIdHorario()
        );


        response.setCanchaId(
                horario
                        .getCancha()
                        .getIdCancha()
        );


        response.setFecha(
                horario.getFecha()
        );


        response.setHoraInicio(
                horario.getHoraInicio()
        );


        response.setHoraFin(
                horario.getHoraFin()
        );


        response.setEstado(
                horario.getEstado()
        );


        return response;
    }
}