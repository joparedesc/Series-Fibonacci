package com.series.fibonacci.service;

import com.series.fibonacci.model.response.CalculateFibonacciResponse;

public interface SaveRequestService {

    void crearArchivo(CalculateFibonacciResponse calculateFibonacciResponse, Long valueRequest) ;

}
