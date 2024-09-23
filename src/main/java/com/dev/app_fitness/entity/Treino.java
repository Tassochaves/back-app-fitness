package com.dev.app_fitness.entity;

import java.util.Date;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Treino {

    private Long id;
    private String tipo;
    private Date data;
    private int duracao;
    private int caloriasQueimadas;
}
