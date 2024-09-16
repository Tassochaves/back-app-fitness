package com.dev.app_fitness.entity;

import java.util.Date;

import com.dev.app_fitness.dto.AtividadeDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date data;

    private int passos;

    private double distancia;

    private int caloriasQueimadas;


    public AtividadeDTO obterAtividadeDTO(){

        AtividadeDTO atividadeDTO = new AtividadeDTO();

        atividadeDTO.setId(id);
        atividadeDTO.setData(data);
        atividadeDTO.setDistancia(distancia);
        atividadeDTO.setPassos(passos);
        atividadeDTO.setCaloriasQueimadas(caloriasQueimadas);

        return atividadeDTO;
    }

}
