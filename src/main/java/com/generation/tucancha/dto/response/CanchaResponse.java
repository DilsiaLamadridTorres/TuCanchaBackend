package com.generation.tucancha.dto.response;

import com.generation.tucancha.model.enums.EstadoCancha;

import java.math.BigDecimal;

/**
 * DTO utilizado para devolver la información
 * de una cancha al cliente.
 */
public class CanchaResponse {

    private Long idCancha;

    private Long complejoId;

    private String nombre;

    private String deporte;

    private String tipoPiso;

    private BigDecimal largo;

    private BigDecimal ancho;

    private BigDecimal precioHora;

    private Integer duracionMinutos;

    private Boolean techada;

    private String otrosDeportes;

    private EstadoCancha estado;


    /* =========================================================
       CONSTRUCTOR VACÍO
       ========================================================= */

    public CanchaResponse() {
    }


    /* =========================================================
       CONSTRUCTOR
       ========================================================= */

    public CanchaResponse(
            Long idCancha,
            Long complejoId,
            String nombre,
            String deporte,
            String tipoPiso,
            BigDecimal largo,
            BigDecimal ancho,
            BigDecimal precioHora,
            Integer duracionMinutos,
            Boolean techada,
            String otrosDeportes,
            EstadoCancha estado
    ) {
        this.idCancha = idCancha;
        this.complejoId = complejoId;
        this.nombre = nombre;
        this.deporte = deporte;
        this.tipoPiso = tipoPiso;
        this.largo = largo;
        this.ancho = ancho;
        this.precioHora = precioHora;
        this.duracionMinutos = duracionMinutos;
        this.techada = techada;
        this.otrosDeportes = otrosDeportes;
        this.estado = estado;
    }


    /* =========================================================
       GETTERS Y SETTERS
       ========================================================= */

    public Long getIdCancha() {
        return idCancha;
    }

    public void setIdCancha(Long idCancha) {
        this.idCancha = idCancha;
    }

    public Long getComplejoId() {
        return complejoId;
    }

    public void setComplejoId(Long complejoId) {
        this.complejoId = complejoId;
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

    public String getOtrosDeportes() {
        return otrosDeportes;
    }

    public void setOtrosDeportes(String otrosDeportes) {
        this.otrosDeportes = otrosDeportes;
    }

    public EstadoCancha getEstado() {
        return estado;
    }

    public void setEstado(EstadoCancha estado) {
        this.estado = estado;
    }
}