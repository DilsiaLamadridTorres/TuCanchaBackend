package com.generation.tucancha.dto.response;

import com.generation.tucancha.model.entity.RolUsuario;
import java.time.LocalDateTime;

public class UsuarioResponse {

    private Long id;
    private String nombre;
    private String cedula;
    private String correo;
    private boolean estado;
    private LocalDateTime fechaRegistro;
    private RolUsuario rol;

    public UsuarioResponse() {}

    public UsuarioResponse(Long id, String nombre, String cedula, String correo, boolean estado, LocalDateTime fechaRegistro, RolUsuario rol) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
        this.rol = rol;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public boolean isEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }

    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    public RolUsuario getRol() { return rol; }
    public void setRol(RolUsuario rol) { this.rol = rol; }
}