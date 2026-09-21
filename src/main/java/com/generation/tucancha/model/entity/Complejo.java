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

    @Column(nullable = false)
    private String nombreComplejo;

    @Column
    private String provincia;

    @Column
    private String ciudad;

    @Column
    private String direccion;

    @Column
    private String telefonoComplejo;

    // =====================================================
    // RELACIÓN CON TITULAR
    // =====================================================

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "titular_complejo_id",
            nullable = false
    )
    private TitularComplejo titularComplejo;

    // =====================================================
    // RELACIÓN CON CANCHAS
    // =====================================================

    @OneToMany(
            mappedBy = "complejo",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Cancha> canchas = new ArrayList<>();

    // =====================================================
    // RELACIÓN CON PRESTACIONES
    // =====================================================

    @OneToMany(
            mappedBy = "complejo",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Prestacion> prestaciones =
            new ArrayList<>();

    // =====================================================
    // RELACIÓN CON FOTOS
    // =====================================================

    @OneToMany(
            mappedBy = "complejo",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<FotoComplejo> fotos =
            new ArrayList<>();

    // =====================================================
    // CONSTRUCTOR VACÍO
    // =====================================================

    public Complejo() {
    }

    // =====================================================
    // CONSTRUCTOR COMPLETO
    // =====================================================

    public Complejo(
            List<Prestacion> prestaciones,
            List<Cancha> canchas,
            List<FotoComplejo> fotos,
            TitularComplejo titularComplejo,
            String telefonoComplejo,
            String direccion,
            String ciudad,
            String provincia,
            String nombreComplejo,
            Long id
    ) {

        this.prestaciones = prestaciones;
        this.canchas = canchas;
        this.fotos = fotos;
        this.titularComplejo = titularComplejo;
        this.telefonoComplejo = telefonoComplejo;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.nombreComplejo = nombreComplejo;
        this.id = id;
    }

    // =====================================================
    // GETTERS Y SETTERS
    // =====================================================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreComplejo() {
        return nombreComplejo;
    }

    public void setNombreComplejo(String nombreComplejo) {
        this.nombreComplejo = nombreComplejo;
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

    public String getTelefonoComplejo() {
        return telefonoComplejo;
    }

    public void setTelefonoComplejo(String telefonoComplejo) {
        this.telefonoComplejo = telefonoComplejo;
    }

    public TitularComplejo getTitularComplejo() {
        return titularComplejo;
    }

    public void setTitularComplejo(
            TitularComplejo titularComplejo
    ) {
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

    public void setPrestaciones(
            List<Prestacion> prestaciones
    ) {
        this.prestaciones = prestaciones;
    }

    public List<FotoComplejo> getFotos() {
        return fotos;
    }

    public void setFotos(List<FotoComplejo> fotos) {
        this.fotos = fotos;
    }
}