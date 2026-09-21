package com.generation.tucancha.dto.response;

public class FotoComplejoResponseDTO {

    private Long idFoto;
    private Long idComplejo;
    private String nombreArchivo;
    private String tipoContenido;
    private String url;

    public FotoComplejoResponseDTO() {
    }

    public Long getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(Long idFoto) {
        this.idFoto = idFoto;
    }

    public Long getIdComplejo() {
        return idComplejo;
    }

    public void setIdComplejo(Long idComplejo) {
        this.idComplejo = idComplejo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getTipoContenido() {
        return tipoContenido;
    }

    public void setTipoContenido(String tipoContenido) {
        this.tipoContenido = tipoContenido;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}