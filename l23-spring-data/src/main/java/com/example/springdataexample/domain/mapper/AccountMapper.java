package com.example.springdataexample.domain.mapper;

import com.example.springdataexample.domain.model.Account;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AccountMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Account.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .amount(rs.getBigDecimal("amount"))
                .build();
    }
}
