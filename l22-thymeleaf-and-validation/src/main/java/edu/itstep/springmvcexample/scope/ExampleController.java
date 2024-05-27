package edu.itstep.springmvcexample.scope;

import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("anotherController")
@RequiredArgsConstructor
public class ExampleController {

    private final Config config;

    @Autowired
    private RandHello randHello;

    @Autowired
    private RandHello randHello2;

    @Resource(name = "randomUser")
    private RandomUser randomUser;

    @GetMapping("/ping-hello")
    public String pingHello() {
        return config.hello();
    }

    @GetMapping("/ping-rand-hello")
    public String pingRandHello() {
        return randHello.getMessage() + randHello2.getMessage();
    }


    @GetMapping("/ping-rand-user")
    public RandomUser pingRandUser() {
        return randomUser;
    }
}
