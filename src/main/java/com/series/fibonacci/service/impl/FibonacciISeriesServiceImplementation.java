package com.series.fibonacci.service.impl;

import com.series.fibonacci.service.SeriesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * FibonacciISeriesServiceImplementation class.
 * Class with  methods implementations to calculate Fibonacci Series.
 * @author jesu_
 */
@Service
public class FibonacciISeriesServiceImplementation implements SeriesService {

    /** Minimum length. */
    public static final int LENGTH_MIN = 1;

    /** Maximum length. */
    public static final int LENGTH_MAX = 93;

    /**
     * ConvertFibonacciToString definition method.
     * Method to convert a Fibonacci series to string.
     * @param valuesFibonacci array with values of Fibonacci series.
     * @return the Fibonacci sequence as a String.
     */
    public String convertFibonacciToString(long[] valuesFibonacci) {
        final StringBuilder itemsFibonacci = new StringBuilder();
        boolean flag = true;
        for (long val : valuesFibonacci) {
            if (flag) {
                flag = false;
            } else {
                itemsFibonacci.append(" ");
            }
            itemsFibonacci.append(val);
        }
        return itemsFibonacci.toString();
    }
    /**
     * CalculateFibonacci implementation method.
     * Method to calculate Series Fibonacci with length limit of items.
     * @param seriesLength limit of items.
     * @return String Fibonacci sequences with length limit of items.
     * @throws IllegalArgumentException if the length is less than one or greater 93.
     */
    public String calculateSeriesFibonacci(int seriesLength) throws IllegalArgumentException {
        final long[] itemsFibonacci;
        if (seriesLength < FibonacciISeriesServiceImplementation.LENGTH_MIN) {
            throw new IllegalArgumentException(
                    String.format("Length was less than %d. [%d]",
                            FibonacciISeriesServiceImplementation.LENGTH_MIN, seriesLength)
            );
        } else if (seriesLength > FibonacciISeriesServiceImplementation.LENGTH_MAX) {
            throw new IllegalArgumentException(
                    String.format("Length was greater than %d. [%d]",
                            FibonacciISeriesServiceImplementation.LENGTH_MAX, seriesLength)
            );
        } else {
            itemsFibonacci = new long[seriesLength];
        }

        itemsFibonacci[0] = 0;
        if (itemsFibonacci.length > 1) {
            itemsFibonacci[1] = 1;
        }
        for (int idx = 2; idx < itemsFibonacci.length; idx++) {
            itemsFibonacci[idx] = itemsFibonacci[idx - 1] + itemsFibonacci[idx - 2];
        }
        return convertFibonacciToString(itemsFibonacci);
    }

    /**
     * CalculateSeriesFibonacciLimit implementation method.
     * Method to calculate Series Fibonacci with value limit less or equal than last item.
     * @param limit value limit less or equal than last item of  Fibonacci sequence.
     * @return String Fibonacci sequence less o equal than length limit value.
     * @throws IllegalArgumentException if the length is less than one or greater 93.
     */
    public String calculateSeriesFibonacciLimit(int limit){
        List<Integer> itemsFibonacci;
        if (limit < FibonacciISeriesServiceImplementation.LENGTH_MIN) {
            throw new IllegalArgumentException(
                    String.format("Length was less than %d. [%d]",
                            FibonacciISeriesServiceImplementation.LENGTH_MIN, limit)
            );
        } else if (limit > FibonacciISeriesServiceImplementation.LENGTH_MAX) {
            throw new IllegalArgumentException(
                    String.format("Length was greater than %d. [%d]",
                            FibonacciISeriesServiceImplementation.LENGTH_MAX, limit)
            );
        } else {
            itemsFibonacci = new ArrayList();
            itemsFibonacci.add(0);
            itemsFibonacci.add(1);
            itemsFibonacci.add(1);
        }

        int currentItem=itemsFibonacci.get(itemsFibonacci.size()-1);
        int cont=itemsFibonacci.size();
        while(currentItem<limit){
            currentItem=itemsFibonacci.get(cont-1)+itemsFibonacci.get(cont-2);
            if(currentItem<=limit){
                itemsFibonacci.add(currentItem);
            }
            cont++;
        }
        final long[] arrayFibonacci;
        arrayFibonacci= new long[itemsFibonacci.size()];
        for (int idx = 0; idx < arrayFibonacci.length; idx++) {
            arrayFibonacci[idx] = itemsFibonacci.get(idx);
        }
        return convertFibonacciToString(arrayFibonacci);

    }

}
