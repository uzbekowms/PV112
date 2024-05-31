package edu.itstep.springdatajpa.domain.service;

import edu.itstep.springdatajpa.domain.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    Account save(Account account);

    Account update(int id, Account account);

    List<Account> findAll();


    Optional<Account> findById(int id);

    Optional<Account> findByName(String name);

    void deleteById(int id);


    Page<Account> findAll(PageRequest request);
}
