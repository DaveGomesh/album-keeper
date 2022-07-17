package edu.ifma.keeper.api.exceptionHandler.erros5xx.erros500;

import org.springframework.http.HttpStatus;

import edu.ifma.keeper.api.exceptionHandler.Erro;

public class ErroInternalServerError extends Erro {

    public ErroInternalServerError() {
        
        super();
        this.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
        this.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());
        this.setDescricao("Erro de Servidor");
    }
}
