package com.generation.tucancha.dto.request;

import com.generation.tucancha.model.entity.RolUsuario;

public class UsuarioRequest {

    private String nombre;
    private String cedula;
    private String correo;
    private String password;
    private RolUsuario rol;

    public UsuarioRequest() {}

    public UsuarioRequest(String nombre, String cedula, String correo, String password, RolUsuario rol) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.password = password;
        this.rol = rol;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public RolUsuario getRol() { return rol; }
    public void setRol(RolUsuario rol) { this.rol = rol; }
}