package edu.ifma.keeper.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.ifma.keeper.domain.model.Artista;
import edu.ifma.keeper.domain.repository.ArtistaRepository;
import lombok.Builder;

@Builder
@Service
public class ArtistaService {

    private final ArtistaRepository artistaRepository;

    public Artista salvar(Artista artista) {
        return artistaRepository.save(artista);
    }

    public Artista buscar(Integer idArtista) {

        final Artista artista = (artistaRepository.findById(idArtista).get());

        return artista;
    }

    public List<Artista> buscar() {
        return artistaRepository.findAll();
    }

    public List<Artista> buscarPorNome(String nome) {

        final List<Artista> listaArtista = (
            artistaRepository.findByNomeContainsIgnoreCase(nome)
        );

        return listaArtista;
    }

    public List<Artista> buscarPorNascionalidade(String nascionalidade) {

        final List<Artista> listaArtista = (
            artistaRepository.findByNascionalidadeContainsIgnoreCase(nascionalidade)
        );

        return listaArtista;
    }

    public List<Artista> buscarPorNomeENascionalidade(String nome, String nascionalidade) {
        final List<Artista> listaArtista = (
            artistaRepository.findByNomeContainsIgnoreCaseAndNascionalidadeContainsIgnoreCase(nome, nascionalidade)
        );

        return listaArtista;
    }
    
    public Page<Artista> buscar(Pageable paginacao) {
        return artistaRepository.findAll(paginacao);
    }

    public Page<Artista> buscarPorNome(String nome, Pageable paginacao) {

        return artistaRepository.findByNomeContainsIgnoreCase(nome, paginacao);
    }

    public Page<Artista> buscarPorNascionalidade(String nascionalidade, Pageable paginacao) {

        return artistaRepository.findByNascionalidadeContainsIgnoreCase(nascionalidade, paginacao);
    }

    public Page<Artista> buscarPorNomeENascionalidade(String nome, String nascionalidade, Pageable paginacao) {

        return artistaRepository.findByNomeContainsIgnoreCaseAndNascionalidadeContainsIgnoreCase(
            nome, nascionalidade, paginacao
        );
    }

    public Artista atualizar(Integer idArtista, Artista artista) {

        Artista artistaAtual = (artistaRepository.findById(idArtista).get());

        BeanUtils.copyProperties(artista, artistaAtual, "idArtista");
        final Artista artistaAtualizado = (this.salvar(artistaAtual));

        return artistaAtualizado;
    }

    public void excluir(Integer idArtista) {

        Artista artista = this.buscar(idArtista);
        artistaRepository.delete(artista);
    }
}
