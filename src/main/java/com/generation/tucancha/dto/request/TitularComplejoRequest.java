package com.generation.tucancha.dto.request;

public class TitularComplejoRequest {

    private String nombreTitular;
    private String cedulaTitular;
    private String correoTitular;
    private String telefonoTitular;

    public TitularComplejoRequest() {
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
}