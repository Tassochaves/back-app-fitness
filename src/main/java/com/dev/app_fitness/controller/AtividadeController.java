package com.dev.app_fitness.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.app_fitness.dto.AtividadeDTO;
import com.dev.app_fitness.service.atividade.AtividadeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AtividadeController {

    private final AtividadeService atividadeService;

    @PostMapping("/atividade")
    public ResponseEntity<?> postarAtividade(@RequestBody AtividadeDTO dto){

        AtividadeDTO criarAtividade = atividadeService.postarAtividade(dto);

        if(criarAtividade != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(criarAtividade);
        }else{
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar atividade!"); 
        }
    }

    @GetMapping("/obterAtividades")
    public ResponseEntity<?> obterAtividades(){

        try {
            return ResponseEntity.ok(atividadeService.obterAtividades());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao obter atividades!"); 
        }
    }
}
