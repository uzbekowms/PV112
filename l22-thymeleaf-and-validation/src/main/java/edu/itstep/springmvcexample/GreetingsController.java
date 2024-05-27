package edu.itstep.springmvcexample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingsController {

    @GetMapping("/hello")
    public String hello(Model model,
                        @RequestParam(required = false, defaultValue = "World!", name = "name") String name) {
        model.addAttribute("message", name);
        return "hello";
    }
}
