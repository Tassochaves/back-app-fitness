package com.dev.app_fitness.service.estatistica;

import com.dev.app_fitness.dto.EstatisticaDTO;
import com.dev.app_fitness.dto.GraficoDTO;

public interface EstatisticaService {

    EstatisticaDTO obtemEstatistica();

    GraficoDTO obtemDadosParaGrafico();
}
