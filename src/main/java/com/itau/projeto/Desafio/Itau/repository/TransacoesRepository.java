package com.itau.projeto.Desafio.Itau.repository;

import com.itau.projeto.Desafio.Itau.request.EstatisticaRequest;
import com.itau.projeto.Desafio.Itau.request.TransacaoRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;

@Repository
@Slf4j
public class TransacoesRepository {

    private final List<TransacaoRequest> transacoes = new ArrayList<>();

    public void add( TransacaoRequest transacaoRequest){
        transacoes.add(transacaoRequest);
        log.info("Transação adicionada: {}", transacaoRequest);
    }

    public void delete(){
        transacoes.clear();
        log.info(" Transações Limpas. ");
    }

    public EstatisticaRequest estatistica(OffsetDateTime horaInicial){

        if(transacoes.isEmpty()){
            log.info("Nenhuma transação encontrada.");
            return new EstatisticaRequest();
        } else {
            final BigDecimal[] valoresFiltrados = transacoes.stream()
                    .filter(t -> t.getDataHora().isAfter(horaInicial) || t.getDataHora().equals(horaInicial))
                    .map(t -> t.getValor())
                    .toArray(BigDecimal[]::new);

            log.info("Valores filtrados: {}", Arrays.toString(valoresFiltrados));

            DoubleStream doubleStream = Arrays.stream(valoresFiltrados)
                    .mapToDouble(BigDecimal::doubleValue);

            return new EstatisticaRequest(doubleStream.summaryStatistics());
        }

    }


}
