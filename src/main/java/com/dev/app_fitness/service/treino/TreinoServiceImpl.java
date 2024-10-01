package com.dev.app_fitness.service.treino;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dev.app_fitness.dto.TreinoDTO;
import com.dev.app_fitness.entity.Treino;
import com.dev.app_fitness.repository.TreinoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TreinoServiceImpl implements TreinoService{

    private final TreinoRepository treinoRepository;

    public TreinoDTO postarTreino(TreinoDTO treinoDTO){

        Treino treino = new Treino();

        treino.setTipo(treinoDTO.getTipo());
        treino.setDuracao(treinoDTO.getDuracao());
        treino.setCaloriasQueimadas(treinoDTO.getCaloriasQueimadas());
        treino.setData(treinoDTO.getData());

        return treinoRepository.save(treino).obterTreinoDTO();
    }

    public List<TreinoDTO> listarTreinos(){
        
        List<Treino> treinos = treinoRepository.findAll();

        return treinos.stream().map(Treino::obterTreinoDTO).collect(Collectors.toList());
    }
}
