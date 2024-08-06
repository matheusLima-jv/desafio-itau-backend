package com.itau.projeto.Desafio.Itau.controller;

import com.itau.projeto.Desafio.Itau.repository.TransacoesRepository;
import com.itau.projeto.Desafio.Itau.request.TransacaoRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/transacao", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class TransacoesController {

    @Autowired
    private final TransacoesRepository transacoesRepository;

    public TransacoesController(TransacoesRepository transacoesRepository) {
        this.transacoesRepository = transacoesRepository;
    }

    @PostMapping
    public ResponseEntity addTransaction(@RequestBody TransacaoRequest transacaoRequest){
    log.info(" Adicionando Transação ");

        try {
        validaTransacao(transacaoRequest);
        transacoesRepository.add(transacaoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    private void validaTransacao(TransacaoRequest transacaoRequest) {
        if(transacaoRequest.getValor().compareTo(BigDecimal.ZERO) < 0 ){
            throw new IllegalArgumentException(" Valor de transação invalido ");
        }
    }

}
