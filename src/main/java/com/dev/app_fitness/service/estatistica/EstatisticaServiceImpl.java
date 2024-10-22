package com.dev.app_fitness.service.estatistica;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dev.app_fitness.dto.EstatisticaDTO;
import com.dev.app_fitness.dto.GraficoDTO;
import com.dev.app_fitness.entity.Atividade;
import com.dev.app_fitness.entity.Treino;
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

    @Override
    public GraficoDTO obtemDadosParaGrafico(){
        Pageable pageable = PageRequest.of(0, 7);

        List<Treino> treinos = treinoRepository.obtemUltimosSeteTreinos(pageable);
        List<Atividade> atividades = atividadeRepository.obtemUltimasSeteAtividades(pageable);

        GraficoDTO graficoDTO = new GraficoDTO();
        graficoDTO.setTreinos(treinos.stream().map(Treino::obterTreinoDTO).collect(Collectors.toList()));

        graficoDTO.setAtividades(atividades.stream().map(Atividade::obterAtividadeDTO).collect(Collectors.toList()));

        return graficoDTO;
    }
}
