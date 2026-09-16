package com.generation.tucancha.service;

import com.generation.tucancha.dto.response.RolResponse;
import com.generation.tucancha.model.entity.Rol;
import com.generation.tucancha.repository.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {

    private final RolRepository rolRepository;

    public RolService (RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public List<RolResponse> listarRoles ( ) {
        return rolRepository.findAll()
                .stream()
                .map(rol -> new RolResponse(
                        rol.getId(),
                        rol.getNombre()
                ))
                .toList();
    }

    public RolResponse buscarPorId (Long id) {
        Rol rol = rolRepository.findById(id)
                .orElseThrow(( ) -> new RuntimeException("Rol no encontrado"));

        return new RolResponse(
                rol.getId(),
                rol.getNombre()
        );
    }

    public RolResponse crearRol (Rol rol) {
        Rol rolGuardado = rolRepository.save(rol);

        return new RolResponse(
                rolGuardado.getId(),
                rolGuardado.getNombre()
        );
    }
}