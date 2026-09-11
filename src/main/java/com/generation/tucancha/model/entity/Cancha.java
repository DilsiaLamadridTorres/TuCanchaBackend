package com.generation.tucancha.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "canchas")
public class Cancha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    private String descripcion;

    @Column(name = "precio_por_hora", nullable = false)
    private BigDecimal precioPorHora;

    @Column(nullable = false)
    private boolean disponible = true;

    public Cancha ( ) {
    }

    public Cancha (Long id, String nombre, String descripcion, BigDecimal precioPorHora, boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioPorHora = precioPorHora;
        this.disponible = disponible;
    }

    // Getters y Setters
    public Long getId ( ) {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getNombre ( ) {
        return nombre;
    }

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion ( ) {
        return descripcion;
    }

    public void setDescripcion (String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecioPorHora ( ) {
        return precioPorHora;
    }

    public void setPrecioPorHora (BigDecimal precioPorHora) {
        this.precioPorHora = precioPorHora;
    }

    public boolean isDisponible ( ) {
        return disponible;
    }

    public void setDisponible (boolean disponible) {
        this.disponible = disponible;
    }
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