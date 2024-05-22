package edu.itstep.wiring.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Person {

    private String name;
    private Parrot parrot;
}
