package ua.techtask.usersservice.domain.repository;

import lombok.NonNull;
import org.springframework.stereotype.Repository;
import ua.techtask.usersservice.domain.entity.User;
import ua.techtask.usersservice.web.exception.EntityNotFoundException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    List<User> findAll();

    Optional<User> findById(@NonNull String id);

    User add(@NonNull User user);

    User update(@NonNull String id,
                @NonNull User user);

    boolean delete(@NonNull String id);

    List<User> findByBirthDate(@NonNull LocalDate from, @NonNull LocalDate to);
}
