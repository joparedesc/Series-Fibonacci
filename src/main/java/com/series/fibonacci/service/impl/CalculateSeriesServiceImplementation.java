package com.series.fibonacci.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.series.fibonacci.constants.Constants;
import com.series.fibonacci.constants.LogConstants;
import com.series.fibonacci.model.SerieFibonacci;
import com.series.fibonacci.model.response.CalculateFibonacciResponse;
import com.series.fibonacci.model.response.SeriesFibonacciResponse;
import com.series.fibonacci.service.CalculateSeriesService;
import com.series.fibonacci.service.FibonacciSeriesService;
import com.series.fibonacci.service.SaveRequestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * FibonacciISeriesServiceImplementation class.
 * Class with  methods implementations to calculate Fibonacci Series.
 * @author jesu_
 */
@Slf4j
@Service
@AllArgsConstructor
public class CalculateSeriesServiceImplementation implements CalculateSeriesService {

    private final FibonacciSeriesService fibonacciSeriesService;

    private final SaveRequestService saveRequestService;
    /**
     * CalculateFibonacci implementation method.
     * Method to calculate Series Fibonacci with length limit of items.
     * @param seriesLength limit of items.
     * @return String Fibonacci sequences with length limit of items.
     * @throws IllegalArgumentException if the length is less than one or greater 93.
     */
    public CalculateFibonacciResponse getSeriesFibonacci(Long seriesLength) throws RuntimeException {

        CalculateFibonacciResponse calculateFibonacciResponse;
        Optional<SerieFibonacci> serieFibonacci;
        SerieFibonacci elementFibonacci=new SerieFibonacci();

        try {
            calculateFibonacciResponse=new CalculateFibonacciResponse();

            serieFibonacci=fibonacciSeriesService.getSerieFibonacciBySizeSerie(seriesLength);
            if(serieFibonacci.isPresent()){
                throw new RuntimeException(
                        String.format("Fibonacci series found with length value: [%d]", seriesLength)
                );
            }else {
                elementFibonacci.setSizeSerie(seriesLength);
                elementFibonacci=fibonacciSeriesService.saveSerieFibonacci(elementFibonacci);
                calculateFibonacciResponse.setIdSerie(elementFibonacci.getIdSerie());
                calculateFibonacciResponse.setSizeSerie(seriesLength);
                calculateFibonacciResponse.setItemsFibonacci(calculateSeriesFibonacci(seriesLength));
            }
            saveRequestService.crearArchivo(calculateFibonacciResponse,seriesLength);
            return calculateFibonacciResponse;
        }catch(RuntimeException exception){
            log.error(LogConstants.SOMETHING_WENT_WRONG_WHILE_CALCULATE_FIBONACCI,"UUID",exception.getMessage());
            throw new RuntimeException(exception);
        }
    }

    public SeriesFibonacciResponse getAllSeriesFibonacci(){
        SeriesFibonacciResponse seriesFibonacciResponse = new SeriesFibonacciResponse();
        //Lista de series Fibonacci
        List<SerieFibonacci> listSeriesFibonacci=fibonacciSeriesService.getListSerieFibonacci();

        CalculateFibonacciResponse [] seriesFibonacci= new CalculateFibonacciResponse[listSeriesFibonacci.size()];
        //Element of serie
        CalculateFibonacciResponse calculateFibonacciResponse;
        int contSeries=0;
        for(SerieFibonacci serieFibonacci:listSeriesFibonacci){
            calculateFibonacciResponse=new CalculateFibonacciResponse();
            calculateFibonacciResponse.setIdSerie(serieFibonacci.getIdSerie());
            calculateFibonacciResponse.setSizeSerie(serieFibonacci.getSizeSerie());
            calculateFibonacciResponse.setItemsFibonacci(calculateSeriesFibonacci(serieFibonacci.getSizeSerie()));
            seriesFibonacci[contSeries]=calculateFibonacciResponse;
            contSeries++;
        }
        seriesFibonacciResponse.setSeriesFibonacci(seriesFibonacci);
        return seriesFibonacciResponse;
    }

