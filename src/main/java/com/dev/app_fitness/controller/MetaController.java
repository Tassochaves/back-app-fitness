package com.dev.app_fitness.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.app_fitness.dto.MetaDTO;
import com.dev.app_fitness.service.meta.MetaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MetaController {

    private final MetaService metaService;

    @PostMapping("/meta")
    public ResponseEntity<?> postarMeta(@RequestBody MetaDTO metaDTO){

        try {
            return ResponseEntity.ok(metaService.postarMeta(metaDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/metas")
    public ResponseEntity<?> listarMetas(){
        try {
            return ResponseEntity.ok(metaService.listarMetas());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao listar metas!");
        }
    }
}
