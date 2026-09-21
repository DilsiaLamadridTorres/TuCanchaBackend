package com.generation.tucancha.controller;

import com.generation.tucancha.dto.request.LoginRequestDTO;
import com.generation.tucancha.dto.response.LoginResponseDTO;
import com.generation.tucancha.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/validar")
    public ResponseEntity<?> validarToken() {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@Valid @RequestBody LoginRequestDTO dto) {
        return authService.iniciarSesion(dto);
    }
}