package ua.techtask.usersservice.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.techtask.usersservice.domain.entity.User;
import ua.techtask.usersservice.domain.service.UserService;
import ua.techtask.usersservice.validation.group.OnCreate;
import ua.techtask.usersservice.validation.group.OnPatch;
import ua.techtask.usersservice.validation.group.OnUpdate;
import ua.techtask.usersservice.web.dto.UserDTO;
import ua.techtask.usersservice.web.mapper.UserMapper;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    @Validated(OnCreate.class)
    public ResponseEntity<UserDTO> register(
            @RequestBody @Valid UserDTO userDTO
    ) {
        User user = userService.save(userMapper.fromDto(userDTO));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userMapper.toDto(user));
    }

    @PatchMapping("/{id}")
    @Validated(OnPatch.class)
    public ResponseEntity<UserDTO> patch(
            @PathVariable String id,
            @RequestBody @Valid UserDTO userDTO
    ) {
        User user = userMapper.fromDto(userDTO);

        return ResponseEntity.ok(
                userMapper.toDto(userService.patch(id, user))
        );
    }

    @PutMapping("/{id}")
    @Validated(OnUpdate.class)
    public ResponseEntity<UserDTO> update(
            @PathVariable String id,
            @RequestBody @Valid UserDTO userDTO
    ) {
        User user = userMapper.fromDto(userDTO);

        return ResponseEntity.ok(
                userMapper.toDto(userService.update(id, user))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.ok()
                .build();
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> findAll(
            @RequestParam(required = false, name = "from")
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate from,
            @RequestParam(required = false, name = "to")
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate to
    ) {
        if (from == null || to == null)
            throw new IllegalArgumentException("You need to specify both parameters 'from' and 'to'");

        if (from.isAfter(to))
            throw new IllegalArgumentException("Parameter “From” must be less than parameter “To”");

        List<User> users = userService.findByBirtDateRange(from, to);

        return ResponseEntity.ok(
                users.stream()
                        .map(userMapper::toDto)
                        .toList()
        );
    }

}
