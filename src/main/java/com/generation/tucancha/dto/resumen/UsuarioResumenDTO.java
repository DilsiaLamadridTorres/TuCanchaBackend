package com.generation.tucancha.dto.resumen;

import com.generation.tucancha.model.enums.RolUsuario;

public class UsuarioResumenDTO {

    private Long id;
    private String nombre;
    private String correo;
    private RolUsuario rol;

    public UsuarioResumenDTO() {}

    public UsuarioResumenDTO(Long id, String nombre, String correo, RolUsuario rol) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public RolUsuario getRol() { return rol; }
    public void setRol(RolUsuario rol) { this.rol = rol; }
}
