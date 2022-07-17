package edu.ifma.keeper.api.exceptionHandler.erros4xx.erros400;

import org.springframework.http.HttpStatus;

import edu.ifma.keeper.api.exceptionHandler.Erro;

public class ErroBadRequest extends Erro {

    public ErroBadRequest() {
        
        super();
        this.setCodigo(HttpStatus.BAD_REQUEST.value());
        this.setStatus(HttpStatus.BAD_REQUEST.name());
        this.setDescricao("Erro do Cliente");
    }
}
