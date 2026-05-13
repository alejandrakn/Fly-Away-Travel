package com.example.fly_away_travel_api.controller;

import com.example.fly_away_travel_api.dto.NewIdDTO;
import com.example.fly_away_travel_api.dto.UserRegisterRequestDTO;
import com.example.fly_away_travel_api.model.User;
import com.example.fly_away_travel_api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<NewIdDTO> register(
            @Valid @RequestBody UserRegisterRequestDTO dto
    ) {
        User user = userService.register(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new NewIdDTO(user.getId().toString()));
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }
}
