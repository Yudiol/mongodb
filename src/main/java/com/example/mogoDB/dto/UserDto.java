package com.example.mogoDB.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class UserDto {

    @Schema(description = "имя", example = "Иван")
    private String name;
    @Schema(description = "фамилия", example = "Иванов")
    private String surname;
    @Schema(description = "возраст", example = "35")
    private int age;
}
