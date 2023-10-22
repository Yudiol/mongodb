package com.example.mogoDB.service.impl;

import com.example.mogoDB.dto.UserDto;
import com.example.mogoDB.mapper.UserMapper;
import com.example.mogoDB.model.User;
import com.example.mogoDB.repository.UserMongoRepository;
import com.example.mogoDB.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserMongoRepository repository;
    private final UserMapper userMapper;

    @Override
    public List<UserDto> findAll() {
        List<User> list = repository.findAll();
        return list.stream().map(userMapper::toUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto findById(String id) {
        User user = repository.findById(id).orElseThrow();
        return userMapper.toUserDto(user);
    }

    @Override
    @Transactional
    public UserDto create(UserDto userDto) {
        User user = userMapper.toUser(userDto);
        user.setCreatedAt(LocalDateTime.now().toString());
        return userMapper.toUserDto(repository.insert(user));
    }

    @Override
    @Transactional
    public UserDto update(String id, UserDto userDto) {
        User user = repository.findById(id).orElseThrow();
        user.setName(userDto.getName() == null ? user.getName() : userDto.getName());
        user.setSurname(userDto.getSurname() == null ? user.getSurname() : userDto.getSurname());
        user.setAge(userDto.getAge() == null ? user.getAge() : userDto.getAge());
        repository.save(user);
        return userMapper.toUserDto(user);
    }
}
