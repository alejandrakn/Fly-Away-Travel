package com.example.fly_away_travel_api.controller;

import com.example.fly_away_travel_api.repository.BookingRepository;
import com.example.fly_away_travel_api.repository.FlightRepository;
import com.example.fly_away_travel_api.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cleanup")
public class CleanupController {

    private final UserRepository userRepository;
    private final FlightRepository flightRepository;
    private final BookingRepository bookingRepository;

    public CleanupController(
            UserRepository userRepository,
            FlightRepository flightRepository,
            BookingRepository bookingRepository
    ) {
        this.userRepository = userRepository;
        this.flightRepository = flightRepository;
        this.bookingRepository = bookingRepository;
    }

    @DeleteMapping
    public ResponseEntity<String> cleanup() {

        //limpiar todoo
        bookingRepository.deleteAll();
        flightRepository.deleteAll();
        userRepository.deleteAll();

        return ResponseEntity.ok(
                "Database cleaned successfully"
        );
    }
}