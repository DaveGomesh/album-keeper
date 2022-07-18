package edu.ifma.keeper.api.controller;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<ArtistaResponse> salvar(
        @RequestBody @Valid ArtistaRequest artistaRequest){

        Artista artista = artistaMapper.toEntity(artistaRequest);
        artista = artistaService.salvar(artista);

        final ArtistaResponse artistaResponse = artistaMapper.toResponse(artista);
        return new ResponseEntity<>(artistaResponse, HttpStatus.CREATED);
    }

    @GetMapping("{id-artista}")
    public ResponseEntity<ArtistaResponse> buscar(
        @PathVariable("id-artista") Integer idArtista){
        
        Artista artista = artistaService.buscar(idArtista);

        final ArtistaResponse artistaResponse = artistaMapper.toResponse(artista);
        return new ResponseEntity<>(artistaResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ArtistaResponse>> buscar(
        @RequestParam(value = "nome", required = false) String nome, 
        @RequestParam(value = "nascionalidade", required = false) String nascionalidade){
        
        List<Artista> listaArtista = null;
        
        if(Objects.isNull(nome) && Objects.isNull(nascionalidade)){
            listaArtista = artistaService.buscar();
        } else if(Objects.nonNull(nome) && Objects.nonNull(nascionalidade)){
            listaArtista = artistaService.buscarPorNomeENascionalidade(nome, nascionalidade);
        } else if(Objects.nonNull(nome)){
            listaArtista = artistaService.buscarPorNome(nome);
        } else {
            listaArtista = artistaService.buscarPorNascionalidade(nascionalidade);
        }

        final List<ArtistaResponse> listaArtistaResponse = (
            artistaMapper.toResponseList(listaArtista)
        );

        return new ResponseEntity<>(listaArtistaResponse, HttpStatus.OK);
    }

    @GetMapping("paginacao")
    public ResponseEntity<Page<ArtistaResponse>> buscar(
        @RequestParam(value = "nome", required = false) String nome, 
        @RequestParam(value = "nascionalidade", required = false) String nascionalidade,
        Pageable paginacao){
        
        Page<Artista> listaArtistaPaginado = null;

        if(Objects.isNull(nome) && Objects.isNull(nascionalidade)){
            listaArtistaPaginado = artistaService.buscar(paginacao);
        } else if(Objects.nonNull(nome) && Objects.nonNull(nascionalidade)){
            listaArtistaPaginado = artistaService.buscarPorNomeENascionalidade(nome.trim(), nascionalidade.trim(), paginacao);
        } else if(Objects.nonNull(nome)){
            listaArtistaPaginado = artistaService.buscarPorNome(nome.trim(), paginacao);
        } else {
            listaArtistaPaginado = artistaService.buscarPorNascionalidade(nascionalidade.trim(), paginacao);
        }
    
        final Page<ArtistaResponse> listaArtistaResponsePaginado = (
            listaArtistaPaginado.map(artista -> artistaMapper.toResponse(artista))
        );

        return new ResponseEntity<>(listaArtistaResponsePaginado, HttpStatus.OK);
    }
    
    @PutMapping("{id-artista}")
    public ResponseEntity<ArtistaResponse> atualizar(
        @PathVariable("id-artista") Integer idArtista, 
        @RequestBody @Valid ArtistaRequest artistaRequest){

        Artista artista = artistaMapper.toEntity(artistaRequest);
        artista = artistaService.atualizar(idArtista, artista);

        final ArtistaResponse artistaResponse = (
            artistaMapper.toResponse(artista)
        );
        return new ResponseEntity<>(artistaResponse, HttpStatus.OK);
    }

    @DeleteMapping("{id-artista}")
    public ResponseEntity<?> excluir(@PathVariable("id-artista") Integer idArtista) {
        
        artistaService.excluir(idArtista);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("how")
    public ResponseEntity<ArtistaRequest> how(){

        final ArtistaRequest artistaRequest = new ArtistaRequest();
        artistaRequest.setNome("nome");
        artistaRequest.setNascionalidade("nascionalidade");

        return new ResponseEntity<>(artistaRequest, HttpStatus.OK);
    }
}
