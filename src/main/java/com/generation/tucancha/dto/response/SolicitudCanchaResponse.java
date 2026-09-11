package com.generation.tucancha.dto.response;

public class SolicitudCanchaResponse {
    private Long id;
        private Long solicitudId;
        private Long canchaId;

        public SolicitudCanchaResponse() {
        }

        public SolicitudCanchaResponse(Long id, Long solicitudId, Long canchaId) {
            this.id = id;
            this.solicitudId = solicitudId;
            this.canchaId = canchaId;
        }

        public Long getId() {
            return id;
        }


        public Long getSolicitudId() {
            return solicitudId;
        }

        public void setSolicitudId(Long solicitudId) {
            this.solicitudId = solicitudId;
        }

        public Long getCanchaId() {
            return canchaId;
        }

        public void setCanchaId(Long canchaId) {
            this.canchaId = canchaId;
        }
    }

