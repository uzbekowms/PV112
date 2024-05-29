package com.example.springdataexample.domain.mapper;

import com.example.springdataexample.domain.model.Purchase;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PurchaseMapper implements RowMapper<Purchase> {
    @Override
    public Purchase mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Purchase.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .price(rs.getBigDecimal("price"))
                .build();
    }
}
