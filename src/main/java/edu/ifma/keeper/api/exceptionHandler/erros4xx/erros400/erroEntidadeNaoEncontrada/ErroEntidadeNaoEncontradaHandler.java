package edu.ifma.keeper.api.exceptionHandler.erros4xx.erros400.erroEntidadeNaoEncontrada;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import edu.ifma.keeper.api.exceptionHandler.erros4xx.erros400.ErroBadRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestControllerAdvice
public class ErroEntidadeNaoEncontradaHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NoSuchElementException.class)
    public ErroBadRequest handlerErroEntidadeNaoEncontrada(NoSuchElementException exception){

        final ErroBadRequest erroEntidadeNaoEncontrada = new ErroBadRequest();
        erroEntidadeNaoEncontrada.setDescricao("Entidade não encontrada");
        erroEntidadeNaoEncontrada.setMensagem(
            "O Servidor tentou buscar a entidade com os dados informados, porém, não a encontrou."
        );
        return erroEntidadeNaoEncontrada;
    }
}
