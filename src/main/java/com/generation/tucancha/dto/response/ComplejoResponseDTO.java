package com.generation.tucancha.dto.response;

public class ComplejoResponseDTO {

    private Long id;
    private String nombreComplejo;
    private String provincia;
    private String ciudad;
    private String direccion;
    private String telefonoComplejo;
    private Long titularComplejoId;

    private boolean estacionamiento;
    private boolean vestuario;
    private boolean asador;
    private boolean bar;
    private boolean duchas;
    private boolean tv;
    private boolean bufet;

    public ComplejoResponseDTO() {
    }

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

    public Long getTitularComplejoId() {
        return titularComplejoId;
    }

    public void setTitularComplejoId(Long titularComplejoId) {
        this.titularComplejoId = titularComplejoId;
    }

    public boolean isEstacionamiento() {
        return estacionamiento;
    }

    public void setEstacionamiento(boolean estacionamiento) {
        this.estacionamiento = estacionamiento;
    }

    public boolean isVestuario() {
        return vestuario;
    }

    public void setVestuario(boolean vestuario) {
        this.vestuario = vestuario;
    }

    public boolean isAsador() {
        return asador;
    }

    public void setAsador(boolean asador) {
        this.asador = asador;
    }

    public boolean isBar() {
        return bar;
    }

    public void setBar(boolean bar) {
        this.bar = bar;
    }

    public boolean isDuchas() {
        return duchas;
    }

    public void setDuchas(boolean duchas) {
        this.duchas = duchas;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isBufet() {
        return bufet;
    }

    public void setBufet(boolean bufet) {
        this.bufet = bufet;
    }
}