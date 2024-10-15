package com.dev.app_fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dev.app_fitness.entity.Treino;

public interface TreinoRepository extends JpaRepository<Treino, Long>{

    @Query("SELECT SUM(t.duracao) FROM Treino t")
    Integer obtemTotalDuracao();

    @Query("SELECT SUM(t.caloriasQueimadas) FROM Treino t")
    Integer obtemTotalCaloriasQueimadas();

}
