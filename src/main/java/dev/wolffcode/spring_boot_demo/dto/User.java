package dev.wolffcode.spring_boot_demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.wolffcode.spring_boot_demo.common.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record User(
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) Long id,
    @NotBlank String firstName,
    @NotBlank String lastName,
    LocalDate birthday,
    String email,
    @NotNull Gender gender) {}
