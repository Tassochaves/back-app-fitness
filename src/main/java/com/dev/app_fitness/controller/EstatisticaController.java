package com.dev.app_fitness.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.app_fitness.dto.GraficoDTO;
import com.dev.app_fitness.service.estatistica.EstatisticaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EstatisticaController {

    private final EstatisticaService estatisticaService;

    @GetMapping("/estatisticas")
    public ResponseEntity<?> obtemEstatisticas(){
        return ResponseEntity.ok(estatisticaService.obtemEstatistica());
    }

    @GetMapping("/graficos")
    public ResponseEntity<?> obtemEstatisticasGrafico(){
        GraficoDTO graficoDTO = estatisticaService.obtemDadosParaGrafico();

        if (graficoDTO != null) {
            return ResponseEntity.ok(graficoDTO);
        } else {
            return ResponseEntity.status(404).body(null);
        }
        
    }
}
