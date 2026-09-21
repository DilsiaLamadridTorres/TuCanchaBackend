package com.generation.tucancha.controller;

import com.generation.tucancha.dto.request.ComplejoRequestDTO;
import com.generation.tucancha.dto.response.ComplejoResponseDTO;
import com.generation.tucancha.service.ComplejoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complejos")
@CrossOrigin(origins = "*")
public class ComplejoController {

    private final ComplejoService complejoService;

    public ComplejoController(ComplejoService complejoService) {
        this.complejoService = complejoService;
    }

    // ==========================================
    // POST - CREAR COMPLEJO
    // ==========================================

    @PostMapping
    public ResponseEntity<ComplejoResponseDTO> crearComplejo(
            @RequestBody ComplejoRequestDTO request) {

        ComplejoResponseDTO response =
                complejoService.crearComplejo(request);

        return ResponseEntity.ok(response);
    }

    // ==========================================
    // GET - TODOS LOS COMPLEJOS
    // ==========================================

    @GetMapping
    public ResponseEntity<List<ComplejoResponseDTO>> obtenerTodos() {

        return ResponseEntity.ok(
                complejoService.obtenerTodos()
        );
    }

    // ==========================================
    // GET - COMPLEJO POR ID
    // ==========================================

    @GetMapping("/{id}")
    public ResponseEntity<ComplejoResponseDTO> obtenerPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                complejoService.obtenerPorId(id)
        );
    }
}