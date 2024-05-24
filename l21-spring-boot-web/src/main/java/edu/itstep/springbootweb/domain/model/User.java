package edu.itstep.springbootweb.domain.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {

    private String id;
    private String name;
}
