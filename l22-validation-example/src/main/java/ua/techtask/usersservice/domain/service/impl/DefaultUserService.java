package ua.techtask.usersservice.domain.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.techtask.usersservice.domain.entity.User;
import ua.techtask.usersservice.domain.repository.UserRepository;
import ua.techtask.usersservice.domain.service.UserService;
import ua.techtask.usersservice.domain.utill.PatchMapper;
import ua.techtask.usersservice.web.exception.EntityNotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;
    private final PatchMapper<User> patchMapper;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.add(user);
    }

    @Override
    public User update(String id, User user) {
        return userRepository.update(id, user);
    }

    @Override
    public User patch(String id, User user) {
        User userFromDb = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find user with id: " + id));

        user = patchMapper.patch(user, userFromDb);

        return userRepository.update(id, user);
    }

    @Override
    public boolean delete(String id) {
        return userRepository.delete(id);
    }

    @Override
    public List<User> findByBirtDateRange(LocalDate from, LocalDate to) {
        return userRepository.findByBirthDate(from, to);
    }
}
