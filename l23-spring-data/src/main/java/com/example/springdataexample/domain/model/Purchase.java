package com.example.springdataexample.domain.model;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Purchase {
    private int id;
    private String name;
    private BigDecimal price;
}
