package com.example.springdataexample.domain.repository;

import com.example.springdataexample.domain.mapper.PurchaseMapper;
import com.example.springdataexample.domain.model.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PurchaseRepository {
    private final JdbcTemplate jdbc;
    private final PurchaseMapper purchaseMapper;

    public void save(Purchase purchase) {
        String sql = """
                INSERT INTO purchases(name, price) VALUES (?, ?)
                """;
        jdbc.update(sql, purchase.getName(), purchase.getPrice());
    }

    public List<Purchase> findAll() {
        String sql = """
                SELECT * FROM purchases
                """;
        return jdbc.query(sql, purchaseMapper);
    }

    @Transactional
    public void transfer(Purchase purchase, Purchase previousPurchase) {
        // ACTION 1
        // Exception
        // ACTION 2
    }


}
