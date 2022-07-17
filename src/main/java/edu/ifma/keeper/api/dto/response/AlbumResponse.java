package edu.ifma.keeper.api.dto.response;

import java.util.Set;

import lombok.Data;

@Data
public class AlbumResponse {

    private Integer idAlbum;
    private String nome;
    private Integer ano;
    private Set<ArtistaResponse> participantes;
    private Set<MusicaResponse> musicas;
}
