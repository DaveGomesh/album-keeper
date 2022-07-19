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

import edu.ifma.keeper.api.dto.mapper.AlbumMapper;
import edu.ifma.keeper.api.dto.request.AlbumRequest;
import edu.ifma.keeper.api.dto.response.AlbumResponse;
import edu.ifma.keeper.domain.model.Album;
import edu.ifma.keeper.domain.relatorio.AlbumDetails;
import edu.ifma.keeper.domain.service.AlbumService;
import lombok.Builder;

@Builder
@RestController
@RequestMapping("album")
public class AlbumController {

    private final AlbumService albumService;
    private final AlbumMapper albumMapper;

    @PostMapping
    public ResponseEntity<AlbumResponse> salvar(
        @RequestBody @Valid AlbumRequest albumRequest){

        Album album = albumMapper.toEntity(albumRequest);
        Set<Integer> listaIdParticipante = albumRequest.getListaIdParticipantes();
        Set<Integer> listaIdMusica = albumRequest.getListaIdMusicas();

        album = albumService.salvar(album, listaIdParticipante, listaIdMusica);

        final AlbumResponse albumResponse = (
            albumMapper.toResponse(album)
        );

        return new ResponseEntity<>(albumResponse, HttpStatus.CREATED);
    }

    @GetMapping("{id-album}")
    public ResponseEntity<AlbumResponse> buscar(
        @PathVariable("id-album") Integer idAlbum){

        Album album = albumService.buscar(idAlbum);
        final AlbumResponse albumResponse = (
            albumMapper.toResponse(album)
        );

        return new ResponseEntity<>(albumResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AlbumResponse>> buscar(){

        List<Album> listaAlbum = albumService.buscar();
        final List<AlbumResponse> listaAlbumResponse = (
            albumMapper.toResponseList(listaAlbum)
        );

        return new ResponseEntity<>(listaAlbumResponse, HttpStatus.OK);
    }

    @PutMapping("{id-album}")
    public ResponseEntity<AlbumResponse> atualizar(
        @PathVariable("id-album") Integer idAlbum,
        @RequestBody @Valid AlbumRequest albumRequest){

        Album album = albumMapper.toEntity(albumRequest);
        Set<Integer> listaIdParticipante = albumRequest.getListaIdParticipantes();
        Set<Integer> listaIdMusica = albumRequest.getListaIdMusicas();

        album = albumService.atualizar(idAlbum, album, listaIdParticipante, listaIdMusica);
        final AlbumResponse albumResponse = (
            albumMapper.toResponse(album)
        );

        return new ResponseEntity<>(albumResponse, HttpStatus.OK);
    }

    @DeleteMapping("{id-album}")
    public ResponseEntity<?> excluir(@PathVariable("id-album") Integer idAlbum){
        
        albumService.excluir(idAlbum);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("relatorio-album/{id-artista}")
    public List<AlbumDetails> testRelatorio(@PathVariable("id-artista") Integer idArtista){
        return albumService.gerarRelatorio(idArtista);
    }

    @GetMapping("how")
    public ResponseEntity<AlbumRequest> how(){

        Set<Integer> listaIdParticipante = new HashSet<>();
        listaIdParticipante.add(1);
        listaIdParticipante.add(2);
        listaIdParticipante.add(3);

        Set<Integer> listaIdMusica = new HashSet<>();
        listaIdMusica.add(1);
        listaIdMusica.add(2);
        listaIdMusica.add(3);

        final AlbumRequest albumRequest = new AlbumRequest();
        albumRequest.setNome("nome");
        albumRequest.setAno(2022);
        albumRequest.setListaIdParticipantes(listaIdParticipante);
        albumRequest.setListaIdMusicas(listaIdMusica);
        return new ResponseEntity<>(albumRequest, HttpStatus.OK);
    }
}
