package edu.ifma.keeper.api.dto.request;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class MusicaRequest {
    
    @NotNull @NotBlank
    private String nome;
    
    @NotNull
    private Integer duracao;

    private Set<Integer> idAutores;
    private Set<Integer> idCantores;
}
