package edu.ifma.keeper.api.exceptionHandler.erros5xx.error503;

import org.springframework.http.HttpStatus;

import edu.ifma.keeper.api.exceptionHandler.Erro;

public class ErroServiceUnavailable extends Erro {
    
    public ErroServiceUnavailable() {

        super();
        this.setCodigo(HttpStatus.SERVICE_UNAVAILABLE.value());
        this.setStatus(HttpStatus.SERVICE_UNAVAILABLE.name());
        this.setDescricao("Servico Indisponível");
    }
}
