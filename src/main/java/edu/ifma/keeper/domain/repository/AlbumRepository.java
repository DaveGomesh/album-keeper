package edu.ifma.keeper.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ifma.keeper.domain.model.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {
    
}
