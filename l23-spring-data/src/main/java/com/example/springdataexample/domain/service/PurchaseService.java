package com.example.springdataexample.domain.service;

import com.example.springdataexample.domain.model.Purchase;

import java.util.List;

public interface PurchaseService {

    void save(Purchase purchase);

    List<Purchase> findAll();

    void transfer(Purchase purchase, Purchase previousPurchase);
}
