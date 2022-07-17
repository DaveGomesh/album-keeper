package edu.ifma.keeper.api.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import edu.ifma.keeper.api.dto.request.MusicaRequest;
import edu.ifma.keeper.api.dto.response.MusicaResponse;
import edu.ifma.keeper.domain.model.Musica;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class MusicaMapper {
    private final ModelMapper modelMapper;

    public Musica toEntity(MusicaRequest musicaRequest) {
        return modelMapper.map(musicaRequest, Musica.class);
    }

    public MusicaResponse toResponse(Musica musica) {
        return modelMapper.map(musica, MusicaResponse.class);
    }

    public List<Musica> toEntityList(List<MusicaRequest> listaMusicaRequest) {
        return listaMusicaRequest.stream()
            .map(this::toEntity)
            .collect(Collectors.toList());
    }

    public List<MusicaResponse> toResponseList(List<Musica> listaMusica) {
        return listaMusica.stream()
            .map(this::toResponse)
            .collect(Collectors.toList());
    }
}
