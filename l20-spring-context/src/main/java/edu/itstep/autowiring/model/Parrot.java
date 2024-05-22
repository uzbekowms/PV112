package edu.itstep.autowiring.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Component
public class Parrot {

    private String name = "Igor";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
