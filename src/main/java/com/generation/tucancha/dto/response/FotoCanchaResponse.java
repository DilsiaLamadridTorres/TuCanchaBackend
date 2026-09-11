package com.generation.tucancha.dto.response;

/**
 * DTO utilizado para devolver la información
 * de una fotografía asociada a una cancha.
 */
public class FotoCanchaResponse {

    private Long id;

    private Long canchaId;

    private String urlFoto;


    /* =========================================================
       CONSTRUCTOR VACÍO
       ========================================================= */

    public FotoCanchaResponse() {
    }


    /* =========================================================
       CONSTRUCTOR
       ========================================================= */

    public FotoCanchaResponse(
            Long id,
            Long canchaId,
            String urlFoto
    ) {
        this.id = id;
        this.canchaId = canchaId;
        this.urlFoto = urlFoto;
    }


    /* =========================================================
       GETTERS Y SETTERS
       ========================================================= */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCanchaId() {
        return canchaId;
    }

    public void setCanchaId(Long canchaId) {
        this.canchaId = canchaId;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}