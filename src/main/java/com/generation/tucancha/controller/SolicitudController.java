package com.generation.tucancha.controller;

import com.generation.tucancha.model.entity.Solicitud;
import com.generation.tucancha.model.enums.EstadoSolicitud;
import com.generation.tucancha.service.SolicitudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudController {

    private final SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    @GetMapping
    public ResponseEntity<List<Solicitud>> obtenerTodas() {
        return ResponseEntity.ok(solicitudService.obtenerTodas());
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Solicitud>> obtenerPorEstado(@PathVariable EstadoSolicitud estado) {
        return ResponseEntity.ok(solicitudService.obtenerPorEstado(estado));
    }

    @PostMapping
    public ResponseEntity<Solicitud> crear(@RequestBody Solicitud solicitud) {
        return ResponseEntity.ok(solicitudService.guardar(solicitud));
    }
}