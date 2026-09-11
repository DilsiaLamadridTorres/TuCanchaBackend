package com.generation.tucancha.dto.request;

import com.generation.tucancha.model.enums.MetodoPago;

import java.math.BigDecimal;

public class PagoRequest {
    private BigDecimal monto;
    private MetodoPago metodoPago;
    private Long reservaId;

    public PagoRequest ( ) {
    }

    public BigDecimal getMonto ( ) {
        return monto;
    }

    public void setMonto (BigDecimal monto) {
        this.monto = monto;
    }

    public MetodoPago getMetodoPago ( ) {
        return metodoPago;
    }

    public void setMetodoPago (MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Long getReservaId ( ) {
        return reservaId;
    }

    public void setReservaId (Long reservaId) {
        this.reservaId = reservaId;
    }
}