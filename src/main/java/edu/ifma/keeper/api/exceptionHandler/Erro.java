package edu.ifma.keeper.api.exceptionHandler;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Erro {

    private Integer codigo;
    private String status;
    private LocalDateTime dataHora;
    private String descricao;
    private String mensagem;

    public Erro() {
        this.dataHora = LocalDateTime.now();
    }
}
