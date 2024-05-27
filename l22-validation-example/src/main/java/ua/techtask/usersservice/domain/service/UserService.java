package ua.techtask.usersservice.domain.service;

import org.springframework.stereotype.Service;
import ua.techtask.usersservice.domain.entity.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(String id);

    User save(User user);

    User update(String id, User user);

    User patch(String id, User user);

    boolean delete(String id);

    List<User> findByBirtDateRange(LocalDate from, LocalDate to);

}
