package com.generation.tucancha.controller;

import com.generation.tucancha.model.entity.Cancha;
import com.generation.tucancha.model.entity.Complejo;
import com.generation.tucancha.model.entity.Horario;
import com.generation.tucancha.model.enums.EstadoCancha;
import com.generation.tucancha.model.enums.EstadoHorario;
import com.generation.tucancha.repository.CanchaRepository;
import com.generation.tucancha.repository.ComplejoRepository;
import com.generation.tucancha.repository.HorarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestDataController {

    private final HorarioRepository horarioRepository;
    private final CanchaRepository canchaRepository;
    private final ComplejoRepository complejoRepository;

    public TestDataController(HorarioRepository horarioRepository,
                              CanchaRepository canchaRepository,
                              ComplejoRepository complejoRepository) {
        this.horarioRepository = horarioRepository;
        this.canchaRepository = canchaRepository;
        this.complejoRepository = complejoRepository;
    }

    @PostMapping("/horarios")
    @ResponseStatus(HttpStatus.CREATED)
    public Horario crearHorario(@RequestBody Map<String, String> body) {
        String inicio = body.get("inicio");
        String fin = body.get("fin");
        try {
            LocalDateTime ini = LocalDateTime.parse(inicio);
            LocalDateTime fn = LocalDateTime.parse(fin);
            Horario h = new Horario();
            h.setFecha(ini.toLocalDate());
            h.setHoraInicio(ini.toLocalTime());
            h.setHoraFin(fn.toLocalTime());
            h.setEstado(EstadoHorario.DISPONIBLE);
            return horarioRepository.save(h);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Fechas inválidas, usar formato ISO LocalDateTime, p.ej. 2026-09-16T10:00:00");
        }
    }

    @PostMapping("/canchas")
    @ResponseStatus(HttpStatus.CREATED)
    public Cancha crearCancha(@RequestBody Map<String, Object> body) {
        String nombre = (String) body.get("nombre");
        String descripcion = (String) body.getOrDefault("descripcion", null);
        Number precioNum = (Number) body.get("precioPorHora");
        Number complejoIdNum = (Number) body.get("complejoId");

        if (nombre == null || precioNum == null || complejoIdNum == null) {
            throw new IllegalArgumentException("Faltan campos required: nombre, precioPorHora, complejoId");
        }

        Long complejoId = complejoIdNum.longValue();
        Complejo complejo = complejoRepository.findById(complejoId)
                .orElseThrow(() -> new IllegalArgumentException("Complejo no encontrado con id: " + complejoId));

        Cancha cancha = new Cancha();
        cancha.setNombre(nombre);
        cancha.setDeporte("FUTBOL");
        cancha.setDescripcion(descripcion);
        cancha.setPrecioHora(new BigDecimal(precioNum.toString()));
        cancha.setDuracionMinutos(60);
        cancha.setTechada(true);
        cancha.setEstado(EstadoCancha.ACTIVA);
        cancha.setComplejo(complejo);
        cancha.setDisponible(true);

        return canchaRepository.save(cancha);
    }
}
