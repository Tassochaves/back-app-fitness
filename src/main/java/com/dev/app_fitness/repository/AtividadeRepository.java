package com.dev.app_fitness.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dev.app_fitness.entity.Atividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long>{

    @Query("SELECT SUM(a.passos) FROM Atividade a")
    Integer obtemTotalPassos();

    @Query("SELECT SUM(a.distancia) FROM Atividade a")
    Double obtemTotalDistancia();

    @Query("SELECT SUM(a.caloriasQueimadas) FROM Atividade a")
    Integer obtemTotalCaloriasAtividade();

    @Query("SELECT a FROM Atividade a ORDER BY a.data DESC")
    List<Atividade> obtemUltimasSeteAtividades(Pageable pageable);

}
