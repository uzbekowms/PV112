package com.example.springdataexample.web.controller;

import com.example.springdataexample.domain.model.Account;
import com.example.springdataexample.domain.service.AccountService;
import com.example.springdataexample.web.dto.TransferRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest transferRequest) {
        System.out.println(transferRequest);
        accountService.transferMoney(
                transferRequest.getSenderId(),
                transferRequest.getReceiverId(),
                transferRequest.getAmount()
        );
    }

    @GetMapping
    public List<Account> findAll() {
        return accountService.findAll();
    }

}
