package com.generation.tucancha.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "titular_complejo")
public class TitularComplejo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreTitular;

    private String cedulaTitular;

    private String correoTitular;

    private String telefonoTitular;

    @Column(nullable = false)
    private LocalDateTime fechaRegistro;

    @OneToMany(
            mappedBy = "titularComplejo",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Complejo> complejos = new ArrayList<>();

    public TitularComplejo() {
    }

    public TitularComplejo(
            String nombreTitular,
            String cedulaTitular,
            String correoTitular,
            String telefonoTitular) {

        this.nombreTitular = nombreTitular;
        this.cedulaTitular = cedulaTitular;
        this.correoTitular = correoTitular;
        this.telefonoTitular = telefonoTitular;
    }

    @PrePersist
    public void asignarFechaRegistro() {
        this.fechaRegistro = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getCedulaTitular() {
        return cedulaTitular;
    }

    public void setCedulaTitular(String cedulaTitular) {
        this.cedulaTitular = cedulaTitular;
    }

    public String getCorreoTitular() {
        return correoTitular;
    }

    public void setCorreoTitular(String correoTitular) {
        this.correoTitular = correoTitular;
    }

    public String getTelefonoTitular() {
        return telefonoTitular;
    }

    public void setTelefonoTitular(String telefonoTitular) {
        this.telefonoTitular = telefonoTitular;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<Complejo> getComplejos() {
        return complejos;
    }

    public void setComplejos(List<Complejo> complejos) {
        this.complejos = complejos;
    }
}