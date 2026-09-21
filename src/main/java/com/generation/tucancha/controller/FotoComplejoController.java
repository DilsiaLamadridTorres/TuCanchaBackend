package com.generation.tucancha.controller;

import com.generation.tucancha.dto.response.FotoComplejoResponseDTO;
import com.generation.tucancha.model.entity.FotoComplejo;
import com.generation.tucancha.service.FotoComplejoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class FotoComplejoController {

    private final FotoComplejoService fotoComplejoService;

    public FotoComplejoController(
            FotoComplejoService fotoComplejoService
    ) {
        this.fotoComplejoService = fotoComplejoService;
    }

    // =====================================================
    // POST - SUBIR FOTO
    // =====================================================

    @PostMapping(
            value = "/complejos/{idComplejo}/fotos",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<FotoComplejoResponseDTO> subirFoto(
            @PathVariable Long idComplejo,
            @RequestParam("foto") MultipartFile foto
    ) throws IOException {

        FotoComplejoResponseDTO response =
                fotoComplejoService.guardarFoto(
                        idComplejo,
                        foto
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    // =====================================================
    // GET - LISTAR FOTOS DE UN COMPLEJO
    // =====================================================

    @GetMapping("/complejos/{idComplejo}/fotos")
    public ResponseEntity<List<FotoComplejoResponseDTO>> obtenerFotos(
            @PathVariable Long idComplejo
    ) {

        List<FotoComplejoResponseDTO> fotos =
                fotoComplejoService
                        .obtenerFotosPorComplejo(idComplejo);

        return ResponseEntity.ok(fotos);
    }

    // =====================================================
    // GET - MOSTRAR IMAGEN
    // =====================================================

    @GetMapping("/fotos/{idFoto}")
    public ResponseEntity<byte[]> obtenerFoto(
            @PathVariable Long idFoto
    ) {

        FotoComplejo foto =
                fotoComplejoService.obtenerFoto(idFoto);

        MediaType mediaType;

        try {

            mediaType = MediaType.parseMediaType(
                    foto.getTipoContenido()
            );

        } catch (Exception e) {

            mediaType = MediaType.APPLICATION_OCTET_STREAM;
        }

        return ResponseEntity
                .ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "inline; filename=\"" +
                                foto.getNombreArchivo() +
                                "\""
                )
                .contentType(mediaType)
                .body(foto.getImagen());
    }

    // =====================================================
    // DELETE - ELIMINAR FOTO
    // =====================================================

    @DeleteMapping("/fotos/{idFoto}")
    public ResponseEntity<Void> eliminarFoto(
            @PathVariable Long idFoto
    ) {

        fotoComplejoService.eliminarFoto(idFoto);

        return ResponseEntity
                .noContent()
                .build();
    }
}