    /**
     * CalculateFibonacci implementation method.
     * Method to calculate Series Fibonacci with length limit of items.
     * @param seriesLength limit of items.
     * @return String Fibonacci sequences with length limit of items.
     * @throws IllegalArgumentException if the length is less than one or greater 93.
     */
    public CalculateFibonacciResponse getSeriesFibonacciLimit(Long seriesLength) throws IllegalArgumentException {

        CalculateFibonacciResponse calculateFibonacciResponse;
        SerieFibonacci serieFibonacci = new SerieFibonacci();

        try {
            calculateFibonacciResponse=new CalculateFibonacciResponse();
            calculateFibonacciResponse.setSizeSerie(seriesLength);
            calculateFibonacciResponse.setItemsFibonacci(calculateSeriesFibonacciLimit(seriesLength));

            return calculateFibonacciResponse;
        }catch(RuntimeException exception){
            log.error(LogConstants.SOMETHING_WENT_WRONG_WHILE_CALCULATE_FIBONACCI,"UUID",exception.getMessage());
            throw new RuntimeException(exception);
        }
    }

    /**
     * CalculateFibonacci implementation method.
     * Method to calculate Series Fibonacci with length limit of items.
     * @param seriesLength limit of items.
     * @return String Fibonacci sequences with length limit of items.
     * @throws IllegalArgumentException if the length is less than one or greater 93.
     */
    public Long[] calculateSeriesFibonacci(Long seriesLength) throws IllegalArgumentException {
        final Long[] itemsFibonacci;
        try {
            if (seriesLength < Constants.LENGTH_MIN) {
                throw new IllegalArgumentException(
                        String.format("Length was less than %d. [%d]",
                                Constants.LENGTH_MIN, seriesLength)
                );
            } else if (seriesLength > Constants.LENGTH_MAX) {
                throw new IllegalArgumentException(
                        String.format("Length was greater than %d. [%d]",
                                Constants.LENGTH_MAX, seriesLength)
                );
            } else {
                itemsFibonacci = new Long[seriesLength.intValue()];
            }

            itemsFibonacci[0] = 0L;
            if (itemsFibonacci.length > 1) {
                itemsFibonacci[1] = 1L;
            }
            for (int idx = 2; idx < itemsFibonacci.length; idx++) {
                itemsFibonacci[idx] = itemsFibonacci[idx - 1] + itemsFibonacci[idx - 2];
            }
            return itemsFibonacci;
        }catch(RuntimeException exception){
            log.error(LogConstants.SOMETHING_WENT_WRONG_WHILE_CALCULATE_FIBONACCI,"UUID",exception.getMessage());
            throw new RuntimeException(exception);
        }
    }

    /**
     * CalculateSeriesFibonacciLimit implementation method.
     * Method to calculate Series Fibonacci with value limit less or equal than last item.
     * @param limit value limit less or equal than last item of  Fibonacci sequence.
     * @return String Fibonacci sequence less o equal than length limit value.
     * @throws IllegalArgumentException if the length is less than one or greater 93.
     */
    public Long[] calculateSeriesFibonacciLimit(Long limit){
        List<Long> itemsFibonacci;
        try{
            if (limit < Constants.LENGTH_MIN) {
                throw new IllegalArgumentException(
                        String.format("Length was less than %d. [%d]",
                                Constants.LENGTH_MIN, limit)
                );
            } else if (limit > Constants.LENGTH_MAX) {
                throw new IllegalArgumentException(
                        String.format("Length was greater than %d. [%d]",
                                Constants.LENGTH_MAX, limit)
                );
            } else {
                itemsFibonacci = new ArrayList();
                itemsFibonacci.add(0L);
                itemsFibonacci.add(1L);
                itemsFibonacci.add(1L);
            }

            Long currentItem=itemsFibonacci.get(itemsFibonacci.size()-1);
            int cont=itemsFibonacci.size();
            while(currentItem<limit){
                currentItem=itemsFibonacci.get(cont-1)+itemsFibonacci.get(cont-2);
                if(currentItem<=limit){
                    itemsFibonacci.add(currentItem);
                }
                cont++;
            }
            final Long[] arrayFibonacci;
            arrayFibonacci= new Long[itemsFibonacci.size()];
            for (int idx = 0; idx < arrayFibonacci.length; idx++) {
                arrayFibonacci[idx] = itemsFibonacci.get(idx);
            }
            return arrayFibonacci;
        }catch(RuntimeException exception){
            log.error(LogConstants.SOMETHING_WENT_WRONG_WHILE_CALCULATE_FIBONACCI_LIMIT,"UUID",exception.getMessage());
            throw new RuntimeException(exception);
        }
    }

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

}
