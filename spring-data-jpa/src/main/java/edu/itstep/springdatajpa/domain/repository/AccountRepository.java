package edu.itstep.springdatajpa.domain.repository;

import edu.itstep.springdatajpa.domain.model.Account;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    //@Query(countQuery = "select a from Account a")
    Optional<Account> findByName(String name);

//    @Query("""
//            select a from Account a where a.name = :name
//            """)
//    List<Account> findAccountByName(String name);
//
//    // HQL JPQL
//
//    @Query(value = """
//            select * from accounts a order by a.amount limit 3
//            """, nativeQuery = true)
//    List<Account> findMostRichAccounts();
//
//    @Query("""
//            delete from Account a where a.name = :name
//            """)
//    @Modifying
//    void deleteByName(@Param("name") String name);
//
//    @Async
//    Future<List<Account>> findByNameLikeIgnoreCase(String name, Pageable pageable);
//
//    Future<List<Account>> findByNameIsContaining(String name, Sort sort);


    /*
{
    results: []
    total: 1000,
    page: 2,
    count: 60
}


    * */
}
