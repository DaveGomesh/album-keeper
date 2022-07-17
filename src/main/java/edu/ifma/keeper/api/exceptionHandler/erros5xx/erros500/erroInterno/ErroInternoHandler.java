package edu.ifma.keeper.api.exceptionHandler.erros5xx.erros500.erroInterno;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import edu.ifma.keeper.api.exceptionHandler.erros5xx.erros500.ErroInternalServerError;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestControllerAdvice
public class ErroInternoHandler {
    
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErroInternalServerError handlerErroInterno(Exception exception){

        final ErroInternalServerError erroInterno = new ErroInternalServerError();
        erroInterno.setDescricao("Erro Interno de Servidor");
        erroInterno.setMensagem(
            "O servidor encontrou uma condição inesperada que o impediu de atender à solicitação."
        );
        return erroInterno;
    }
}
