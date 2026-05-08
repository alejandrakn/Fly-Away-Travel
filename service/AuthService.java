package com.example.fly_away_travel_api.service;
import com.example.fly_away_travel_api.config.JwtService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.fly_away_travel_api.dto.LoginRequestDTO;
import com.example.fly_away_travel_api.model.User;
import com.example.fly_away_travel_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public String login(LoginRequestDTO dto) {

        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));


        return jwtService.generateToken(user.getEmail());
    }
}