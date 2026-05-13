package com.example.fly_away_travel_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterRequestDTO {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email(message = "Email inválido")
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 8, message = "Mínimo 8 caracteres")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d).+$",
            message = "Debe contener letras y números")
    private String password;
}
