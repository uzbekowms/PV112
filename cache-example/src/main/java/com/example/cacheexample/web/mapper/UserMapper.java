package com.example.cacheexample.web.mapper;

import com.example.cacheexample.domain.entity.User;
import com.example.cacheexample.web.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto userDto);
}
