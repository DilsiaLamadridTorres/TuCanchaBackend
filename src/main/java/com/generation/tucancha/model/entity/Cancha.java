package com.generation.tucancha.model.entity;

import com.generation.tucancha.model.enums.EstadoCancha;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "canchas")
public class Cancha {

    /* =========================================================
       ID
       ========================================================= */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cancha")
    private Long idCancha;


    /* =========================================================
       RELACIÓN CON COMPLEJO

       Un complejo puede tener muchas canchas.
       Una cancha pertenece a un solo complejo.
       ========================================================= */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_complejo",
            nullable = false
    )
    private Complejo complejo;


    /* =========================================================
       INFORMACIÓN DE LA CANCHA
       ========================================================= */

    @Column(
            name = "nombre",
            nullable = false,
            length = 100
    )
    private String nombre;


    @Column(
            name = "deporte",
            nullable = false,
            length = 50
    )
    private String deporte;


    @Column(
            name = "tipo_piso",
            length = 50
    )
    private String tipoPiso;


    @Column(
            name = "largo",
            precision = 8,
            scale = 2
    )
    private BigDecimal largo;


    @Column(
            name = "ancho",
            precision = 8,
            scale = 2
    )
    private BigDecimal ancho;


    @Column(
            name = "precio_hora",
            nullable = false,
            precision = 12,
            scale = 2
    )
    private BigDecimal precioHora;


    @Column(
            name = "duracion_minutos",
            nullable = false
    )
    private Integer duracionMinutos;


    @Column(
            name = "techada",
            nullable = false
    )
    private Boolean techada;


    @Column(
            name = "otros_deportes",
            length = 255
    )
    private String otrosDeportes;


    /* =========================================================
       ESTADO DE LA CANCHA
       ========================================================= */

    @Enumerated(EnumType.STRING)
    @Column(
            name = "estado",
            nullable = false,
            length = 20
    )
    private EstadoCancha estado;


    /* =========================================================
       CONSTRUCTOR VACÍO
       JPA necesita este constructor.
       ========================================================= */

    public Cancha() {
    }


    /* =========================================================
       CONSTRUCTOR
       ========================================================= */

    public Cancha(
            Long idCancha,
            Complejo complejo,
            String nombre,
            String deporte,
            String tipoPiso,
            BigDecimal largo,
            BigDecimal ancho,
            BigDecimal precioHora,
            Integer duracionMinutos,
            Boolean techada,
            String otrosDeportes,
            EstadoCancha estado
    ) {

        this.idCancha = idCancha;
        this.complejo = complejo;
        this.nombre = nombre;
        this.deporte = deporte;
        this.tipoPiso = tipoPiso;
        this.largo = largo;
        this.ancho = ancho;
        this.precioHora = precioHora;
        this.duracionMinutos = duracionMinutos;
        this.techada = techada;
        this.otrosDeportes = otrosDeportes;
        this.estado = estado;
    }


    /* =========================================================
       GETTERS Y SETTERS
       ========================================================= */

    public Long getIdCancha() {
        return idCancha;
    }

    public void setIdCancha(Long idCancha) {
        this.idCancha = idCancha;
    }


    public Complejo getComplejo() {
        return complejo;
    }

    public void setComplejo(Complejo complejo) {
        this.complejo = complejo;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }


    public String getTipoPiso() {
        return tipoPiso;
    }

    public void setTipoPiso(String tipoPiso) {
        this.tipoPiso = tipoPiso;
    }


    public BigDecimal getLargo() {
        return largo;
    }

    public void setLargo(BigDecimal largo) {
        this.largo = largo;
    }


    public BigDecimal getAncho() {
        return ancho;
    }

    public void setAncho(BigDecimal ancho) {
        this.ancho = ancho;
    }


    public BigDecimal getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(BigDecimal precioHora) {
        this.precioHora = precioHora;
    }


    public Integer getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(Integer duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }


    public Boolean getTechada() {
        return techada;
    }

    public void setTechada(Boolean techada) {
        this.techada = techada;
    }


    public String getOtrosDeportes() {
        return otrosDeportes;
    }

    public void setOtrosDeportes(String otrosDeportes) {
        this.otrosDeportes = otrosDeportes;
    }


    public EstadoCancha getEstado() {
        return estado;
    }

    public void setEstado(EstadoCancha estado) {
        this.estado = estado;
    }
}