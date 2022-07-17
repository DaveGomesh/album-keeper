package edu.ifma.keeper.api.dto.response;

import java.util.Set;

import lombok.Data;

@Data
public class MusicaResponse {
    
    private Integer idMusica;
    private String nome;
    private Integer duracao;
    private Set<ArtistaResponse> autores;
    private Set<ArtistaResponse> cantores;
}
