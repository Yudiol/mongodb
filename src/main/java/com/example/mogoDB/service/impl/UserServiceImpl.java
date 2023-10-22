package com.example.mogoDB.service.impl;

import com.example.mogoDB.dto.UserDto;
import com.example.mogoDB.repository.UserMongoRepository;
import com.example.mogoDB.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMongoRepository repository;

    @Override
    public List<UserDto> findAll() {
        return null;
    }

    @Override
    public UserDto findById(String id) {
        return null;
    }

    @Override
    public UserDto create(UserDto userDto) {
        return null;
    }
}
