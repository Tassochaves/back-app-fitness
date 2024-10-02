package com.dev.app_fitness.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MetaDTO {

    private Long id;

    private String descricao;
    private Date dataInicio;
    private Date dataFim;
    private boolean alcancada;
}
