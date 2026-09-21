package com.generation.tucancha.dto.request;

import com.generation.tucancha.model.enums.EstadoCancha;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class CanchaRequestDTO {

    @NotNull(message = "El id del complejo es obligatorio")
    private Long idComplejo;

    @NotBlank(message = "El nombre de la cancha es obligatorio")
    @Size(max = 100)
    private String nombre;

    @NotBlank(message = "El deporte es obligatorio")
    @Size(max = 50)
    private String deporte;

    @Size(max = 50)
    private String tipoPiso;

    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 6, fraction = 2)
    private BigDecimal largo;

    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 6, fraction = 2)
    private BigDecimal ancho;

    @NotNull(message = "El precio por hora es obligatorio")
    @DecimalMin(value = "0.0")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal precioHora;

    @NotNull(message = "La duración es obligatoria")
    @Min(value = 1)
    private Integer duracionMinutos;

    @NotNull(message = "Debe indicar si la cancha es techada")
    private Boolean techada;

    private Boolean otrosDeportes;

    private EstadoCancha estado;

    public CanchaRequestDTO() {
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
}