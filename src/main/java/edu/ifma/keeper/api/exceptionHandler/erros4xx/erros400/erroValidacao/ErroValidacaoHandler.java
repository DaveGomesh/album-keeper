package edu.ifma.keeper.api.exceptionHandler.erros4xx.erros400.erroValidacao;

import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestControllerAdvice
public class ErroValidacaoHandler {

    private final MessageSource messageSource;
    
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErroValidacao handlerErroDeValidacao(MethodArgumentNotValidException exception) {

        final ErroValidacao erroDeValidacao = new ErroValidacao();

        final List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(fieldError -> {
            String mensagem = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
            CampoInvalido erro = new CampoInvalido(fieldError.getField(), mensagem);
            erroDeValidacao.adicionarCampoInvalido(erro);
        });

        return erroDeValidacao;
    }
}
