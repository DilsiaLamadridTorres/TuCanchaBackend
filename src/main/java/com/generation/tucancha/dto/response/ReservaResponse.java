package com.generation.tucancha.dto.response;

import java.time.LocalDateTime;

public class ReservaResponse<EstadoReserva> {

    private Long id;
    private LocalDateTime fechaCreacion;
    private EstadoReserva estado;
    private Long usuarioId;
    private Long horarioId;

    public ReservaResponse() {}

    public ReservaResponse(Long id, LocalDateTime fechaCreacion, EstadoReserva estado, Long usuarioId, Long horarioId) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.usuarioId = usuarioId;
        this.horarioId = horarioId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public EstadoReserva getEstado() { return estado; }
    public void setEstado(EstadoReserva estado) { this.estado = estado; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public Long getHorarioId() { return horarioId; }
    public void setHorarioId(Long horarioId) { this.horarioId = horarioId; }
}