package edu.ifma.keeper.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ifma.keeper.domain.model.Artista;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Integer> {
    
    List<Artista> findByNomeContainsIgnoreCase(String nome);
    
    List<Artista> findByNascionalidadeContainsIgnoreCase(String nascionalidade);

    List<Artista> findByNomeContainsIgnoreCaseAndNascionalidadeContainsIgnoreCase(String nome, String nascionalidade);
    
}
