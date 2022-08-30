package com.series.fibonacci.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeriesFibonacciResponse {
    @NotEmpty
    @NotNull
    CalculateFibonacciResponse [] seriesFibonacci;
}
