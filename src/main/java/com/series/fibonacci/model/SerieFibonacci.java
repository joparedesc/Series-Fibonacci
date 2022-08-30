package com.series.fibonacci.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class SerieFibonacci {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idSerie;

    @Column(nullable = false)
    Long sizeSerie;

}
