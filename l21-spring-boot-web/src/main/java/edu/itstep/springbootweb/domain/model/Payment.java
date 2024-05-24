package edu.itstep.springbootweb.domain.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {

    private String id;
    private double amount;
}
