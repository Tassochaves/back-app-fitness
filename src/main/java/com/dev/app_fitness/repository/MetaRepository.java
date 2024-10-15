package com.dev.app_fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dev.app_fitness.entity.Meta;

@Repository
public interface MetaRepository extends JpaRepository<Meta, Long>{

    @Query("SELECT COUNT(m) FROM Meta m WHERE m.alcancada = true")
    Long contarMetasAlcancadas();

    @Query("SELECT COUNT(m) FROM Meta m WHERE m.alcancada = false")
    Long contarMetasNaoAlcancadas();
}
