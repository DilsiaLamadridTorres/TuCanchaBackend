package com.generation.tucancha.service;

import com.generation.tucancha.dto.request.PagoRequest;
import com.generation.tucancha.dto.response.PagoResponse;
import com.generation.tucancha.enums.EstadoPago;
import com.generation.tucancha.enums.EstadoReserva;
import com.generation.tucancha.exception.ResourceNotFoundException;
import com.generation.tucancha.model.entity.Pago;
import com.generation.tucancha.model.entity.Reserva;
import com.generation.tucancha.repository.PagoRepository;
import com.generation.tucancha.repository.ReservaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PagoService {

    private final PagoRepository pagoRepository;
    private final ReservaRepository reservaRepository;

    public PagoService(PagoRepository pagoRepository, ReservaRepository reservaRepository) {
        this.pagoRepository = pagoRepository;
        this.reservaRepository = reservaRepository;
    }

    @Transactional
    public PagoResponse procesarPago(PagoRequest request) {
        Reserva reserva = reservaRepository.findById(request.getReservaId())
                .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada con ID: " + request.getReservaId()));

        Pago pago = Pago.builder()
                .reserva(reserva)
                .metodoPago(request.getMetodoPago())
                .monto(request.getMonto())
                .estado(EstadoPago.APROBADO)
                .build();

        reserva.setEstado(EstadoReserva.CONFIRMADA);
        reservaRepository.save(reserva);

        return mapToResponse(pagoRepository.save(pago));
    }

    private PagoResponse mapToResponse(Pago pago) {
        PagoResponse response = new PagoResponse();
        response.setIdPago(pago.getIdPago());
        response.setReservaId(pago.getReserva().getIdReserva());
        response.setMetodoPago(pago.getMetodoPago());
        response.setMonto(pago.getMonto());
        response.setEstado(pago.getEstado());
        response.setFechaPago(pago.getFechaPago());
        return response;
    }
}