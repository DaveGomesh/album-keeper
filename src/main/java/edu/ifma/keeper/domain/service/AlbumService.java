package edu.ifma.keeper.domain.service;

import org.springframework.stereotype.Service;

import edu.ifma.keeper.domain.repository.AlbumRepository;
import lombok.Builder;

@Builder
@Service
public class AlbumService {
    
    private final AlbumRepository albumRepository;
}
