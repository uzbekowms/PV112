package com.example.springdataexample.domain.service.impl;

import com.example.springdataexample.domain.model.Purchase;
import com.example.springdataexample.domain.repository.PurchaseRepository;
import com.example.springdataexample.domain.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultPurchaseService implements PurchaseService {

    private final PurchaseRepository purchaseRepository;

    public void save(Purchase purchase) {
        purchaseRepository.save(purchase);
    }

    public List<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    @Override
    public void transfer(Purchase purchase, Purchase previousPurchase) {
        purchaseRepository.transfer(purchase, previousPurchase);
    }
}
