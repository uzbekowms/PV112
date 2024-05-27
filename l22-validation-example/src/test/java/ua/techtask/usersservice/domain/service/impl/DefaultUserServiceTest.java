package ua.techtask.usersservice.domain.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.techtask.usersservice.domain.entity.User;
import ua.techtask.usersservice.domain.repository.UserRepository;
import ua.techtask.usersservice.domain.utill.PatchMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DefaultUserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PatchMapper<User> patchMapper;
    private DefaultUserService userService;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        patchMapper = mock(PatchMapper.class);
        userService = new DefaultUserService(userRepository, patchMapper);
    }


    @Test
    void findAll_filledDb_shouldReturnUsersList() {
        List<User> users = List.of(
                new User("1", "test@email", "first Name", "last Name", LocalDate.of(2004, 2, 2), "address", "phone"),
                new User("2", "test@email", "first Name", "last Name", LocalDate.of(2005, 3, 2), "address", "phone")
        );

        when(userRepository.findAll())
                .thenReturn(users);


        assertIterableEquals(users, userService.findAll(), "List of users are incorrect");
    }

    @Test
    void findAll_emptyDb_shouldReturnEmptyList() {
        List<User> users = List.of();

        when(userRepository.findAll())
                .thenReturn(users);

        assertIterableEquals(users, userService.findAll(), "List of users are not empty");
    }

    @Test
    void findById_existingId_shouldReturnUser() {
        String userId = "1";
        User user = new User(userId, "test@email", "first Name", "last Name", LocalDate.of(2004, 2, 2), "address", "phone");

        when(userRepository.findById(userId))
                .thenReturn(Optional.of(user));

        Optional<User> result = userService.findById(userId);
        assertTrue(result.isPresent());
        assertEquals(user, result.get());
    }

    @Test
    void findById_nonExistingId_shouldReturnEmptyOptional() {
        String userId = "3";

        when(userRepository.findById(userId))
                .thenReturn(Optional.empty());

        Optional<User> result = userService.findById(userId);
        assertTrue(result.isEmpty());
    }

    @Test
    void save_user_shouldReturnUserWithId() {
        User user = new User(null, "test@email", "first Name", "last Name", LocalDate.of(2004, 2, 2), "address", "phone");
        User resultedUser = User.builder()
                .id("SOME ID")
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birthDate(user.getBirthDate())
                .address(user.getAddress())
                .phone(user.getPhone())
                .build();

        when(userRepository.add(user))
                .thenReturn(resultedUser);

        User result = userService.save(user);

        assertEquals(resultedUser,
                result);

        assertNotNull(result.getId());
    }

    @Test
    void update() {



    }

    @Test
    void patch() {
    }

    @Test
    void delete() {
    }

    @Test
    void findByBirtDateRange() {
    }
}