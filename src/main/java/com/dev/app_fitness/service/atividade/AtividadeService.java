package com.dev.app_fitness.service.atividade;

import java.util.List;

import com.dev.app_fitness.dto.AtividadeDTO;

public interface AtividadeService {

    AtividadeDTO postarAtividade(AtividadeDTO dto);

    List<AtividadeDTO> obterAtividades();
    
}
