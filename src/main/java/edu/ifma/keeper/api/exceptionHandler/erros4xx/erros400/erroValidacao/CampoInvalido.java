package edu.ifma.keeper.api.exceptionHandler.erros4xx.erros400.erroValidacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampoInvalido {
    
    private String descricao;
    private String messagem;
}
