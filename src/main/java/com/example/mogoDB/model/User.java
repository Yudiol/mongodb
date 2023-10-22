package com.example.mogoDB.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    private String id;
    @Schema(description = "имя", example = "Иван")
    private String name;
    @Schema(description = "фамилия", example = "Иванов")
    private String surname;
    @Schema(description = "возраст", example = "35")
    private int age;
    @Schema(description = "зарегистрирован", example = "Sun Oct 22 20:57:37 MSK 2023")
    private String createdAt;
}
