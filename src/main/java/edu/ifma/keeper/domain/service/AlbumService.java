package edu.ifma.keeper.domain.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import edu.ifma.keeper.domain.model.Album;
import edu.ifma.keeper.domain.model.Artista;
import edu.ifma.keeper.domain.model.Musica;
import edu.ifma.keeper.domain.repository.AlbumRepository;
import lombok.Builder;

@Builder
@Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    private final ArtistaService artistaService;
    private final MusicaService musicaService;

    @Transactional
    public Album salvar(Album album) {
        return albumRepository.save(album);
    }

    public Album salvar(Album album, Set<Integer> listaIdParticipante, Set<Integer> listaIdMusica) {

        Set<Artista> listaParticipantes = (listaIdParticipante.stream()
            .map(idParticipante -> artistaService.buscar(idParticipante))
            .collect(Collectors.toSet())
        );

        Set<Musica> listaMusica = (listaIdMusica.stream()
            .map(idMusica -> musicaService.buscar(idMusica))
            .collect(Collectors.toSet())
        );

        album.setParticipantes(listaParticipantes);
        album.setMusicas(listaMusica);
        return this.salvar(album);
    }

    public Album buscar(Integer idAlbum) {

        final Album album = (
            albumRepository.findById(idAlbum).get()
        );

        return album;
    }

    public List<Album> buscar() {
        return albumRepository.findAll();
    }
    
    public Album atualizar(Integer idAlbum, Album album, Set<Integer> listaIdParticipante, Set<Integer> listaIdMusica) {

        Album albumAtual = (
            albumRepository.findById(idAlbum).get()
        );

        BeanUtils.copyProperties(album, albumAtual, "idAlbum");
        final Album albumAtualizado = (
            this.salvar(albumAtual, listaIdParticipante, listaIdMusica)
        );

        return albumAtualizado;
    }

    @Transactional
    public void excluir(Integer idAlbum) {

        Album album = this.buscar(idAlbum);
        albumRepository.delete(album);
    }
}
