package edu.ifma.keeper.api.dto.request;

import java.util.Set;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import edu.ifma.keeper.domain.model.Artista;
import edu.ifma.keeper.domain.model.Musica;
import lombok.Data;

@Data
public class AlbumRequest {

    @NotNull @NotBlank
    private String nome;
    
    @NotNull @Min(0)
    private Integer ano;

    private Set<Artista> participantes;
    private Set<Musica> musicas;

}
