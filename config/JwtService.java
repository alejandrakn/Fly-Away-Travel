package com.example.fly_away_travel_api.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String SECRET;

    private Algorithm getAlgorithm() {
        return Algorithm.HMAC256(SECRET);
    }

    //generar token
    public String generateToken(String email) {
        return JWT.create()
                .withSubject(email)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .sign(getAlgorithm());
    }

    //validar token
    public String validateTokenAndGetEmail(String token) {
        return JWT.require(getAlgorithm())
                .build()
                .verify(token)
                .getSubject();
    }
}