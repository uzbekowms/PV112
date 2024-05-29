package com.example.springdataexample.domain.repository;

import com.example.springdataexample.domain.mapper.AccountMapper;
import com.example.springdataexample.domain.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class AccountRepository {

    private final JdbcTemplate jdbc;
    private final AccountMapper accountMapper;

    public List<Account> findAll() {
        String sql = "select * from accounts";
        return jdbc.query(sql, accountMapper);
    }

    public Account findById(int id) {
        String sql = "select * from accounts where id = ? LIMIT 1";
        return jdbc.queryForObject(sql, accountMapper, id);
    }


    public void updateAmount(int id, BigDecimal amount) {
        String sql = "update accounts set amount = ? where id = ?";
        jdbc.update(sql, amount, id);
    }
}
