package com.generation.tucancha.service;

import com.generation.tucancha.dto.request.ComplejoRequestDTO;
import com.generation.tucancha.dto.response.ComplejoResponseDTO;
import com.generation.tucancha.model.entity.Complejo;
import com.generation.tucancha.model.entity.Prestacion;
import com.generation.tucancha.model.entity.TitularComplejo;
import com.generation.tucancha.repository.ComplejoRepository;
import com.generation.tucancha.repository.TitularComplejoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComplejoService {

    private final ComplejoRepository complejoRepository;
    private final TitularComplejoRepository titularComplejoRepository;

    public ComplejoService(
            ComplejoRepository complejoRepository,
            TitularComplejoRepository titularComplejoRepository) {

        this.complejoRepository = complejoRepository;
        this.titularComplejoRepository = titularComplejoRepository;
    }

    // =========================================================
    // CREAR COMPLEJO
    // =========================================================

    public ComplejoResponseDTO crearComplejo(
            ComplejoRequestDTO request) {

        // Buscar el titular del complejo
        TitularComplejo titular =
                titularComplejoRepository
                        .findById(
                                request.getTitularComplejoId()
                        )
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "No se encontró el titular del complejo"
                                )
                        );

        // Crear el complejo
        Complejo complejo =
                new Complejo();

        complejo.setNombreComplejo(
                request.getNombreComplejo()
        );

        complejo.setProvincia(
                request.getProvincia()
        );

        complejo.setCiudad(
                request.getCiudad()
        );

        complejo.setDireccion(
                request.getDireccion()
        );

        complejo.setTelefonoComplejo(
                request.getTelefonoComplejo()
        );

        complejo.setTitularComplejo(
                titular
        );

        // =====================================================
        // CREAR PRESTACIÓN
        // =====================================================

        Prestacion prestacion =
                new Prestacion();

        prestacion.setEstacionamiento(
                request.isEstacionamiento()
        );

        prestacion.setVestuario(
                request.isVestuario()
        );

        prestacion.setAsador(
                request.isAsador()
        );

        prestacion.setBar(
                request.isBar()
        );

        prestacion.setDuchas(
                request.isDuchas()
        );

        prestacion.setTv(
                request.isTv()
        );

        prestacion.setBufet(
                request.isBufet()
        );

        // Relacionar prestación con complejo
        prestacion.setComplejo(
                complejo
        );

        complejo.getPrestaciones()
                .add(prestacion);

        // =====================================================
        // GUARDAR
        // =====================================================

        Complejo guardado =
                complejoRepository.save(
                        complejo
                );

        return convertirAResponse(
                guardado
        );
    }

    // =========================================================
    // OBTENER COMPLEJO POR ID
    // =========================================================

    @Transactional(readOnly = true)
    public ComplejoResponseDTO obtenerPorId(
            Long id) {

        Complejo complejo =
                complejoRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "No existe el complejo con id: "
                                                + id
                                )
                        );

        return convertirAResponse(
                complejo
        );
    }

    // =========================================================
    // CONVERTIR ENTITY -> RESPONSE DTO
    // =========================================================

    private ComplejoResponseDTO convertirAResponse(
            Complejo complejo) {

        ComplejoResponseDTO response =
                new ComplejoResponseDTO();

        response.setId(
                complejo.getId()
        );

        response.setNombreComplejo(
                complejo.getNombreComplejo()
        );

        response.setProvincia(
                complejo.getProvincia()
        );

        response.setCiudad(
                complejo.getCiudad()
        );

        response.setDireccion(
                complejo.getDireccion()
        );

        response.setTelefonoComplejo(
                complejo.getTelefonoComplejo()
        );

        // =====================================================
        // TITULAR
        // =====================================================

        if (
                complejo.getTitularComplejo() != null
        ) {

            response.setTitularComplejoId(
                    complejo
                            .getTitularComplejo()
                            .getId()
            );
        }

        // =====================================================
        // PRESTACIONES
        // =====================================================

        if (
                complejo.getPrestaciones() != null
                        &&
                        !complejo
                                .getPrestaciones()
                                .isEmpty()
        ) {

            Prestacion prestacion =
                    complejo
                            .getPrestaciones()
                            .get(0);

            response.setEstacionamiento(
                    prestacion.isEstacionamiento()
            );

            response.setVestuario(
                    prestacion.isVestuario()
            );

            response.setAsador(
                    prestacion.isAsador()
            );

            response.setBar(
                    prestacion.isBar()
            );

            response.setDuchas(
                    prestacion.isDuchas()
            );

            response.setTv(
                    prestacion.isTv()
            );

            response.setBufet(
                    prestacion.isBufet()
            );
        }

        return response;
    }
}