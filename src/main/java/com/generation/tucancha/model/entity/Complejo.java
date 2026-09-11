package com.generation.tucancha.model.entity;


import jakarta.persistence.*;

import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "complejos")
public class Complejo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String nombreComplejo;
    @Column
    private String nit;
    @Column
    private String provincia;
    @Column
    private String ciudad;
    @Column
    private String direccion;

    // Relaciones con otras entidades

    // Relación con TitularComplejo

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "titular_complejo_id", nullable = false)
    private TitularComplejo titularComplejo;

    // Relación con Canchas

    @OneToMany(mappedBy = "complejo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cancha> canchas = new ArrayList<>();

    // Relación con Prestaciones

    @OneToMany(mappedBy = "complejo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prestacion> prestaciones = new ArrayList<>();

public Complejo() {
}

public Complejo(String nombreComplejo, String nit, String provincia, String ciudad, String direccion, TitularComplejo titularComplejo) {
     this.nombreComplejo = nombreComplejo;
    this.nit = nit;
    this.provincia = provincia;
    this.ciudad = ciudad;
    this.direccion = direccion;
    this.titularComplejo = titularComplejo;
}

    public Long getId() {
        return id;
    }

    public String getNombreComplejo() {
        return nombreComplejo;
    }

    public void setNombreComplejo(String nombreComplejo) {
        this.nombreComplejo = nombreComplejo;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public TitularComplejo getTitularComplejo() {
        return titularComplejo;
    }

    public void setTitularComplejo(TitularComplejo titularComplejo) {
        this.titularComplejo = titularComplejo;
    }

    public List<Cancha> getCanchas() {
        return canchas;
    }

    public void setCanchas(List<Cancha> canchas) {
        this.canchas = canchas;
    }

    public List<Prestacion> getPrestaciones() {
        return prestaciones;
    }

    public void setPrestaciones(List<Prestacion> prestaciones) {
        this.prestaciones = prestaciones;
    }
}
