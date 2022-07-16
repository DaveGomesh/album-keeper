package edu.ifma.keeper.domain.service;

import org.springframework.stereotype.Service;

import edu.ifma.keeper.domain.repository.ArtistaRepository;
import lombok.Builder;

@Builder
@Service
public class ArtistaService {
    
    private final ArtistaRepository artistaRepository;
}
