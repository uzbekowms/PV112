package edu.itstep.springdatajpa.web.controller;

import edu.itstep.springdatajpa.domain.model.Account;
import edu.itstep.springdatajpa.domain.service.AccountService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public Account save(@RequestBody Account account) {
        return accountService.save(account);
    }

    @GetMapping
    public Page<Account> findAll(@RequestParam int page, @RequestParam int size) {
        return accountService.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/{id:\\d+}")
    public Account findById(@PathVariable int id) {
        return accountService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find user by id: " + id));
    }

    @GetMapping("/{name:[a-zA-Z]+}")
    public Account findByName(@PathVariable String name) {
        return accountService.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find user by name: " + name));
    }

    @DeleteMapping("/{id:\\d+}")
    public void deleteById(@PathVariable int id) {
        accountService.deleteById(id);
    }
}
