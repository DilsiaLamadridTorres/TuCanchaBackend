package com.generation.tucancha.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fotos_canchas")
public class FotoCancha {

    /* =========================================================
       ID
       ========================================================= */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    /* =========================================================
       RELACIÓN CON CANCHA

       Una cancha puede tener muchas fotos.
       Una foto pertenece a una cancha.
       ========================================================= */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_cancha",
            nullable = false
    )
    private Cancha cancha;


    /* =========================================================
       URL DE LA FOTO
       ========================================================= */

    @Column(
            name = "url_foto",
            nullable = false,
            length = 500
    )
    private String urlFoto;


    /* =========================================================
       CONSTRUCTOR VACÍO
       ========================================================= */

    public FotoCancha() {
    }


    /* =========================================================
       CONSTRUCTOR
       ========================================================= */

    public FotoCancha(
            Long id,
            Cancha cancha,
            String urlFoto
    ) {

        this.id = id;
        this.cancha = cancha;
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


    public Cancha getCancha() {
        return cancha;
    }

    public void setCancha(Cancha cancha) {
        this.cancha = cancha;
    }


    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}