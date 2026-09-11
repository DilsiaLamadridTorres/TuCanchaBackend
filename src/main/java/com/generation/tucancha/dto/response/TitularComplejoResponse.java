package com.generation.tucancha.dto.response;

import java.time.LocalDate;

    public class TitularComplejoResponse {
        private Long id;
        private String nombre;
        private String apellido;
        private String cedula;
        private String correo;
        private String telefono;
        private LocalDate fechaRegistro;

        public TitularComplejoResponse() {
        }

        public TitularComplejoResponse(Long id, String nombre, String apellido, String cedula, String correo, String telefono, LocalDate fechaRegistro) {

            this.id = id;
            this.nombre = nombre;
            this.apellido = apellido;
            this.cedula = cedula;
            this.correo = correo;
            this.telefono = telefono;
            this.fechaRegistro = fechaRegistro;
        }

        public Long getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }


        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }


        public String getCedula() {
            return cedula;
        }

        public void setCedula(String cedula) {
            this.cedula = cedula;
        }


        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }


        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }


        public LocalDate getFechaRegistro() {
            return fechaRegistro;
        }

        public void setFechaRegistro(LocalDate fechaRegistro) {
            this.fechaRegistro = fechaRegistro;
        }
    }

