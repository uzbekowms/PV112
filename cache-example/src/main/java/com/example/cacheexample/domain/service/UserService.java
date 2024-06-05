package com.example.cacheexample.domain.service;

import com.example.cacheexample.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;

import java.util.List;

public interface UserService {

    User save(User user);

    User findById(Long id);

    User update(Long id, User user);

    void delete(Long id);

    Page<User> findAll(Pageable pageable);

    List<User> findAll();
}
