package com.example.springdataexample.web.controller;

import com.example.springdataexample.domain.model.Purchase;
import com.example.springdataexample.domain.repository.PurchaseRepository;
import com.example.springdataexample.domain.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/purchases")
public class PurchaseController {
    private final PurchaseService purchaseService;

    @GetMapping
    public List<Purchase> getAll() {
        return purchaseService.findAll();
    }

    @PostMapping
    public Purchase save(@RequestBody Purchase purchase) {
        purchaseService.save(purchase);
        return purchase;
    }

    // Repository -> Model -> Service ->  Mapper -> DTO ->  Controller
}
