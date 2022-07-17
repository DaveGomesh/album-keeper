package edu.ifma.keeper.api.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ifma.keeper.api.dto.mapper.MusicaMapper;
import edu.ifma.keeper.api.dto.request.MusicaRequest;
import edu.ifma.keeper.api.dto.response.MusicaResponse;
import edu.ifma.keeper.domain.model.Musica;
import edu.ifma.keeper.domain.service.MusicaService;
import lombok.Builder;

@Builder
@RestController
@RequestMapping("musica")
public class MusicaController {

    private final MusicaMapper musicaMapper;
    private final MusicaService musicaService;

    @PostMapping
    public ResponseEntity<MusicaResponse> salvar(
        @RequestBody @Valid MusicaRequest musicaRequest){
        
        Musica musica = musicaMapper.toEntity(musicaRequest);
        Set<Integer> idAutores = musicaRequest.getIdAutores();
        Set<Integer> idCantores = musicaRequest.getIdCantores();

        musica = musicaService.salvar(musica, idAutores, idCantores);
        final MusicaResponse musicaResponse = (
            musicaMapper.toResponse(musica)
        );

        return new ResponseEntity<>(musicaResponse, HttpStatus.CREATED);
    }

    @GetMapping("{id-musica}")
    public ResponseEntity<MusicaResponse> buscar(
        @PathVariable("id-musica") Integer idMusica){
        
        Musica musica = musicaService.buscar(idMusica, true);
        final MusicaResponse musicaResponse = (
            musicaMapper.toResponse(musica)
        );

        return new ResponseEntity<>(musicaResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MusicaResponse>> buscar(){
        
        List<Musica> listaMusica = musicaService.buscar(true);
        final List<MusicaResponse> listaMusicaResponse = (
            musicaMapper.toResponseList(listaMusica)
        );

        return new ResponseEntity<>(listaMusicaResponse, HttpStatus.OK);
    }

    @PutMapping("{id-musica}")
    public ResponseEntity<MusicaResponse> atualizar(
        @PathVariable("id-musica") Integer idMusica, 
        @RequestBody @Valid MusicaRequest musicaRequest){

        Musica musica = musicaMapper.toEntity(musicaRequest);
        Set<Integer> idAutores = musicaRequest.getIdAutores();
        Set<Integer> idCantores = musicaRequest.getIdCantores();

        musica = musicaService.atualizar(idMusica, musica, idAutores, idCantores);

        final MusicaResponse musicaResponse = (
            musicaMapper.toResponse(musica)
        );
        return new ResponseEntity<>(musicaResponse, HttpStatus.OK);
    }

    @DeleteMapping("{id-musica}")
    public ResponseEntity<?> excluir(@PathVariable("id-musica") Integer idMusica){

        musicaService.excluir(idMusica);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("how")
    public ResponseEntity<MusicaRequest> how() {

        Set<Integer> idAutores = new HashSet<>();
        idAutores.add(1);
        idAutores.add(2);
        idAutores.add(3);

        Set<Integer> idCantores = new HashSet<>();
        idCantores.add(1);
        idCantores.add(2);
        idCantores.add(3);

        final MusicaRequest musicaRequest = new MusicaRequest();
        musicaRequest.setNome("nome");
        musicaRequest.setDuracao(1);
        musicaRequest.setIdAutores(idAutores);
        musicaRequest.setIdCantores(idCantores);
        return new ResponseEntity<>(musicaRequest, HttpStatus.I_AM_A_TEAPOT);
    }
}
