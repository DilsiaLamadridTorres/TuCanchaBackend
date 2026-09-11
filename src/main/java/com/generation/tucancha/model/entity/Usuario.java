package com.generation.tucancha.model.entity;

import com.generation.tucancha.model.enums.RolUsuario;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String password;
    private String cedula;
    private String correo;
    private boolean estado;
    private LocalDateTime fechaRegistro;

    @Enumerated(EnumType.STRING)
    private RolUsuario rol;

    public Usuario ( ) {
    }

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

    public String getEmail ( ) {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getPassword ( ) {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getCedula ( ) {
        return cedula;
    }

    public void setCedula (String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo ( ) {
        return correo;
    }

    public void setCorreo (String correo) {
        this.correo = correo;
    }

    public boolean isEstado ( ) {
        return estado;
    }

    public void setEstado (boolean estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaRegistro ( ) {
        return fechaRegistro;
    }

    public void setFechaRegistro (LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public RolUsuario getRol ( ) {
        return rol;
    }

    public void setRol (RolUsuario rol) {
        this.rol = rol;
    }
}