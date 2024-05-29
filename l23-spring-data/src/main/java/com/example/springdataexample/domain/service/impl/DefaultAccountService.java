package com.example.springdataexample.domain.service.impl;

import com.example.springdataexample.domain.model.Account;
import com.example.springdataexample.domain.repository.AccountRepository;
import com.example.springdataexample.domain.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DefaultAccountService implements AccountService {

    private final AccountRepository accountRepository;


    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void transferMoney(int senderId, int receiverId, BigDecimal amount) {
        Account sender = accountRepository.findById(senderId);
        Account receiver = accountRepository.findById(receiverId);

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.updateAmount(senderId, senderNewAmount);
        accountRepository.updateAmount(receiverId, receiverNewAmount);
        throw new RuntimeException("Something went wrong");
    }

    // data transfer object

    // password

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
