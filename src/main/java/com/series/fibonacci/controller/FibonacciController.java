package com.series.fibonacci.controller;

import com.series.fibonacci.constants.LogConstants;
import com.series.fibonacci.model.response.SeriesFibonacciResponse;
import com.series.fibonacci.model.response.CalculateFibonacciResponse;
import com.series.fibonacci.service.CalculateSeriesService;
import com.series.fibonacci.service.FibonacciSeriesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * FibonacciController controller class.
 * @author jesu_
 */
@Slf4j
@RestController
@RequestMapping("${controller.base-path}")
public class FibonacciController {

    /** Instance Calculate Series Service.*/
    @Autowired
    CalculateSeriesService calculateSeriesService;

    /** Instance Series Service. */
    @Autowired
    FibonacciSeriesService fibonacciSeriesService;

    /**
     * GetCalculateFibonacci method.
     * Method to calculate Series Fibonacci with length limit of items.
     *
     * @param seriesLength limit of items.
     * @return String Fibonacci sequences with length limit of items.
     */
    @PostMapping(path = "${controller.api-calculate-fibonacci}")
    public ResponseEntity<CalculateFibonacciResponse> getCalculateFibonacci(
            @Valid @PathVariable(required = true) Long seriesLength) {
        log.debug(LogConstants.START_APPLICATION_CALCULATE_FIBONACCI);
        CalculateFibonacciResponse calculateFibonacciResponse = calculateSeriesService.getSeriesFibonacci(seriesLength);
        log.debug(LogConstants.FINISH_APPLICATION_CALCULATE_FIBONACCI);
        return new ResponseEntity<>(calculateFibonacciResponse, HttpStatus.CREATED);
    }

    /**
     * GetCalculateSeriesFibonacciLimit method.
     * Method to calculate Series Fibonacci with value limit less or equal than last item.
     *
     * @param limit value limit less or equal than last item of  Fibonacci sequence.
     * @return String Fibonacci sequence less o equal than length limit value.
     */
    @PostMapping(path = "${controller.api-calculate-fibonacci-limit}")
    public ResponseEntity<CalculateFibonacciResponse> getCalculateSeriesFibonacciLimit(@Valid @PathVariable(required = true) Long limit) {
        log.debug(LogConstants.START_APPLICATION_CALCULATE_FIBONACCI_LIMIT);
        CalculateFibonacciResponse calculateFibonacciResponse = calculateSeriesService.getSeriesFibonacciLimit(limit);
        log.debug(LogConstants.FINISH_APPLICATION_CALCULATE_FIBONACCI_LIMIT);
        return new ResponseEntity<>(calculateFibonacciResponse, HttpStatus.CREATED);
    }

    /**
     * GetAllSeriesFibonacci method.
     * Method to calculate Series Fibonacci with value limit less or equal than last item.
     *
     * @return String Fibonacci sequence less o equal than length limit value.
     */
    @GetMapping(path = "${controller.api-get-all-series-fibonacci}")
    public ResponseEntity<SeriesFibonacciResponse> getAllSeriesFibonacci() {
        log.debug(LogConstants.START_APPLICATION_CALCULATE_FIBONACCI_LIMIT);
        SeriesFibonacciResponse seriesFibonacciResponse = calculateSeriesService.getAllSeriesFibonacci();
        log.debug(LogConstants.FINISH_APPLICATION_CALCULATE_FIBONACCI_LIMIT);
        return new ResponseEntity<>(seriesFibonacciResponse, HttpStatus.CREATED);
    }

    /**
     * DeleteSerieFibonacci method.
     * Method to calculate Series Fibonacci with value limit less or equal than last item.
     *
     * @param idSerie value limit less or equal than last item of  Fibonacci sequence.
     * @return String Fibonacci sequence less o equal than length limit value.
     */
    @DeleteMapping (path = "${controller.api-delete-serie-fibonacci}")
    public ResponseEntity<CalculateFibonacciResponse> deleteSerieFibonacci(@Valid @PathVariable(required = true) Long idSerie) {
        log.debug(LogConstants.START_APPLICATION_CALCULATE_FIBONACCI_LIMIT);
        boolean response = fibonacciSeriesService.deleteSerieFibonacci(idSerie);
        if(response){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
