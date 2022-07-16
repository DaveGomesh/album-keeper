package edu.ifma.keeper.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ifma.keeper.domain.model.Artista;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Integer> {
    
}
