package com.example.mogoDB.service;

import com.example.mogoDB.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findById(String id);

    UserDto create(UserDto userDto);
}
