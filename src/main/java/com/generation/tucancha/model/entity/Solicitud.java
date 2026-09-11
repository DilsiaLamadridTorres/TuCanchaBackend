package com.generation.tucancha.model.entity;

import com.generation.tucancha.model.enums.EstadoSolicitud;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "solicitudes")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EstadoSolicitud estado; // ENUM: PENDIENTE, APROBADA, RECHAZADA

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    public Solicitud ( ) {
    }

    public Solicitud (Long id, LocalDateTime fechaCreacion, EstadoSolicitud estado, Long usuarioId) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.usuarioId = usuarioId;
    }

    @PrePersist
    protected void onCreate ( ) {
        this.fechaCreacion = LocalDateTime.now();
        if (this.estado == null) {
            this.estado = EstadoSolicitud.PENDIENTE;
        }
    }

    // Getters y Setters
    public Long getId ( ) {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaCreacion ( ) {
        return fechaCreacion;
    }

    public void setFechaCreacion (LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public EstadoSolicitud getEstado ( ) {
        return estado;
    }

    public void setEstado (EstadoSolicitud estado) {
        this.estado = estado;
    }

    public Long getUsuarioId ( ) {
        return usuarioId;
    }

    public void setUsuarioId (Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}