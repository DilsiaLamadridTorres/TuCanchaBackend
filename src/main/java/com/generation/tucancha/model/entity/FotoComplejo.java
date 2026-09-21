package com.generation.tucancha.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fotos_complejos")
public class FotoComplejo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_foto")
    private Long idFoto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_complejo", nullable = false)
    private Complejo complejo;

    @Lob
    @Column(name = "imagen", nullable = false)
    private byte[] imagen;

    @Column(name = "nombre_archivo", length = 255)
    private String nombreArchivo;

    @Column(name = "tipo_contenido", length = 100)
    private String tipoContenido;

    public FotoComplejo() {
    }

    public FotoComplejo(
            Complejo complejo,
            byte[] imagen,
            String nombreArchivo,
            String tipoContenido
    ) {
        this.complejo = complejo;
        this.imagen = imagen;
        this.nombreArchivo = nombreArchivo;
        this.tipoContenido = tipoContenido;
    }

    public Long getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(Long idFoto) {
        this.idFoto = idFoto;
    }

    public Complejo getComplejo() {
        return complejo;
    }

    public void setComplejo(Complejo complejo) {
        this.complejo = complejo;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
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
}