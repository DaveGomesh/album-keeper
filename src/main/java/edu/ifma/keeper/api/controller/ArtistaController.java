package edu.ifma.keeper.api.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ifma.keeper.api.dto.mapper.ArtistaMapper;
import edu.ifma.keeper.api.dto.request.ArtistaRequest;
import edu.ifma.keeper.api.dto.response.ArtistaResponse;
import edu.ifma.keeper.domain.model.Artista;
import edu.ifma.keeper.domain.service.ArtistaService;
import lombok.Builder;

/**
 * Classe da Camada de Controle
 */
@Builder
@RestController
@RequestMapping("artista")
public class ArtistaController {
    
    private final ArtistaMapper artistaMapper;

    private final ArtistaService artistaService;

    @PostMapping
    public ResponseEntity<ArtistaResponse> saveArtista(
        @RequestBody @Valid ArtistaRequest artistaRequest){

        Artista artista = artistaMapper.toEntity(artistaRequest);
        artista = artistaService.salvar(artista);

        final ArtistaResponse artistaResponse = artistaMapper.toResponse(artista);
        return new ResponseEntity<>(artistaResponse, HttpStatus.CREATED);
    }
}
