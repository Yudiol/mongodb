package com.example.mogoDB.controller;

import com.example.mogoDB.dto.UserDto;
import com.example.mogoDB.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping()
    @Operation(summary = "Получение всех пользователей")
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.status(200).body(userService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение пользователя по id")
    public ResponseEntity<UserDto> findById(@PathVariable String id) {
        return ResponseEntity.status(200).body(userService.findById(id));
    }

    @PostMapping()
    @Operation(summary = "Создать пользователя")
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
        return ResponseEntity.status(201).body(userService.create(userDto));
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Обновить пользователя")
    public ResponseEntity<UserDto> update(@PathVariable String id, @RequestBody UserDto userDto) {
        return ResponseEntity.status(200).body(userService.update(id, userDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.status(200).body("");
    }
}
