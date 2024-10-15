package com.dev.app_fitness.service.estatistica;

import org.springframework.stereotype.Service;

import com.dev.app_fitness.dto.EstatisticaDTO;
import com.dev.app_fitness.repository.AtividadeRepository;
import com.dev.app_fitness.repository.MetaRepository;
import com.dev.app_fitness.repository.TreinoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstatisticaServiceImpl implements EstatisticaService{

    private final MetaRepository metaRepository;
    private final AtividadeRepository atividadeRepository;
    private final TreinoRepository treinoRepository;

    public EstatisticaDTO obtemEstatistica(){

        Long metasAlcancadas = metaRepository.contarMetasAlcancadas();
        Long metasNaoAlcancadas = metaRepository.contarMetasNaoAlcancadas();

        Integer totalPassos = atividadeRepository.obtemTotalPassos();
        Double totalDistancia = atividadeRepository.obtemTotalDistancia();
        Integer totalCaloriasAtividade = atividadeRepository.obtemTotalCaloriasAtividade();
        Integer totalDuracaoTreino = treinoRepository.obtemTotalDuracao();
        Integer totalCaloriasQueimadasTreino = treinoRepository.obtemTotalCaloriasQueimadas();

        int totalDeCaloriasQueimadas = (totalCaloriasAtividade != null ? totalCaloriasAtividade : 0) +
                                        (totalCaloriasQueimadasTreino != null ? totalCaloriasQueimadasTreino : 0);

        EstatisticaDTO estatisticaDTO = new EstatisticaDTO();
        estatisticaDTO.setMetasAlcancadas(metasAlcancadas != null ? metasAlcancadas : 0);
        estatisticaDTO.setMetasNaoAlcancadas(metasNaoAlcancadas != null ? metasNaoAlcancadas : 0);

        estatisticaDTO.setPassos(totalPassos != null ? totalPassos : 0);
        estatisticaDTO.setDistancia(totalDistancia != null ? totalDistancia : 0);
        estatisticaDTO.setTotalCaloriasQueimadas(totalDeCaloriasQueimadas);
        estatisticaDTO.setDuracao(totalDuracaoTreino != null ? totalDuracaoTreino : 0);

        return estatisticaDTO;
    }
}
