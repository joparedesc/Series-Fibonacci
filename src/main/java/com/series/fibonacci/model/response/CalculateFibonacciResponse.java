package com.series.fibonacci.model.response;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CalculateFibonacciResponse {

    @NotNull
    Long idSerie;

    @NotNull
    Long sizeSerie;

    @NotEmpty
    @NotNull
    Long[] itemsFibonacci;
}
