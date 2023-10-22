package com.example.mogoDB.controller;

import com.example.mogoDB.dto.UserDto;
import com.example.mogoDB.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@ResponseStatus(HttpStatus.OK)
public class UserController {

    private final UserService userService;

    @GetMapping()
    @Operation(summary = "Получение всех пользователей")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение пользователя по id")
    public UserDto findById(@PathVariable String id) {
        return userService.findById(id);
    }

    @GetMapping("/name/{name}")
    @Operation(summary = "Получение пользователей по name")
    public List<UserDto> findByName(@PathVariable String name) {
        return userService.findByName(name);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Создать пользователя")
    public UserDto create(@RequestBody UserDto userDto) {
        return userService.create(userDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Обновить пользователя")
    public UserDto update(@PathVariable String id, @RequestBody UserDto userDto) {
        return userService.update(id, userDto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        userService.delete(id);
        return id;
    }
}
