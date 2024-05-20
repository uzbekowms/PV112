package org.example.component.model;

import jakarta.annotation.PreDestroy;
import lombok.*;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class Parrot {
    private String name;

    {
        System.out.println("Parrot created!");
    }

    @PostConstruct
    public void init() {
        this.name = "Igor";
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy Parrot");
    }
}
