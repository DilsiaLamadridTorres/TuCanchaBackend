package com.generation.tucancha.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "solicitud_cancha")
public class SolicitudCancha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // Relación con Solicitud
    // Muchas SolicitudCancha pertenecen a una Solicitud

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solicitud_id", nullable = false)
    private Solicitud solicitud;


    // Relación con Cancha
    // Muchas SolicitudCancha pueden estar relacionadas con una Cancha

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cancha_id", nullable = false)
    private Cancha cancha;

    public SolicitudCancha() {
    }

    public SolicitudCancha(Solicitud solicitud, Cancha cancha) {
        this.solicitud = solicitud;
        this.cancha = cancha;
    }


    public Long getId() {
        return id;
    }


    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }



    public Cancha getCancha() {
        return cancha;
    }

    public void setCancha(Cancha cancha) {
        this.cancha = cancha;
    }
}