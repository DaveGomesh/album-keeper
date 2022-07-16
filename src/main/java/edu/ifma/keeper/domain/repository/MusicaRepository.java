package edu.ifma.keeper.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ifma.keeper.domain.model.Musica;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Integer> {
    
}
