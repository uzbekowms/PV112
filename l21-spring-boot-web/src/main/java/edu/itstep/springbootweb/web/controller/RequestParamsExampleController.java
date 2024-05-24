package edu.itstep.springbootweb.web.controller;

import edu.itstep.springbootweb.domain.model.Country;
import edu.itstep.springbootweb.domain.model.Payment;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/request-param")
public class RequestParamsExampleController {

    @GetMapping
    public ResponseEntity<Country> returnObjectExample() {
        return ResponseEntity
                .status(HttpStatus.I_AM_A_TEAPOT)
                .body(Country.builder()
                        .name("Ukraine")
                        .population(10)
                        .build());
    }

    @GetMapping("/params")
    public ResponseEntity<Country> returnObjectExample(
            @RequestParam String name,
            @RequestParam int population
    ) {
        return ResponseEntity
                .status(HttpStatus.I_AM_A_TEAPOT)
                .body(Country.builder()
                        .name(name)
                        .population(population)
                        .build());
    }

    @GetMapping("/exception")
    public ResponseEntity<?> exceptionExample(
            @RequestParam String name,
            @RequestParam int population,
            @RequestParam int number
    ) {
        if (number == 1) {
            return ResponseEntity.badRequest().body("Some error");
        }

        return ResponseEntity
                .status(HttpStatus.I_AM_A_TEAPOT)
                .body(Country.builder()
                        .name(name)
                        .population(population)
                        .build());
    }

    @PostMapping("/order")
    public ResponseEntity<Payment> createPayment(
            @RequestHeader String requestId,
            @RequestBody Payment payment
    ) {
        System.out.println(requestId);
        payment.setId(UUID.randomUUID().toString());
        return ResponseEntity.ok(payment);
    }

    // Resource
    // Collection
    // URL /user

    // /systemOrders /system_orders
    // /system-orders


}
