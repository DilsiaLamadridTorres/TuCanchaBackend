package com.generation.tucancha.dto.response;

public class RolResponse {

    private Long id;
    private String nombre;

    public RolResponse ( ) {
    }

    public RolResponse (Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId ( ) {
        return id;
    }

    public String getNombre ( ) {
        return nombre;
    }
}