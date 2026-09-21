package com.generation.tucancha.dto.response;

import com.generation.tucancha.model.enums.EstadoCancha;

import java.math.BigDecimal;

public class CanchaResponseDTO {

    private Long idCancha;
    private Long idComplejo;
    private String nombre;
    private String deporte;
    private String tipoPiso;
    private BigDecimal largo;
    private BigDecimal ancho;
    private BigDecimal precioHora;
    private Integer duracionMinutos;
    private Boolean techada;
    private Boolean otrosDeportes;
    private EstadoCancha estado;
    private String descripcion;
    private Boolean disponible;

    public CanchaResponseDTO() {
    }

    public Long getIdCancha() {
        return idCancha;
    }

    public void setIdCancha(Long idCancha) {
        this.idCancha = idCancha;
    }

    public Long getIdComplejo() {
        return idComplejo;
    }

    public void setIdComplejo(Long idComplejo) {
        this.idComplejo = idComplejo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getTipoPiso() {
        return tipoPiso;
    }

    public void setTipoPiso(String tipoPiso) {
        this.tipoPiso = tipoPiso;
    }

    public BigDecimal getLargo() {
        return largo;
    }

    public void setLargo(BigDecimal largo) {
        this.largo = largo;
    }

    public BigDecimal getAncho() {
        return ancho;
    }

    public void setAncho(BigDecimal ancho) {
        this.ancho = ancho;
    }

    public BigDecimal getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(BigDecimal precioHora) {
        this.precioHora = precioHora;
    }

    public Integer getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(Integer duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public Boolean getTechada() {
        return techada;
    }

    public void setTechada(Boolean techada) {
        this.techada = techada;
    }

    public Boolean getOtrosDeportes() {
        return otrosDeportes;
    }

    public void setOtrosDeportes(Boolean otrosDeportes) {
        this.otrosDeportes = otrosDeportes;
    }

    public EstadoCancha getEstado() {
        return estado;
    }

    public void setEstado(EstadoCancha estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
}