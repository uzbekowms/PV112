package com.example.cacheexample.domain.service.impl;

import com.example.cacheexample.domain.entity.User;
import com.example.cacheexample.domain.repository.UserRepository;
import com.example.cacheexample.domain.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CacheableUserService implements UserService {
    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    @SneakyThrows
    @Cacheable(key = "#id", value = "users")
    public User findById(Long id) {
        Thread.sleep(10000);
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find user with id: " + id));
    }

    @Override
    @Caching(
            put = {
                    @CachePut(key = "#id", value = "users")
            },
            evict = {
                    @CacheEvict(value = "CacheableUserService::findALl", allEntries = true)
            }
    )
    public User update(Long id, User user) {
        User userToUpdate = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find user with id: " + id));

        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setUsername(user.getUsername());

        return userRepository.save(userToUpdate);
    }

    @Override
    @CacheEvict("users")
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Cacheable(value = "CacheableUserService::findALl", key = "{#pageable.pageSize, #pageable.pageNumber}")
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Cacheable(key = "#user.id", value = "admins", condition = "#user.username == 'admin'")
    public User saveAdmin(User user) {
        return null;
    }
}
