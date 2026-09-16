package com.generation.tucancha.controller;

import com.generation.tucancha.dto.request.PrestacionRequestDTO;
import com.generation.tucancha.dto.response.PrestacionResponseDTO;
import com.generation.tucancha.model.entity.Prestacion;
import com.generation.tucancha.service.PrestacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/prestaciones")
public class PrestacionController {

    private final PrestacionService prestacionService;

    public PrestacionController(PrestacionService prestacionService) {
        this.prestacionService = prestacionService;
    }

    @GetMapping
    public ResponseEntity<List<PrestacionResponseDTO>> obtenerTodas() {
        List<PrestacionResponseDTO> prestaciones = prestacionService.obtenerTodas();
        return ResponseEntity.ok(prestaciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestacionResponseDTO> obtenerPorId(@PathVariable Long id) {
        PrestacionResponseDTO prestacion = prestacionService.obtenerPorId(id);
        return ResponseEntity.ok(prestacion);
    }

    @PostMapping
    public ResponseEntity<PrestacionResponseDTO> crear(@RequestBody PrestacionRequestDTO request) {
        PrestacionResponseDTO nueva = prestacionService.crear(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        prestacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}