package edu.itstep.springdatajpa.domain.service.impl;

import edu.itstep.springdatajpa.domain.model.Account;
import edu.itstep.springdatajpa.domain.repository.AccountRepository;
import edu.itstep.springdatajpa.domain.service.AccountService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultAccountService implements AccountService {
    private final AccountRepository accountRepository;


    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account update(int id, Account account) {
        Account accountFromDb = accountRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        accountFromDb.setAmount(account.getAmount());
        accountFromDb.setName(account.getName());

        return accountRepository.save(account);

    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> findById(int id) {
        return accountRepository.findById(id);
    }

    @Override
    public Optional<Account> findByName(String name) {
        return accountRepository.findByName(name);
    }

    @Override
    public void deleteById(int id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Page<Account> findAll(PageRequest request) {
        return accountRepository.findAll(request.withSort(Sort.by(Sort.Direction.ASC, "name")));
    }
}
