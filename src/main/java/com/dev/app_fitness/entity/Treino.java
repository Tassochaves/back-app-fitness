package com.dev.app_fitness.entity;

import java.util.Date;

import com.dev.app_fitness.dto.TreinoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private Date data;
    private int duracao;
    private int caloriasQueimadas;

    //Converte Treino para TreinoDTO
    public TreinoDTO obterTreinoDTO(){

        TreinoDTO treinoDTO = new TreinoDTO();
        treinoDTO.setId(id);
        treinoDTO.setTipo(tipo);
        treinoDTO.setData(data);
        treinoDTO.setDuracao(duracao);
        treinoDTO.setCaloriasQueimadas(caloriasQueimadas);

        return treinoDTO;
    }
}
