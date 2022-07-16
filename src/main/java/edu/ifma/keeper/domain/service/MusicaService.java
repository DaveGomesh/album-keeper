package edu.ifma.keeper.domain.service;

import org.springframework.stereotype.Service;

import edu.ifma.keeper.domain.repository.MusicaRepository;
import lombok.Builder;

@Builder
@Service
public class MusicaService {
    
    private final MusicaRepository musicaRepository;
}
