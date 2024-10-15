package com.dev.app_fitness.dto;

import lombok.Data;

@Data
public class EstatisticaDTO {

    private long metasAlcancadas;

    private long metasNaoAlcancadas;

    private int passos;

    private Double distancia;

    private int totalCaloriasQueimadas;

    private int duracao;
}
