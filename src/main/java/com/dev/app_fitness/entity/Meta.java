package com.dev.app_fitness.entity;

import java.util.Date;

import com.dev.app_fitness.dto.MetaDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Meta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private Date dataInicio;
    private Date dataFim;
    private boolean alcancada;

    public MetaDTO obterMetaDTO(){

        MetaDTO metaDTO = new MetaDTO();
        metaDTO.setId(id);
        metaDTO.setDescricao(descricao);
        metaDTO.setDataInicio(dataInicio);
        metaDTO.setDataFim(dataFim);
        metaDTO.setAlcancada(alcancada);

        return metaDTO;
    }
}
