package ua.techtask.usersservice.domain.utill.impl;

import org.springframework.stereotype.Component;
import ua.techtask.usersservice.domain.entity.User;
import ua.techtask.usersservice.domain.utill.PatchMapper;

@Component
public class UserPatchMapper implements PatchMapper<User> {
    @Override
    public User patch(User userToPatch, User userFromDb) {
        return User.builder()
                .id(userFromDb.getId())
                .email(getOrDefault(userToPatch.getEmail(), userFromDb.getEmail()))
                .phone(getOrDefault(userToPatch.getPhone(), userFromDb.getPhone()))
                .firstName(getOrDefault(userToPatch.getFirstName(), userFromDb.getFirstName()))
                .lastName(getOrDefault(userToPatch.getLastName(), userFromDb.getLastName()))
                .address(getOrDefault(userToPatch.getAddress(), userFromDb.getAddress()))
                .birthDate(getOrDefault(userToPatch.getBirthDate(), userFromDb.getBirthDate()))
                .build();
    }

    private <T> T getOrDefault(T value, T defaultValue) {
        return value != null ? value : defaultValue;
    }
}
