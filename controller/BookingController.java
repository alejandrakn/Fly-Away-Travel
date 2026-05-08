package com.example.fly_away_travel_api.controller;

import com.example.fly_away_travel_api.model.Booking;
import com.example.fly_away_travel_api.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flights/book")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    //crear reserva
    @PostMapping
    public ResponseEntity<Booking> bookFlight(
            @RequestParam Long flightId,
            @RequestParam String email
    ) {
        return ResponseEntity.ok(
                bookingService.bookFlight(flightId, email)
        );
    }

    //get booking by id
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        return ResponseEntity.ok(
                bookingService.getBooking(id)
        );
    }
}