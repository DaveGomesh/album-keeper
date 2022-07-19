package edu.ifma.keeper.domain.relatorio;

import java.util.List;

import lombok.Data;

@Data
public class AlbumDetails {
    
    private Integer idAlbum;
    private String nome;
    private Integer ano;
    private List<String> participantes;
    private Integer duracaoAlbum;
}
