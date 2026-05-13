package com.example.fly_away_travel_api.service;

import com.example.fly_away_travel_api.dto.BookingResponseDTO;
import com.example.fly_away_travel_api.model.Booking;
import com.example.fly_away_travel_api.model.Flight;
import com.example.fly_away_travel_api.model.User;
import com.example.fly_away_travel_api.repository.BookingRepository;
import com.example.fly_away_travel_api.repository.FlightRepository;
import com.example.fly_away_travel_api.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final FlightRepository flightRepository;
    private final UserRepository userRepository;

    public BookingService(
            BookingRepository bookingRepository,
            FlightRepository flightRepository,
            UserRepository userRepository
    ) {
        this.bookingRepository = bookingRepository;
        this.flightRepository = flightRepository;
        this.userRepository = userRepository;
    }

    public Booking bookFlight(Long flightId, String email) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Flight not found"));

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));

        if (flight.getAvailableSeats() == null || flight.getAvailableSeats() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No available seats");
        }

        flight.setAvailableSeats(flight.getAvailableSeats() - 1);
        flightRepository.save(flight);

        Booking booking = new Booking();
        booking.setFlightId(flightId);
        booking.setCustomerId(user.getId());
        booking.setCustomerName(user.getName() + " " + user.getLastName());
        booking.setBookingDate(LocalDateTime.now());

        return bookingRepository.save(booking);
    }

    public BookingResponseDTO getBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Booking not found"));

        Flight flight = flightRepository.findById(booking.getFlightId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Flight not found"));

        User user = userRepository.findById(booking.getCustomerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));

        BookingResponseDTO dto = new BookingResponseDTO();
        dto.setId(booking.getId());
        dto.setBookingDate(booking.getBookingDate());
        dto.setFlightId(flight.getId());
        dto.setFlightNumber(flight.getFlightNumber());
        dto.setCustomerId(user.getId());
        dto.setCustomerFirstName(user.getName());
        dto.setCustomerLastName(user.getLastName());
        dto.setEstDepartureTime(flight.getEstDepartureTime());
        dto.setEstArrivalTime(flight.getEstArrivalTime());

        return dto;
    }
}
