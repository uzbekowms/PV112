package edu.itstep.springbootweb.domain.model;

import jakarta.websocket.server.ServerEndpoint;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Country {

    private String name;
    private int population;
}
