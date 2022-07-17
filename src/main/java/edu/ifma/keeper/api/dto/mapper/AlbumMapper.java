package edu.ifma.keeper.api.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import edu.ifma.keeper.api.dto.request.AlbumRequest;
import edu.ifma.keeper.api.dto.response.AlbumResponse;
import edu.ifma.keeper.domain.model.Album;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AlbumMapper {

    private final ModelMapper modelMapper;

    public Album toEntity(AlbumRequest albumRequest) {
        
        // // Ignora o mapeamento ambiguo para idMusica
        // modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper.map(albumRequest, Album.class);
    }

    public AlbumResponse toResponse(Album album) {
        return modelMapper.map(album, AlbumResponse.class);
    }

    public List<Album> toEntityList(List<AlbumRequest> listaAlbumRequest) {
        return listaAlbumRequest.stream()
            .map(this::toEntity)
            .collect(Collectors.toList());
    }

    public List<AlbumResponse> toResponseList(List<Album> listaAlbum) {
        return listaAlbum.stream()
            .map(this::toResponse)
            .collect(Collectors.toList());
    }
}
