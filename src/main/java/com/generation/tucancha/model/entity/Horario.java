package com.generation.tucancha.model.entity;

import com.generation.tucancha.model.enums.EstadoHorario;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "horarios")
public class Horario {

    /* =========================================================
       ID
       ========================================================= */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private Long idHorario;


    /* =========================================================
       RELACIÓN CON CANCHA

       Una cancha puede tener muchos horarios.
       Un horario pertenece a una sola cancha.
       ========================================================= */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_cancha",
            nullable = false
    )
    private Cancha cancha;


    /* =========================================================
       FECHA DEL TURNO
       ========================================================= */

    @Column(
            name = "fecha",
            nullable = false
    )
    private LocalDate fecha;


    /* =========================================================
       HORA DE INICIO
       ========================================================= */

    @Column(
            name = "hora_inicio",
            nullable = false
    )
    private LocalTime horaInicio;


    /* =========================================================
       HORA DE FIN
       ========================================================= */

    @Column(
            name = "hora_fin",
            nullable = false
    )
    private LocalTime horaFin;


    /* =========================================================
       ESTADO DEL HORARIO
       ========================================================= */

    @Enumerated(EnumType.STRING)
    @Column(
            name = "estado",
            nullable = false,
            length = 20
    )
    private EstadoHorario estado;


    /* =========================================================
       CONSTRUCTOR VACÍO
       ========================================================= */

    public Horario() {
    }


    /* =========================================================
       CONSTRUCTOR
       ========================================================= */

    public Horario(
            Long idHorario,
            Cancha cancha,
            LocalDate fecha,
            LocalTime horaInicio,
            LocalTime horaFin,
            EstadoHorario estado
    ) {

        this.idHorario = idHorario;
        this.cancha = cancha;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estado = estado;
    }

    public Horario(LocalDateTime inicio, LocalDateTime fin) {
       this(null, null, inicio.toLocalDate(), inicio.toLocalTime(), fin.toLocalTime(), EstadoHorario.DISPONIBLE);
    }


    /* =========================================================
       GETTERS Y SETTERS
       ========================================================= */

    public Long getId() {
        return idHorario;
    }

    public void setId(Long idHorario) {
        this.idHorario = idHorario;
    }

    public Long getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Long idHorario) {
        this.idHorario = idHorario;
    }


    public Cancha getCancha() {
        return cancha;
    }

    public void setCancha(Cancha cancha) {
        this.cancha = cancha;
    }


    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }


    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }


    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }


    public EstadoHorario getEstado() {
        return estado;
    }

    public void setEstado(EstadoHorario estado) {
        this.estado = estado;
    }

    // Compatibilidad con código previo del proyecto
    public Long getId() {
        return idHorario;
    }

    public void setId(Long idHorario) {
        this.idHorario = idHorario;
    }

    public Horario(Long id, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, EstadoHorario estado) {
        this.idHorario = id;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estado = estado;
    }

    public Horario(LocalDateTime inicio, LocalDateTime fin) {
        this.fecha = inicio.toLocalDate();
        this.horaInicio = inicio.toLocalTime();
        this.horaFin = fin.toLocalTime();
        this.estado = EstadoHorario.DISPONIBLE;
    }
}