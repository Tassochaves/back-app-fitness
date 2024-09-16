package com.dev.app_fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.app_fitness.entity.Atividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long>{

}
