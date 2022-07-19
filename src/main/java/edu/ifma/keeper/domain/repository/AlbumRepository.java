package edu.ifma.keeper.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ifma.keeper.domain.model.Album;
import edu.ifma.keeper.domain.model.Artista;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

    List<Album> findByParticipantes(Artista participante);
}
