package com.generation.tucancha.service;

import com.generation.tucancha.dto.request.ComplejoRequest;
import com.generation.tucancha.dto.response.ComplejoResponse;
import com.generation.tucancha.model.entity.Complejo;
import com.generation.tucancha.model.entity.TitularComplejo;
import com.generation.tucancha.repository.ComplejoRepository;
import com.generation.tucancha.repository.TitularComplejoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplejoService {

    private final ComplejoRepository complejoRepository;
    private final TitularComplejoRepository titularComplejoRepository;

    public ComplejoService(
            ComplejoRepository complejoRepository,
            TitularComplejoRepository titularComplejoRepository
    ) {
        this.complejoRepository = complejoRepository;
        this.titularComplejoRepository = titularComplejoRepository;
    }
    public ComplejoResponse crear(ComplejoRequest request) {

        TitularComplejo titularComplejo =
                titularComplejoRepository.findById(request.getTitularComplejoId())
                        .orElseThrow(() ->
                                new RuntimeException("Titular no encontrado")
                        );

        Complejo complejo = new Complejo(
                request.getNombreComplejo(),
                request.getNit(),
                request.getProvincia(),
                request.getCiudad(),
                request.getDireccion(),
                titularComplejo
        );

        Complejo complejoGuardado =
                complejoRepository.save(complejo);

        return convertirAResponse(complejoGuardado);
    }

    public List<ComplejoResponse> obtenerTodos() {
        return complejoRepository.findAll()
                .stream()
                .map(this::convertirAResponse)
                .toList();
    }

    public ComplejoResponse obtenerPorId(Long id) {

        Complejo complejo =
                complejoRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Complejo no encontrado")
                        );

        return convertirAResponse(complejo);
    }


    public ComplejoResponse actualizar(
            Long id,
            ComplejoRequest request
    ) {

        Complejo complejo =
                complejoRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Complejo no encontrado")
                        );

        TitularComplejo titularComplejo =
                titularComplejoRepository.findById(request.getTitularComplejoId())
                        .orElseThrow(() ->
                                new RuntimeException("Titular no encontrado")
                        );

        complejo.setNombreComplejo(request.getNombreComplejo());
        complejo.setNit(request.getNit());
        complejo.setProvincia(request.getProvincia());
        complejo.setCiudad(request.getCiudad());
        complejo.setDireccion(request.getDireccion());
        complejo.setTitularComplejo(titularComplejo);

        Complejo complejoActualizado =
                complejoRepository.save(complejo);

        return convertirAResponse(complejoActualizado);
    }

    public void eliminar(Long id) {

        Complejo complejo =
                complejoRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Complejo no encontrado")
                        );

        complejoRepository.delete(complejo);
    }

    private ComplejoResponse convertirAResponse(Complejo complejo) {

        return new ComplejoResponse(
                complejo.getId(),
                complejo.getNombreComplejo(),
                complejo.getNit(),
                complejo.getProvincia(),
                complejo.getCiudad(),
                complejo.getDireccion(),
                complejo.getTitularComplejo().getId()
        );
    }

}