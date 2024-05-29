package com.example.springdataexample.domain.service;

import com.example.springdataexample.domain.model.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {

    void transferMoney(int senderId, int receiverId, BigDecimal amount);

    List<Account> findAll();
}
