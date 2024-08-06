package com.itau.projeto.Desafio.Itau.controller;

import com.itau.projeto.Desafio.Itau.repository.TransacoesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
@RequestMapping(value = "/estatistica", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class EstatisticaController {

    @Autowired
    private final TransacoesRepository transacoesRepository;

    public EstatisticaController(TransacoesRepository transacoesRepository) {
        this.transacoesRepository = transacoesRepository;
    }

    @GetMapping
    public ResponseEntity getEstatistica(){
        log.info(" Apresentando as estatisticas de processamento ");
        Integer intervaloMaximoSeg = 60;
        final var horaInicial = OffsetDateTime.now().minusSeconds(intervaloMaximoSeg);
        return ResponseEntity.ok(transacoesRepository.estatistica(horaInicial));
    }
}
