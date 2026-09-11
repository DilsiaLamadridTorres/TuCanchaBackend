package com.generation.tucancha.service;

import com.generation.tucancha.dto.request.ReservaRequest;
import com.generation.tucancha.dto.response.ReservaResponse;
import com.generation.tucancha.model.entity.Horario;
import com.generation.tucancha.model.entity.Reserva;
import com.generation.tucancha.model.entity.Usuario;
import com.generation.tucancha.model.enums.EstadoReserva;
import com.generation.tucancha.exception.ResourceNotFoundException;
import com.generation.tucancha.repository.HorarioRepository;
import com.generation.tucancha.repository.ReservaRepository;
import com.generation.tucancha.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final UsuarioRepository usuarioRepository;
    private final HorarioRepository horarioRepository;

    public ReservaService(ReservaRepository reservaRepository, UsuarioRepository usuarioRepository, HorarioRepository horarioRepository) {
        this.reservaRepository = reservaRepository;
        this.usuarioRepository = usuarioRepository;
        this.horarioRepository = horarioRepository;
    }

    public List<ReservaResponse> obtenerTodas() {
        return reservaRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public ReservaResponse obtenerPorId(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada con el ID: " + id));
        return mapToResponse(reserva);
    }

    public ReservaResponse crearReserva(ReservaRequest request) {
        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: " + request.getUsuarioId()));

        Horario horario = horarioRepository.findById(request.getHorarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Horario no encontrado con ID: " + request.getHorarioId()));

        Reserva reserva = new Reserva(usuario, horario, EstadoReserva.PENDIENTE);
        Reserva guardada = reservaRepository.save(reserva);

        return mapToResponse(guardada);
    }

    private ReservaResponse mapToResponse(Reserva reserva) {
        return new ReservaResponse(
                reserva.getId(),
                reserva.getFechaCreacion(),
                reserva.getEstado(),
                reserva.getUsuario().getId(),
                reserva.getHorario().getId()
        );
    }
}