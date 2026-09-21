package com.generation.tucancha.service;

import com.generation.tucancha.dto.response.FotoComplejoResponseDTO;
import com.generation.tucancha.model.entity.Complejo;
import com.generation.tucancha.model.entity.FotoComplejo;
import com.generation.tucancha.repository.ComplejoRepository;
import com.generation.tucancha.repository.FotoComplejoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FotoComplejoService {

    private final FotoComplejoRepository fotoComplejoRepository;
    private final ComplejoRepository complejoRepository;

    public FotoComplejoService(
            FotoComplejoRepository fotoComplejoRepository,
            ComplejoRepository complejoRepository
    ) {
        this.fotoComplejoRepository = fotoComplejoRepository;
        this.complejoRepository = complejoRepository;
    }

    // =====================================================
    // GUARDAR FOTO
    // =====================================================

    public FotoComplejoResponseDTO guardarFoto(
            Long idComplejo,
            MultipartFile archivo
    ) throws IOException {

        if (archivo == null || archivo.isEmpty()) {
            throw new RuntimeException("La imagen está vacía");
        }

        Complejo complejo = complejoRepository
                .findById(idComplejo)
                .orElseThrow(() ->
                        new RuntimeException(
                                "No existe el complejo con id: " + idComplejo
                        )
                );

        FotoComplejo foto = new FotoComplejo();

        foto.setComplejo(complejo);
        foto.setImagen(archivo.getBytes());
        foto.setNombreArchivo(archivo.getOriginalFilename());
        foto.setTipoContenido(archivo.getContentType());

        FotoComplejo fotoGuardada =
                fotoComplejoRepository.save(foto);

        return convertirAResponse(fotoGuardada);
    }

    // =====================================================
    // OBTENER FOTOS DE UN COMPLEJO
    // =====================================================

    public List<FotoComplejoResponseDTO> obtenerFotosPorComplejo(
            Long idComplejo
    ) {

        if (!complejoRepository.existsById(idComplejo)) {
            throw new RuntimeException(
                    "No existe el complejo con id: " + idComplejo
            );
        }

        return fotoComplejoRepository
                .findByComplejoId(idComplejo)
                .stream()
                .map(this::convertirAResponse)
                .toList();
    }

    // =====================================================
    // OBTENER UNA FOTO
    // =====================================================

    public FotoComplejo obtenerFoto(Long idFoto) {

        return fotoComplejoRepository
                .findById(idFoto)
                .orElseThrow(() ->
                        new RuntimeException(
                                "No existe la foto con id: " + idFoto
                        )
                );
    }

    // =====================================================
    // ELIMINAR FOTO
    // =====================================================

    public void eliminarFoto(Long idFoto) {

        if (!fotoComplejoRepository.existsById(idFoto)) {
            throw new RuntimeException(
                    "No existe la foto con id: " + idFoto
            );
        }

        fotoComplejoRepository.deleteById(idFoto);
    }

    // =====================================================
    // ENTITY -> RESPONSE DTO
    // =====================================================

    private FotoComplejoResponseDTO convertirAResponse(
            FotoComplejo foto
    ) {

        FotoComplejoResponseDTO response =
                new FotoComplejoResponseDTO();

        response.setIdFoto(foto.getIdFoto());

        if (foto.getComplejo() != null) {
            response.setIdComplejo(
                    foto.getComplejo().getId()
            );
        }

        response.setNombreArchivo(
                foto.getNombreArchivo()
        );

        response.setTipoContenido(
                foto.getTipoContenido()
        );

        response.setUrl(
                "/api/fotos/" + foto.getIdFoto()
        );

        return response;
    }
}