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

    public Cancha ( ) {
    }

    public Cancha (Long id, String nombre, String descripcion, BigDecimal precioPorHora, boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioPorHora = precioPorHora;
        this.disponible = disponible;
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
}
