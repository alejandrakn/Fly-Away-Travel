package com.example.fly_away_travel_api.controller;

import com.example.fly_away_travel_api.dto.AuthResponseDTO;
import com.example.fly_away_travel_api.dto.LoginRequestDTO;
import com.example.fly_away_travel_api.service.AuthService;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(
            @Valid @RequestBody LoginRequestDTO dto
    ) {
        String token = authService.login(dto);
        return ResponseEntity.ok(new AuthResponseDTO(token));
    }
}