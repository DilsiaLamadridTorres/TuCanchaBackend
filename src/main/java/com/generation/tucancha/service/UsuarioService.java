package com.generation.tucancha.service;

import com.generation.tucancha.dto.request.UsuarioRequest;
import com.generation.tucancha.dto.response.UsuarioResponse;
import com.generation.tucancha.dto.resumen.UsuarioResumenDTO;
import com.generation.tucancha.model.entity.RolUsuario;
import com.generation.tucancha.model.entity.Usuario;
import com.generation.tucancha.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Devuelve resumen para listados
    public List<UsuarioResumenDTO> obtenerTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::convertirAResumenDTO)
                .collect(Collectors.toList());
    }

    // Devuelve respuesta completa por ID
    public Optional<UsuarioResponse> obtenerPorId(Long id) {
        return usuarioRepository.findById(id)
                .map(this::convertirAResponse);
    }

    // Guarda a partir de un UsuarioRequest y retorna UsuarioResponse
    public UsuarioResponse guardar(UsuarioRequest request) {
        if (usuarioRepository.existsByCorreo(request.getCorreo())) {
            throw new IllegalArgumentException("El correo " + request.getCorreo() + " ya está registrado.");
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(request.getNombre());
        usuario.setCedula(request.getCedula());
        usuario.setCorreo(request.getCorreo());
        usuario.setPassword(passwordEncoder.encode(request.getPassword()));
        usuario.setEstado(true);

        if (request.getRol() == null) {
            usuario.setRol(RolUsuario.JUGADOR);
        } else {
            usuario.setRol(request.getRol());
        }

        Usuario guardado = usuarioRepository.save(usuario);
        return convertirAResponse(guardado);
    }

    public void eliminarPorId(Long id) {
        usuarioRepository.deleteById(id);
    }

    // Métodos privados de mapeo
    private UsuarioResponse convertirAResponse(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getCedula(),
                usuario.getCorreo(),
                usuario.isEstado(),
                usuario.getFechaRegistro(),
                usuario.getRol()
        );
    }

    private UsuarioResumenDTO convertirAResumenDTO(Usuario usuario) {
        return new UsuarioResumenDTO(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getCorreo(),
                usuario.getRol()
        );
    }
}