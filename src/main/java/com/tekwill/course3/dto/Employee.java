package com.tekwill.course3.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Employee {
    private UUID uuid;
    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;
    @NotNull
    private int age;
}
