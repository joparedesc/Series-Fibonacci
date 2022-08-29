package com.series.fibonacci.controller;

import com.series.fibonacci.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * FibonacciController controller class.
 * @author jesu_
 */
@RestController
@RequestMapping("${controller.base-path}")
public class FibonacciController {

    /**
     * Instance Series Service
     */
    @Autowired
    SeriesService seriesService;

    /**
     * CalculateFibonacci method.
     * Method to calculate Series Fibonacci with length limit of items.
     * @param seriesLength limit of items.
     * @return String Fibonacci sequences with length limit of items.
     */
    @RequestMapping(path = "${controller.api-calculate-fibonacci}")
    public String calculateFibonacci(@Valid @PathVariable(required = true) int seriesLength){
        return new String(seriesService.calculateSeriesFibonacci(seriesLength));
    }

    /**
     * CalculateSeriesFibonacciLimit method.
     * Method to calculate Series Fibonacci with value limit less or equal than last item.
     * @param limit value limit less or equal than last item of  Fibonacci sequence.
     * @return String Fibonacci sequence less o equal than length limit value.
     */
    @RequestMapping(path = "${controller.api-calculate-fibonacci-limit}")
    public String calculateSeriesFibonacciLimit(@Valid @PathVariable(required = true) int limit){
        return new String(seriesService.calculateSeriesFibonacciLimit(limit));
    }
}
