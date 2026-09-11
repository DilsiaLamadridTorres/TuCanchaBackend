package com.generation.tucancha.service;

import com.generation.tucancha.dto.request.CanchaRequest;
import com.generation.tucancha.dto.response.CanchaResponse;
import com.generation.tucancha.model.entity.Cancha;
import com.generation.tucancha.model.entity.Complejo;
import com.generation.tucancha.model.enums.EstadoCancha;
import com.generation.tucancha.repository.CanchaRepository;
import com.generation.tucancha.repository.ComplejoRepository;

import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Servicio encargado de manejar la lógica de negocio
 * relacionada con las canchas.
 */
@Service
public class CanchaService {

    private final CanchaRepository canchaRepository;

    private final ComplejoRepository complejoRepository;


    /* =========================================================
       INYECCIÓN DE DEPENDENCIAS
       ========================================================= */

    public CanchaService(
            CanchaRepository canchaRepository,
            ComplejoRepository complejoRepository
    ) {
        this.canchaRepository = canchaRepository;
        this.complejoRepository = complejoRepository;
    }


    /* =========================================================
       CREAR CANCHA
       ========================================================= */

    public CanchaResponse crearCancha(
            CanchaRequest request
    ) {

        /*
         * Primero verificamos que el complejo
         * enviado desde el frontend realmente exista.
         */
        Complejo complejo =
                complejoRepository
                        .findById(request.getComplejoId())
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Complejo no encontrado con id: "
                                                + request.getComplejoId()
                                )
                        );


        /*
         * Creamos la entidad.
         */
        Cancha cancha = new Cancha();


        /*
         * Relacionamos la cancha con el complejo.
         */
        cancha.setComplejo(complejo);


        /*
         * Datos enviados en el request.
         */
        cancha.setNombre(
                request.getNombre()
        );

        cancha.setDeporte(
                request.getDeporte()
        );

        cancha.setTipoPiso(
                request.getTipoPiso()
        );

        cancha.setLargo(
                request.getLargo()
        );

        cancha.setAncho(
                request.getAncho()
        );

        cancha.setPrecioHora(
                request.getPrecioHora()
        );

        cancha.setDuracionMinutos(
                request.getDuracionMinutos()
        );

        cancha.setTechada(
                request.getTechada()
        );

        cancha.setOtrosDeportes(
                request.getOtrosDeportes()
        );


        /*
         * El frontend NO decide el estado inicial.
         *
         * Toda cancha nueva comienza pendiente.
         */
        cancha.setEstado(
                EstadoCancha.PENDIENTE
        );


        /*
         * Guardamos en PostgreSQL.
         */
        Cancha canchaGuardada =
                canchaRepository.save(cancha);


        /*
         * Convertimos la entidad a DTO Response.
         */
        return convertirAResponse(
                canchaGuardada
        );
    }


    /* =========================================================
       OBTENER CANCHA POR ID
       ========================================================= */

    public CanchaResponse obtenerPorId(
            Long idCancha
    ) {

        Cancha cancha =
                buscarCancha(idCancha);


        return convertirAResponse(
                cancha
        );
    }


    /* =========================================================
       LISTAR TODAS LAS CANCHAS
       ========================================================= */

    public List<CanchaResponse> listarTodas() {

        return canchaRepository
                .findAll()
                .stream()
                .map(this::convertirAResponse)
                .toList();
    }


    /* =========================================================
       LISTAR CANCHAS POR COMPLEJO
       ========================================================= */

    public List<CanchaResponse> listarPorComplejo(
            Long complejoId
    ) {

        /*
         * Verificamos primero que exista el complejo.
         */
        Complejo complejo =
                complejoRepository
                        .findById(complejoId)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Complejo no encontrado con id: "
                                                + complejoId
                                )
                        );


        return canchaRepository
                .findByComplejo(complejo)
                .stream()
                .map(this::convertirAResponse)
                .toList();
    }


    /* =========================================================
       LISTAR CANCHAS POR ESTADO
       ========================================================= */

    public List<CanchaResponse> listarPorEstado(
            EstadoCancha estado
    ) {

        return canchaRepository
                .findByEstado(estado)
                .stream()
                .map(this::convertirAResponse)
                .toList();
    }


    /* =========================================================
       ACTUALIZAR CANCHA
       ========================================================= */

    public CanchaResponse actualizarCancha(
            Long idCancha,
            CanchaRequest request
    ) {

        /*
         * Buscamos la cancha existente.
         */
        Cancha cancha =
                buscarCancha(idCancha);


        /*
         * Buscamos el complejo enviado.
         */
        Complejo complejo =
                complejoRepository
                        .findById(request.getComplejoId())
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Complejo no encontrado con id: "
                                                + request.getComplejoId()
                                )
                        );


        /*
         * Actualizamos solamente la información editable.
         */
        cancha.setComplejo(complejo);

        cancha.setNombre(
                request.getNombre()
        );

        cancha.setDeporte(
                request.getDeporte()
        );

        cancha.setTipoPiso(
                request.getTipoPiso()
        );

        cancha.setLargo(
                request.getLargo()
        );

        cancha.setAncho(
                request.getAncho()
        );

        cancha.setPrecioHora(
                request.getPrecioHora()
        );

        cancha.setDuracionMinutos(
                request.getDuracionMinutos()
        );

        cancha.setTechada(
                request.getTechada()
        );

        cancha.setOtrosDeportes(
                request.getOtrosDeportes()
        );


        /*
         * IMPORTANTE:
         *
         * No modificamos el estado aquí.
         *
         * El estado se manejará en un método independiente.
         */
        Cancha canchaActualizada =
                canchaRepository.save(cancha);


        return convertirAResponse(
                canchaActualizada
        );
    }


    /* =========================================================
       CAMBIAR ESTADO DE CANCHA
       ========================================================= */

    public CanchaResponse cambiarEstado(
            Long idCancha,
            EstadoCancha nuevoEstado
    ) {

        Cancha cancha =
                buscarCancha(idCancha);


        cancha.setEstado(
                nuevoEstado
        );


        Cancha canchaActualizada =
                canchaRepository.save(cancha);


        return convertirAResponse(
                canchaActualizada
        );
    }


    /* =========================================================
       BUSCAR CANCHA
       MÉTODO INTERNO
       ========================================================= */

    private Cancha buscarCancha(
            Long idCancha
    ) {

        return canchaRepository
                .findById(idCancha)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Cancha no encontrada con id: "
                                        + idCancha
                        )
                );
    }


    /* =========================================================
       CONVERTIR ENTITY → RESPONSE
       ========================================================= */

    private CanchaResponse convertirAResponse(
            Cancha cancha
    ) {

        CanchaResponse response =
                new CanchaResponse();


        response.setIdCancha(
                cancha.getIdCancha()
        );


        /*
         * AQUÍ hay una dependencia con Complejo.java.
         *
         * Estoy usando getIdComplejo() porque coincide
         * con nuestro modelo de datos.
         *
         * Si Dilsia llamó el atributo simplemente "id",
         * esta única línea se cambia por getId().
         */
        response.setComplejoId(
                cancha
                        .getComplejo()
                        .getIdComplejo()
        );


        response.setNombre(
                cancha.getNombre()
        );

        response.setDeporte(
                cancha.getDeporte()
        );

        response.setTipoPiso(
                cancha.getTipoPiso()
        );

        response.setLargo(
                cancha.getLargo()
        );

        response.setAncho(
                cancha.getAncho()
        );

        response.setPrecioHora(
                cancha.getPrecioHora()
        );

        response.setDuracionMinutos(
                cancha.getDuracionMinutos()
        );

        response.setTechada(
                cancha.getTechada()
        );

        response.setOtrosDeportes(
                cancha.getOtrosDeportes()
        );

        response.setEstado(
                cancha.getEstado()
        );


        return response;
    }
}