package com.example.cacheexample.web.controller;

import com.example.cacheexample.domain.entity.User;
import com.example.cacheexample.domain.service.UserService;
import com.example.cacheexample.validation.ValidationGroup;
import com.example.cacheexample.web.dto.UserDto;
import com.example.cacheexample.web.mapper.UserListMapper;
import com.example.cacheexample.web.mapper.UserMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Validated
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final UserListMapper userListMapper;

    @PostMapping
    @Validated(ValidationGroup.OnCreate.class)
    public ResponseEntity<UserDto> save(@Valid @RequestBody UserDto userRequest) {
        User user = userMapper.toEntity(userRequest);
        return ResponseEntity.ok(userMapper.toDto(userService.save(user)));
    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<UserDto> findById(@PathVariable("id") Long id) {
        System.out.print(id);
        UserDto userDto = userMapper.toDto(userService.findById(id));
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/{id:\\d+}")
    public ResponseEntity<UserDto> update(@PathVariable("id") Long id,
                                          @Valid @RequestBody UserDto userRequest) {
        User user = userMapper.toEntity(userRequest);
        UserDto userResponse = userMapper.toDto(userService.update(id, user));
        return ResponseEntity.ok(userResponse);
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    @GetMapping
    public ResponseEntity<Page<UserDto>> findAllPageable(@PageableDefault Pageable pageable) {
        Page<UserDto> dtoUsersPage = userListMapper.toDtoPage(userService.findAll(pageable));
        return ResponseEntity.ok(dtoUsersPage);
    }
//
//    public ResponseEntity<List<UserDto>> findAll() {
//        List<UserDto> users = userListMapper.toDtoList(userService.findAll());
//        return ResponseEntity.ok(users);
//    }
}
