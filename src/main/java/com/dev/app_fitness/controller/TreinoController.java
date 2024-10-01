package com.dev.app_fitness.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.app_fitness.dto.TreinoDTO;
import com.dev.app_fitness.service.treino.TreinoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TreinoController {

    private final TreinoService treinoService;

    @PostMapping("/treino")
    public ResponseEntity<?> postarTreino(@RequestBody TreinoDTO treinoDTO){
        
        try {
            return ResponseEntity.ok(treinoService.postarTreino(treinoDTO));    
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao postar treino!");
        }
    }

    @GetMapping("/treinos")
    public ResponseEntity<?> listarTreinos(){
        try {
            return ResponseEntity.ok(treinoService.listarTreinos());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao listar os treinos!");
        }
    }
}
