package com.generation.tucancha.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "prestaciones")
public class Prestacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestaciones")
    private Long id;

    @Column(nullable = false)
    private String nombre;

    // Relación con Complejo
    // Muchas prestaciones pertenecen a un Complejo

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "complejo_id", nullable = false)
    private Complejo complejo;


      public Prestacion() {
    }

    public Prestacion(String nombre, Complejo complejo) {
        this.nombre = nombre;
        this.complejo = complejo;
    }


    public Long getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Complejo getComplejo() {
        return complejo;
    }

    public void setComplejo(Complejo complejo) {
        this.complejo = complejo;
    }
}