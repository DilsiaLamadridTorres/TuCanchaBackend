package com.generation.tucancha.service;

import com.generation.tucancha.dto.request.LoginRequestDTO;
import com.generation.tucancha.dto.response.LoginResponseDTO;
import com.generation.tucancha.exception.CredencialesInvalidasException;
import com.generation.tucancha.model.entity.Usuario;
import com.generation.tucancha.repository.UsuarioRepository;
import com.generation.tucancha.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public LoginResponseDTO iniciarSesion(LoginRequestDTO datos) {
        Usuario usuario = usuarioRepository.findByCorreo(datos.correo())
                .orElseThrow(() -> new CredencialesInvalidasException("Usuario o contraseña incorrectos"));

        if (!passwordEncoder.matches(datos.password(), usuario.getPassword())) {
            throw new CredencialesInvalidasException("Usuario o contraseña incorrectos");
        }

        String token = jwtService.generarToken(usuario);
        return new LoginResponseDTO(token, usuario.getNombre(), usuario.getRol());
    }
}