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

    @PrePersist
    protected void onCreate ( ) {
        this.fechaCreacion = LocalDateTime.now();
        if (this.estado == null) {
            this.estado = EstadoSolicitud.PENDIENTE;
        }
    }

    // Getters y Setters...
}
