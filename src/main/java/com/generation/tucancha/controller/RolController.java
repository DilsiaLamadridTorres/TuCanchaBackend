package com.generation.tucancha.controller;

import com.generation.tucancha.dto.response.RolResponse;
import com.generation.tucancha.model.entity.Rol;
import com.generation.tucancha.service.RolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    private final RolService rolService;

    public RolController (RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public ResponseEntity<List<RolResponse>> listarRoles ( ) {
        return ResponseEntity.ok(rolService.listarRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolResponse> buscarPorId (@PathVariable Long id) {
        return ResponseEntity.ok(rolService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<RolResponse> crearRol (@RequestBody Rol rol) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(rolService.crearRol(rol));
    }
}