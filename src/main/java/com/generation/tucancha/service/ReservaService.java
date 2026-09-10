package com.generation.tucancha.service;

import com.generation.tucancha.dto.request.ReservaRequest;
import com.generation.tucancha.dto.response.ReservaResponse;
import com.generation.tucancha.enums.EstadoReserva;
import com.generation.tucancha.exception.ResourceNotFoundException;
import com.generation.tucancha.model.entity.Horario;
import com.generation.tucancha.model.entity.Reserva;
import com.generation.tucancha.model.entity.Usuario;
import com.generation.tucancha.repository.HorarioRepository;
import com.generation.tucancha.repository.ReservaRepository;
import com.generation.tucancha.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final UsuarioRepository usuarioRepository;
    private final HorarioRepository horarioRepository;

    public ReservaService(ReservaRepository reservaRepository,
                          UsuarioRepository usuarioRepository,
                          HorarioRepository horarioRepository) {
        this.reservaRepository = reservaRepository;
        this.usuarioRepository = usuarioRepository;
        this.horarioRepository = horarioRepository;
    }

    @Transactional
    public ReservaResponse crearReserva(ReservaRequest request) {
        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        Horario horario = horarioRepository.findById(request.getHorarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Horario no encontrado"));

        Reserva reserva = Reserva.builder()
                .usuario(usuario)
                .horario(horario)
                .estado(EstadoReserva.PENDIENTE)
                .build();

        return mapToResponse(reservaRepository.save(reserva));
    }

    @Transactional(readOnly = true)
    public List<ReservaResponse> obtenerTodas() {
        return reservaRepository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public ReservaResponse obtenerPorId(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada con ID: " + id));
        return mapToResponse(reserva);
    }

    private ReservaResponse mapToResponse(Reserva reserva) {
        ReservaResponse response = new ReservaResponse();
        response.setIdReserva(reserva.getIdReserva());
        response.setUsuarioId(reserva.getUsuario().getIdUsuario());
        response.setNombreUsuario(reserva.getUsuario().getNombre());
        response.setHorarioId(reserva.getHorario().getIdHorario());
        response.setFechaCreacion(reserva.getFechaCreacion());
        response.setEstado(reserva.getEstado());
        return response;
    }
}