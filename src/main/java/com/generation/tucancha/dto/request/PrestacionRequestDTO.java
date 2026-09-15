package com.generation.tucancha.dto.request;

public class PrestacionRequestDTO {
    private String nombre;
    private String descripcion;

    public PrestacionRequestDTO ( ) {
    }

    public PrestacionRequestDTO (String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
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
}