package com.series.fibonacci.service;

import com.series.fibonacci.model.SerieFibonacci;

import java.util.List;
import java.util.Optional;

public interface FibonacciSeriesService {

    SerieFibonacci saveSerieFibonacci(SerieFibonacci serieFibonacci);

    Optional<SerieFibonacci> getSerieFibonacciBySizeSerie(Long idSerie);

    List<SerieFibonacci> getListSerieFibonacci();

    boolean deleteSerieFibonacci(Long idSerie);
}
