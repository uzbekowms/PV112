package com.example.cacheexample.domain.repository;

import com.example.cacheexample.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
