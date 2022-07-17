package edu.ifma.keeper.api.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ArtistaRequest {
    
    @NotNull @NotBlank
    private String nome;
    
    @NotNull @NotBlank
    private String nascionalidade;
}
