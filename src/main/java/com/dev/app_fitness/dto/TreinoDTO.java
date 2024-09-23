package com.dev.app_fitness.dto;
import java.util.Date;
import lombok.Data;

@Data
public class TreinoDTO {

    private Long id;
    private String tipo;
    private Date data;
    private int duracao;
    private int caloriasQueimadas;
}
