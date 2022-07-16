package edu.ifma.keeper.api.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import edu.ifma.keeper.api.dto.request.ArtistaRequest;
import edu.ifma.keeper.api.dto.response.ArtistaResponse;
import edu.ifma.keeper.domain.model.Artista;
import lombok.AllArgsConstructor;

/**
 * Classe Adapter da Camada de Apresentacao
 */
@Component
@AllArgsConstructor
public class ArtistaMapper {

    private final ModelMapper modelMapper;

    public Artista toEntity(ArtistaRequest artistaRequest) {
        return modelMapper.map(artistaRequest, Artista.class);
    }

    public ArtistaResponse toResponse(Artista artista) {
        return modelMapper.map(artista, ArtistaResponse.class);
    }

    public List<Artista> toEntityList(List<ArtistaRequest> listaArtistaRequest) {
        return listaArtistaRequest.stream()
            .map(this::toEntity)
            .collect(Collectors.toList());
    }

    public List<ArtistaResponse> toResponseList(List<Artista> listaArtista) {
        return listaArtista.stream()
            .map(this::toResponse)
            .collect(Collectors.toList());
    }
}
