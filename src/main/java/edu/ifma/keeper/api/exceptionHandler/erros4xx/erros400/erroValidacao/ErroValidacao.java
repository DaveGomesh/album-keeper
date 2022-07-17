package edu.ifma.keeper.api.exceptionHandler.erros4xx.erros400.erroValidacao;

import java.util.ArrayList;
import java.util.List;

import edu.ifma.keeper.api.exceptionHandler.erros4xx.erros400.ErroBadRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ErroValidacao extends ErroBadRequest {

    public ErroValidacao() {

        super();
        this.setDescricao("Um ou mais campos inválidos");
        this.setMensagem("A validação rejeitou valores inválidos enviados.");
    }

    private List<CampoInvalido> listaCamposInvalidos = new ArrayList<>();

    public final Boolean adicionarCampoInvalido(CampoInvalido campoInvalido) {
        return listaCamposInvalidos.add(campoInvalido);
    }
}