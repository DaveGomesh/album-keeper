package edu.ifma.keeper.api.exceptionHandler.erros4xx.erros400.regraNegocio;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import edu.ifma.keeper.api.exceptionHandler.erros4xx.erros400.ErroBadRequest;
import edu.ifma.keeper.domain.exception.RegraNegocioException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestControllerAdvice
public class RegraNegocioHandler {
    
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RegraNegocioException.class)
    public ErroBadRequest handler(RegraNegocioException exception){
        
        final ErroBadRequest regraNegocio = new ErroBadRequest();
        regraNegocio.setMensagem(exception.getMessage());
        return regraNegocio;
    }
}
