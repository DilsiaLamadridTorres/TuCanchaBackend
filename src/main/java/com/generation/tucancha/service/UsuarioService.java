package com.generation.tucancha.service;

import com.generation.tucancha.model.entity.Usuario;
import com.generation.tucancha.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Obtener todos los usuarios
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    // Buscar un usuario por su ID
    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    // Guardar / Registrar un nuevo usuario
    public Usuario guardar(Usuario usuario) {
        // Aquí más adelante agregaremos lógica como encriptar contraseña o validar duplicados
        return usuarioRepository.save(usuario);
    }

    // Eliminar un usuario por ID
    public boolean eliminarPorId(Long id) {
        if (!usuarioRepository.existsById(id)) {
            return false;
        }
        usuarioRepository.deleteById(id);
        return true;
    }
}
