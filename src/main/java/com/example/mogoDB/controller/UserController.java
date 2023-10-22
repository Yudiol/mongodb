package com.example.mogoDB.controller;

import com.example.mogoDB.model.User;
import com.example.mogoDB.repository.UserMongoRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    private final UserMongoRepository repository;

    @GetMapping()
    @Operation(summary = "Получение всех пользователей")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.status(200).body(repository.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение пользователя по id")
    public ResponseEntity<User> findById(@PathVariable String id) {
        return ResponseEntity.status(200).body(repository.findById(id).orElseThrow());
    }

    @PostMapping()
    @Operation(summary = "Создать пользователя")
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.status(201).body(repository.insert(user));
    }
}
