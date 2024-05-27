package ua.techtask.usersservice.domain.repository.impl;

import lombok.NonNull;
import org.springframework.stereotype.Repository;
import ua.techtask.usersservice.domain.entity.User;
import ua.techtask.usersservice.domain.repository.UserRepository;
import ua.techtask.usersservice.web.exception.EntityNotFoundException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class InMemoryUserRepository implements UserRepository {

    private final List<User> users = new ArrayList<>();

    public List<User> findAll() {
        return users;
    }

    public Optional<User> findById(@NonNull String id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public User add(@NonNull User user) {
        user.setId(UUID.randomUUID().toString());
        users.add(user);
        return user;
    }


    public User update(@NonNull String id,
                       @NonNull User user) {
        int userId = findId(id);

        users.set(userId, user);
        return user;
    }

    public boolean delete(@NonNull String id) {
        int userId = findId(id);

        users.remove(userId);
        return true;
    }

    public List<User> findByBirthDate(@NonNull LocalDate from, @NonNull LocalDate to) {
        return users.stream()
                .filter(u -> u.getBirthDate().isAfter(from) && u.getBirthDate().isBefore(to))
                .toList();
    }

    private int findId(String id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) return i;
        }
        throw new EntityNotFoundException("Cannot find user with id: " + id);
    }
}
