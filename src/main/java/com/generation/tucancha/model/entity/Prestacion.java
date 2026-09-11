package com.generation.tucancha.model.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "prestaciones")
public class Prestacion {

    // Relación bidireccional o unidireccional con Complejo (Módulo de Dilsia)
    @ManyToMany(mappedBy = "prestaciones")
    private final Set<Complejo> complejos = new HashSet<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(length = 255)
    private String descripcion;

    public Prestacion ( ) {
    }

    public Prestacion (String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters y Setters...
}
