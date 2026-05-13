package com.example.fly_away_travel_api.controller;

import com.example.fly_away_travel_api.dto.BookingRequestDTO;
import com.example.fly_away_travel_api.dto.BookingResponseDTO;
import com.example.fly_away_travel_api.model.Booking;
import com.example.fly_away_travel_api.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flights")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/book")
    public ResponseEntity<Booking> bookFlight(
            @RequestBody BookingRequestDTO dto,
            Authentication authentication
    ) {
        String email = authentication.getName();
        Booking booking = bookingService.bookFlight(dto.getFlightId(), email);
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookingResponseDTO> getBookingById(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.getBooking(id));
    }
}
