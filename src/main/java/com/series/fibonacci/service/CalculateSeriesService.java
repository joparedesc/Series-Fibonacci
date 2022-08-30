package com.series.fibonacci.service;

import com.series.fibonacci.model.response.CalculateFibonacciResponse;
import com.series.fibonacci.model.response.SeriesFibonacciResponse;

/**
 * SeriesService interface.
 * Interface with  methods definitions to calculate Fibonacci Series.
 * @author jesu_
 */
public interface CalculateSeriesService {


    CalculateFibonacciResponse getSeriesFibonacci(Long seriesLength);

    CalculateFibonacciResponse getSeriesFibonacciLimit(Long seriesLength);

    SeriesFibonacciResponse getAllSeriesFibonacci();

    /**
     * CalculateFibonacci definition method.
     * Method to calculate Series Fibonacci with length limit of items.
     * @param seriesLength limit of items.
     * @return String Fibonacci sequences with length limit of items.
     * @throws IllegalArgumentException if the length is less than one or greater 93.
     */
    Long[] calculateSeriesFibonacci(Long seriesLength);

    /**
     * CalculateSeriesFibonacciLimit definition method.
     * Method to calculate Series Fibonacci with value limit less or equal than last item.
     * @param limit value limit less or equal than last item of  Fibonacci sequence.
     * @return String Fibonacci sequence less o equal than length limit value.
     * @throws IllegalArgumentException if the length is less than one or greater 93.
     */
    Long[] calculateSeriesFibonacciLimit(Long limit);

    /**
     * ConvertFibonacciToString definition method.
     * Method to convert a Fibonacci series to string.
     * @param valuesFibonacci array with values of Fibonacci series.
     * @return the Fibonacci sequence as a String.
     */
    String convertFibonacciToString(long[] valuesFibonacci);

}
