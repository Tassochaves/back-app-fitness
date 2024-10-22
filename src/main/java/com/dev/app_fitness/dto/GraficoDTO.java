package com.dev.app_fitness.dto;

import java.util.List;

import lombok.Data;

@Data
public class GraficoDTO {

    private List<TreinoDTO> treinos;
    private List<AtividadeDTO> atividades;
}
