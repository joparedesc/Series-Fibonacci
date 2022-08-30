package com.series.fibonacci.service.impl;


import com.series.fibonacci.model.SerieFibonacci;
import com.series.fibonacci.repository.SerieFibonacciRepository;
import com.series.fibonacci.service.FibonacciSeriesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class FibonacciSeriesServiceImplementation implements FibonacciSeriesService {

    private final SerieFibonacciRepository serieFibonacciRepository;

    @Override
    public SerieFibonacci saveSerieFibonacci(SerieFibonacci serieFibonacci) {
        return serieFibonacciRepository.save(serieFibonacci);
    }

    @Override
    public Optional<SerieFibonacci> getSerieFibonacciBySizeSerie(Long idSerie) {
        return serieFibonacciRepository.findBySizeSerie(idSerie);

    }

    @Override
    public List<SerieFibonacci> getListSerieFibonacci() {
        return serieFibonacciRepository.findAll();
    }

    @Override
    public boolean deleteSerieFibonacci(Long idSerie) {
        try{
            serieFibonacciRepository.deleteById(idSerie);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
