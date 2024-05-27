package edu.itstep.springmvcexample;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler({Throwable.class})
    public String handleInternalException(Throwable throwable, Model model) {
        model.addAttribute("message", throwable.getMessage());
        return "error";
    }

    @ExceptionHandler(NoSuchElementException.class)
    public String handleNoSuchElementException(NoSuchElementException e) {
        return e.getMessage();
    }
}
