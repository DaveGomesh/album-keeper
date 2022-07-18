package edu.ifma.keeper.domain.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ifma.keeper.domain.exception.RegraNegocioException;
import edu.ifma.keeper.domain.model.Artista;
import edu.ifma.keeper.domain.model.Musica;
import edu.ifma.keeper.domain.repository.MusicaRepository;
import lombok.Builder;

@Builder
@Service
public class MusicaService {
    
    private final MusicaRepository musicaRepository;
    private final ArtistaService artistaService;

    @Transactional
    public Musica salvar(Musica musica){
        return musicaRepository.save(musica);
    }

    public Musica salvar(Musica musica, Set<Integer> idAutores, Set<Integer> idCantores){

        this.validar(idAutores, idCantores);

        Set<Artista> autores = (idAutores.stream()
            .map(idAutor -> artistaService.buscar(idAutor))
            .collect(Collectors.toSet())
        );

        Set<Artista> cantores = (idCantores.stream()
            .map(idCantor -> artistaService.buscar(idCantor))
            .collect(Collectors.toSet())
        );

        musica.setAutores(autores);
        musica.setCantores(cantores);
        return this.salvar(musica);
    }

    public Musica buscar(Integer idMusica){

        final Musica musica = (
            musicaRepository.findById(idMusica).get()
        );

        return musica;
    }

    public List<Musica> buscar(){
        return musicaRepository.findAll();
    }
    
    public Musica atualizar(Integer idMusica, Musica musica, Set<Integer> idAutores, Set<Integer> idCantores){

        Musica musicaAtual = (
            musicaRepository.findById(idMusica).get()
        );

        BeanUtils.copyProperties(musica, musicaAtual, "idMusica");
        final Musica musicaAtualizada = (
            this.salvar(musicaAtual, idAutores, idCantores)
        );

        return musicaAtualizada;
    }

    @Transactional
    public void excluir(Integer idMusica){
        
        Musica musica = this.buscar(idMusica);
        musicaRepository.delete(musica);
    }

    public void validar(Set<Integer> idAutores, Set<Integer> idCantores){
        if(idAutores.isEmpty()){
            throw new RegraNegocioException("A Música deve ter pelo menos um Autor.");
        }
        
        if(idCantores.isEmpty()){
            throw new RegraNegocioException("A Música deve ter pelo menos um Cantor.");
        }
    }
}