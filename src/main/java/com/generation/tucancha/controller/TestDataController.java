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
    public Horario crearHorario(@RequestBody Map<String, Object> body) {
        String inicio = (String) body.get("inicio");
        String fin = (String) body.get("fin");
        Number canchaIdNum = (Number) body.get("canchaId");

        if (inicio == null || fin == null || canchaIdNum == null) {
            throw new IllegalArgumentException("Faltan campos required: inicio, fin, canchaId");
        }

        try {
            LocalDateTime ini = LocalDateTime.parse(inicio);
            LocalDateTime fn = LocalDateTime.parse(fin);
            Cancha cancha = canchaRepository.findById(canchaIdNum.longValue())
                    .orElseThrow(() -> new IllegalArgumentException("Cancha no encontrada con id: " + canchaIdNum.longValue()));

            Horario h = new Horario(ini, fn);
            h.setCancha(cancha);
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
        Number precioNum = (Number) body.get("precioPorHora");
        Number complejoIdNum = (Number) body.get("complejoId");

        if (nombre == null || precioNum == null || complejoIdNum == null) {
            throw new IllegalArgumentException("Faltan campos required: nombre, precioPorHora, complejoId");
        }

        Long complejoId = complejoIdNum.longValue();
        Complejo complejo = complejoRepository.findById(complejoId)
                .orElseThrow(() -> new IllegalArgumentException("Complejo no encontrado con id: " + complejoId));

        Cancha cancha = new Cancha();
        cancha.setComplejo(complejo);
        cancha.setNombre(nombre);
        cancha.setDeporte((String) body.getOrDefault("deporte", "FUTBOL"));
        cancha.setTipoPiso((String) body.getOrDefault("tipoPiso", "Césped sintético"));
        cancha.setPrecioHora(new BigDecimal(precioNum.toString()));
        cancha.setDuracionMinutos(((Number) body.getOrDefault("duracionMinutos", 60)).intValue());
        cancha.setTechada(Boolean.TRUE.equals(body.getOrDefault("techada", true)));
        cancha.setOtrosDeportes((String) body.getOrDefault("otrosDeportes", null));
        cancha.setEstado(EstadoCancha.ACTIVA);

        return canchaRepository.save(cancha);
    }
}
