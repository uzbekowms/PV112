package com.example.cacheexample.web.mapper;

import com.example.cacheexample.domain.entity.User;
import com.example.cacheexample.web.dto.UserDto;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedModel;

import java.util.List;

@Mapper(uses = UserMapper.class, componentModel = "spring")
public abstract class UserListMapper {


    private UserMapper userMapper;

    @Autowired
    public final void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Page<UserDto> toDtoPage(Page<User> userPage) {
        return userPage.map(userMapper::toDto);
    }

    public abstract List<UserDto> toDtoList(List<User> userList);
}
