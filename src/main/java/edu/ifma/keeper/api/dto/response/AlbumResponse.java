package edu.ifma.keeper.api.dto.response;

import java.util.Set;

import edu.ifma.keeper.domain.model.Artista;
import edu.ifma.keeper.domain.model.Musica;
import lombok.Data;

@Data
public class AlbumResponse {

    private Integer idAlbum;
    private String nome;
    private Integer ano;
    private Set<Artista> participantes;
    private Set<Musica> musicas;
}
