package com.dev.app_fitness.dto;

import java.util.Date;

import lombok.Data;

@Data
public class AtividadeDTO {

    private Long id;
    private Date data;
    private int passos;
    private double distancia;
    private int caloriasQueimadas;
}
