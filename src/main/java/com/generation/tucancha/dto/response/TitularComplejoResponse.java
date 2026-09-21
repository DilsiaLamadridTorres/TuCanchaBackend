package com.generation.tucancha.dto.response;

import java.time.LocalDateTime;

public class TitularComplejoResponse {

    private Long id;
    private String nombreTitular;
    private String cedulaTitular;
    private String correoTitular;
    private String telefonoTitular;
    private LocalDateTime fechaRegistro;

    public TitularComplejoResponse() {
    }

    public TitularComplejoResponse(
            Long id,
            String nombreTitular,
            String cedulaTitular,
            String correoTitular,
            String telefonoTitular,
            LocalDateTime fechaRegistro) {

        this.id = id;
        this.nombreTitular = nombreTitular;
        this.cedulaTitular = cedulaTitular;
        this.correoTitular = correoTitular;
        this.telefonoTitular = telefonoTitular;
        this.fechaRegistro = fechaRegistro;
    }

    public Long getId() {
        return id;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public String getCedulaTitular() {
        return cedulaTitular;
    }

    public String getCorreoTitular() {
        return correoTitular;
    }

    public String getTelefonoTitular() {
        return telefonoTitular;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }
}