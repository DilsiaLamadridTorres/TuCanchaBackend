package com.generation.tucancha.dto.response;

import com.generation.tucancha.model.enums.EstadoPago;
import com.generation.tucancha.model.enums.MetodoPago;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagoResponse {
    private Long id;
    private BigDecimal monto;
    private LocalDateTime fecha;
    private MetodoPago metodoPago;
    private EstadoPago estadoPago;
    private Long reservaId;

    public PagoResponse ( ) {
    }

    public PagoResponse (Long id, BigDecimal monto, LocalDateTime fecha, MetodoPago metodoPago, EstadoPago estadoPago, Long reservaId) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
        this.estadoPago = estadoPago;
        this.reservaId = reservaId;
    }

    public Long getId ( ) {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public BigDecimal getMonto ( ) {
        return monto;
    }

    public void setMonto (BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDateTime getFecha ( ) {
        return fecha;
    }

    public void setFecha (LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public MetodoPago getMetodoPago ( ) {
        return metodoPago;
    }

    public void setMetodoPago (MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public EstadoPago getEstadoPago ( ) {
        return estadoPago;
    }

    public void setEstadoPago (EstadoPago estadoPago) {
        this.estadoPago = estadoPago;
    }

    public Long getReservaId ( ) {
        return reservaId;
    }

    public void setReservaId (Long reservaId) {
        this.reservaId = reservaId;
    }
}