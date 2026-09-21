package com.generation.tucancha.service;

import com.generation.tucancha.dto.request.UsuarioRequestDTO;
import com.generation.tucancha.dto.response.UsuarioResponseDTO;
import com.generation.tucancha.dto.resumen.UsuarioResumenDTO;
import com.generation.tucancha.model.enums.RolUsuario;
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
    public Optional<UsuarioResponseDTO> obtenerPorId(Long id) {
        return usuarioRepository.findById(id)
                .map(this::convertirAResponse);
    }

    // Guarda a partir de un UsuarioRequest y retorna UsuarioResponse
    public UsuarioResponseDTO guardar(UsuarioRequestDTO request) {
        if (usuarioRepository.existsByCorreo(request.correo())) {
            throw new IllegalArgumentException("El correo " + request.correo() + " ya está registrado.");
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(request.nombre());
        usuario.setTelefono(request.telefono());
        usuario.setCorreo(request.correo());
        usuario.setPassword(passwordEncoder.encode(request.password()));
        usuario.setEstado(request.estado());
        usuario.setRol(RolUsuario.JUGADOR);

        Usuario guardado = usuarioRepository.save(usuario);
        return convertirAResponse(guardado);
    }

    public void eliminarPorId(Long id) {
        usuarioRepository.deleteById(id);
    }

    // Métodos privados de mapeo
    private UsuarioResponseDTO convertirAResponse(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getCorreo(),
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