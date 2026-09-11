package com.generation.tucancha.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagoResponse<EstadoPago> {

    private Long id;
    private BigDecimal monto;
    private LocalDateTime fechaPago;
    private EstadoPago estadoPago;
    private Long reservaId;

    public PagoResponse() {}

    public PagoResponse(Long id, BigDecimal monto, LocalDateTime fechaPago, EstadoPago estadoPago, Long reservaId) {
        this.id = id;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.estadoPago = estadoPago;
        this.reservaId = reservaId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }

    public LocalDateTime getFechaPago() { return fechaPago; }
    public void setFechaPago(LocalDateTime fechaPago) { this.fechaPago = fechaPago; }

    public EstadoPago getEstadoPago() { return estadoPago; }
    public void setEstadoPago(EstadoPago estadoPago) { this.estadoPago = estadoPago; }

    public Long getReservaId() { return reservaId; }
    public void setReservaId(Long reservaId) { this.reservaId = reservaId; }
}