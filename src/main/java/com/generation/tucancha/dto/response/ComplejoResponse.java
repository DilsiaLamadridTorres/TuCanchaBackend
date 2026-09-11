package com.generation.tucancha.dto.response;

public class ComplejoResponse {
        private Long id;
        private String nombreComplejo;
        private String nit;
        private String provincia;
        private String ciudad;
        private String direccion;

        private Long titularComplejoId;


        public ComplejoResponse() {
        }

        public ComplejoResponse(Long id, String nombreComplejo, String nit, String provincia, String ciudad, String direccion, Long titularComplejoId) {
            this.id = id;
            this.nombreComplejo = nombreComplejo;
            this.nit = nit;
            this.provincia = provincia;
            this.ciudad = ciudad;
            this.direccion = direccion;
            this.titularComplejoId = titularComplejoId;
        }

        public Long getId() {
            return id;
        }

        public String getNombreComplejo() {
            return nombreComplejo;
        }

        public void setNombreComplejo(String nombreComplejo) {
            this.nombreComplejo = nombreComplejo;
        }

        public String getNit() {
            return nit;
        }

        public void setNit(String nit) {
            this.nit = nit;
        }

        public String getProvincia() {
            return provincia;
        }

        public void setProvincia(String provincia) {
            this.provincia = provincia;
        }

        public String getCiudad() {
            return ciudad;
        }

        public void setCiudad(String ciudad) {
            this.ciudad = ciudad;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }
        public Long getTitularComplejoId() {
            return titularComplejoId;
        }

        public void setTitularComplejoId(Long titularComplejoId) {
            this.titularComplejoId = titularComplejoId;
        }

    }













