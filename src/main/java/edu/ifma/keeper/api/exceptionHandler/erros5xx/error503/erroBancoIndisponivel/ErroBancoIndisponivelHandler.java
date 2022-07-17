package edu.ifma.keeper.api.exceptionHandler.erros5xx.error503.erroBancoIndisponivel;

import org.hibernate.exception.JDBCConnectionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import edu.ifma.keeper.api.exceptionHandler.erros5xx.error503.ErroServiceUnavailable;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestControllerAdvice
public class ErroBancoIndisponivelHandler {
    
    @ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(JDBCConnectionException.class)
    public ResponseEntity<ErroServiceUnavailable> erroBancoIndisponivelHandlerHandler(JDBCConnectionException exception) {

        ErroServiceUnavailable erroBancoIndisponivel = new ErroServiceUnavailable();
        erroBancoIndisponivel.setDescricao("Banco de Dados Indisponível");
        erroBancoIndisponivel.setMensagem(
            "O Servidor não consegue se conectar ao Banco de Dados no momento."
        );
        return new ResponseEntity<>(erroBancoIndisponivel, HttpStatus.SERVICE_UNAVAILABLE);
    }
}
