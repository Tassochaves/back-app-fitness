package com.dev.app_fitness.service.atividade;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dev.app_fitness.dto.AtividadeDTO;
import com.dev.app_fitness.entity.Atividade;
import com.dev.app_fitness.repository.AtividadeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AtividadeServiceImpl implements AtividadeService{

    private final AtividadeRepository atividadeRepository;

    public AtividadeDTO postarAtividade(AtividadeDTO dto){

        Atividade atividade = new Atividade();

        atividade.setData(dto.getData());
        atividade.setPassos(dto.getPassos());
        atividade.setDistancia(dto.getDistancia());
        atividade.setCaloriasQueimadas(dto.getCaloriasQueimadas());

        return atividadeRepository.save(atividade).obterAtividadeDTO();
    }

    public List<AtividadeDTO> obterAtividades(){
        List<Atividade> atividades = atividadeRepository.findAll();

        return atividades.stream().map(Atividade::obterAtividadeDTO).collect(Collectors.toList());
    }
}
