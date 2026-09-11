package com.generation.tucancha.dto.request;

public class PrestacionRequest {

        private String nombre;
     private Long complejoId;

        public PrestacionRequest() {
        }

        public PrestacionRequest(String nombre, Long complejoId) {
            this.nombre = nombre;
            this.complejoId = complejoId;
        }



        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }


        public Long getComplejoId() {
            return complejoId;
        }

        public void setComplejoId(Long complejoId) {
            this.complejoId = complejoId;
        }
    }
