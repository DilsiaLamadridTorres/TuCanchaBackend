package com.generation.tucancha.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

/**
 * DTO utilizado para recibir los datos
 * necesarios para crear o actualizar una cancha.
 */
public class CanchaRequest {

    /* =========================================================
       COMPLEJO AL QUE PERTENECE LA CANCHA
       ========================================================= */

    @NotNull(message = "El complejo es obligatorio")
    @Positive(message = "El id del complejo debe ser mayor que cero")
    private Long complejoId;


    /* =========================================================
       INFORMACIÓN GENERAL
       ========================================================= */

    @NotBlank(message = "El nombre de la cancha es obligatorio")
    private String nombre;


    @NotBlank(message = "El deporte es obligatorio")
    private String deporte;


    private String tipoPiso;


    @Positive(message = "El largo debe ser mayor que cero")
    private BigDecimal largo;


    @Positive(message = "El ancho debe ser mayor que cero")
    private BigDecimal ancho;


    /* =========================================================
       PRECIO Y DURACIÓN
       ========================================================= */

    @NotNull(message = "El precio por hora es obligatorio")
    @Positive(message = "El precio por hora debe ser mayor que cero")
    private BigDecimal precioHora;


    @NotNull(message = "La duración es obligatoria")
    @Positive(message = "La duración debe ser mayor que cero")
    private Integer duracionMinutos;


    /* =========================================================
       CARACTERÍSTICAS
       ========================================================= */

    @NotNull(message = "Debe indicar si la cancha es techada")
    private Boolean techada;


    /**
     * Campo opcional.
     *
     * Ejemplo:
     * "Microfútbol, voleibol"
     */
    private String otrosDeportes;


    /* =========================================================
       CONSTRUCTOR VACÍO
       ========================================================= */

    public CanchaRequest() {
    }


    /* =========================================================
       CONSTRUCTOR
       ========================================================= */

    public CanchaRequest(
            Long complejoId,
            String nombre,
            String deporte,
            String tipoPiso,
            BigDecimal largo,
            BigDecimal ancho,
            BigDecimal precioHora,
            Integer duracionMinutos,
            Boolean techada,
            String otrosDeportes
    ) {
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
    }


    /* =========================================================
       GETTERS Y SETTERS
       ========================================================= */

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
}