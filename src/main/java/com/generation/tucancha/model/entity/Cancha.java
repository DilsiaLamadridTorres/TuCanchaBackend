package com.generation.tucancha.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "canchas")
public class Cancha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    private String descripcion;

    @Column(name = "precio_por_hora", nullable = false)
    private BigDecimal precioPorHora;

    @Column(nullable = false)
    private boolean disponible = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "complejo_id", nullable = false)
    private Complejo complejo;

    public Cancha ( ) {
    }

    public Cancha (Long id, String nombre, String descripcion, BigDecimal precioPorHora, boolean disponible, Complejo complejo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioPorHora = precioPorHora;
        this.disponible = disponible;
        this.complejo = complejo;
    }

    // Getters y Setters
    public Long getId ( ) {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getNombre ( ) {
        return nombre;
    }

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion ( ) {
        return descripcion;
    }

    public void setDescripcion (String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecioPorHora ( ) {
        return precioPorHora;
    }

    public void setPrecioPorHora (BigDecimal precioPorHora) {
        this.precioPorHora = precioPorHora;
    }

    public boolean isDisponible ( ) {
        return disponible;
    }

    public void setDisponible (boolean disponible) {
        this.disponible = disponible;
    }

    public Complejo getComplejo() {
        return complejo;
    }

    public void setComplejo(Complejo complejo) {
        this.complejo = complejo;
    }
}
