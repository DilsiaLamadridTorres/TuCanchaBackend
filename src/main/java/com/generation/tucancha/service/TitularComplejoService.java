package com.generation.tucancha.service;

import com.generation.tucancha.dto.request.TitularComplejoRequest;
import com.generation.tucancha.dto.response.TitularComplejoResponse;
import com.generation.tucancha.model.entity.TitularComplejo;
import com.generation.tucancha.repository.TitularComplejoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitularComplejoService {
    private final TitularComplejoRepository titularComplejoRepository;

    public TitularComplejoService(TitularComplejoRepository titularComplejoRepository) {
        this.titularComplejoRepository = titularComplejoRepository;
    }

    public TitularComplejoResponse crear(TitularComplejoRequest request) {
        TitularComplejo titularComplejo = new TitularComplejo(
                request.getNombre(),
                request.getApellido(),
                request.getCedula(),
                request.getCorreo(),
                request.getTelefono(),
                request.getFechaRegistro()
        );
        TitularComplejo titularGuardado =
                titularComplejoRepository.save(titularComplejo);
        return convertirAResponse(titularGuardado);
    }

    public List<TitularComplejoResponse> obtenerTodos() {
        return titularComplejoRepository.findAll()
                .stream()
                .map(this::convertirAResponse)
                .toList();
    }

    public TitularComplejoResponse obtenerPorId(Long id) {

        TitularComplejo titularComplejo =
                titularComplejoRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Titular no encontrado")
                        );

        return convertirAResponse(titularComplejo);
    }

    public TitularComplejoResponse actualizar(
            Long id,
            TitularComplejoRequest request
    ) {

        TitularComplejo titularComplejo =
                titularComplejoRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Titular no encontrado")
                        );

        titularComplejo.setNombre(request.getNombre());
        titularComplejo.setApellido(request.getApellido());
        titularComplejo.setCedula(request.getCedula());
        titularComplejo.setCorreo(request.getCorreo());
        titularComplejo.setTelefono(request.getTelefono());
        titularComplejo.setFechaRegistro(request.getFechaRegistro());

        TitularComplejo titularActualizado =
                titularComplejoRepository.save(titularComplejo);

        return convertirAResponse(titularActualizado);
    }

    public void eliminar(Long id) {
        TitularComplejo titularComplejo =
                titularComplejoRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Titular no encontrado")
                        );

        titularComplejoRepository.delete(titularComplejo);
    }

    private TitularComplejoResponse convertirAResponse(TitularComplejo titularComplejo) {
        return new TitularComplejoResponse(
                titularComplejo.getId(),
                titularComplejo.getNombre(),
                titularComplejo.getApellido(),
                titularComplejo.getCedula(),
                titularComplejo.getCorreo(),
                titularComplejo.getTelefono(),
                titularComplejo.getFechaRegistro()
        );
    }

}
