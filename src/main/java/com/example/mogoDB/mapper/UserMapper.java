package com.example.mogoDB.mapper;

import com.example.mogoDB.dto.UserDto;
import com.example.mogoDB.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);

    User toUser(UserDto userDto);
}
