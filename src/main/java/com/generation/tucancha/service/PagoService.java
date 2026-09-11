package com.generation.tucancha.service;

import com.generation.tucancha.dto.request.PagoRequest;
import com.generation.tucancha.dto.response.PagoResponse;
import com.generation.tucancha.model.entity.Pago;
import com.generation.tucancha.model.entity.Reserva;
import com.generation.tucancha.model.enums.EstadoPago;
import com.generation.tucancha.model.enums.EstadoReserva;
import com.generation.tucancha.exception.ResourceNotFoundException;
import com.generation.tucancha.repository.PagoRepository;
import com.generation.tucancha.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagoService {

    private final PagoRepository pagoRepository;
    private final ReservaRepository reservaRepository;

    public PagoService(PagoRepository pagoRepository, ReservaRepository reservaRepository) {
        this.pagoRepository = pagoRepository;
        this.reservaRepository = reservaRepository;
    }

    public List<PagoResponse> obtenerTodos() {
        return pagoRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public PagoResponse registrarPago(PagoRequest request) {
        Reserva reserva = reservaRepository.findById(request.getReservaId())
                .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada con ID: " + request.getReservaId()));

        Pago pago = new Pago();
        pago.setMonto(request.getMonto());
        pago.setMetodoPago(request.getMetodoPago());
        pago.setReserva(reserva);

        // Simulación: Asignamos el estado del pago como EXITOSO y actualizamos la reserva
        pago.setEstado(EstadoPago.EXITOSO);
        reserva.setEstado(EstadoReserva.CONFIRMADA);

        reservaRepository.save(reserva);
        Pago guardado = pagoRepository.save(pago);

        return mapToResponse(guardado);
    }

    private PagoResponse mapToResponse(Pago pago) {
        return new PagoResponse(
                pago.getId(),
                pago.getMonto(),
                pago.getFechaPago(),
                pago.getMetodoPago(),
                pago.getEstado(),
                pago.getReserva().getId()
        );
    }
}