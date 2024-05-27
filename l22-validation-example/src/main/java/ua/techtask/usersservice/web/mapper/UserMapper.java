package ua.techtask.usersservice.web.mapper;

import org.mapstruct.Mapper;
import ua.techtask.usersservice.domain.entity.User;
import ua.techtask.usersservice.web.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User fromDto(UserDTO userDTO);

    UserDTO toDto(User user);

}
