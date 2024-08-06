package com.itau.projeto.Desafio.Itau.repository;

import com.itau.projeto.Desafio.Itau.request.TransacaoRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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


}
