package com.generation.tucancha.dto.request;

public class SolicitudCanchaRequest {
    private Long solicitudId;
    private Long canchaId;

    public SolicitudCanchaRequest() {
    }

    public SolicitudCanchaRequest(Long solicitudId, Long canchaId) {
        this.solicitudId = solicitudId;
        this.canchaId = canchaId;
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
