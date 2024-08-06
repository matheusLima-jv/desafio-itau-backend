package com.itau.projeto.Desafio.Itau.request;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class TransacaoRequest {

    private BigDecimal valor;
    private OffsetDateTime dataHora;
}
