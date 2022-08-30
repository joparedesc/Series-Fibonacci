package com.series.fibonacci.repository;

import com.series.fibonacci.model.SerieFibonacci;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SerieFibonacciRepository extends JpaRepository <SerieFibonacci,Long>{

    Optional<SerieFibonacci> findBySizeSerie(Long idSerie);
}
