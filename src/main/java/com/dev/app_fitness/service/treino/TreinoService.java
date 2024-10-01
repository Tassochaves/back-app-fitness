package com.dev.app_fitness.service.treino;

import java.util.List;

import com.dev.app_fitness.dto.TreinoDTO;

public interface TreinoService {

    TreinoDTO postarTreino(TreinoDTO treinoDTO);
    List<TreinoDTO> listarTreinos();
}
