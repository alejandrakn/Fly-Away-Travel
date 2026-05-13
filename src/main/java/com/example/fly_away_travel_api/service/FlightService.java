package com.example.fly_away_travel_api.service;

import com.example.fly_away_travel_api.dto.FlightCreateRequestDTO;
import com.example.fly_away_travel_api.model.Flight;
import com.example.fly_away_travel_api.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flight create(FlightCreateRequestDTO dto) {
        Flight flight = new Flight();
        flight.setFlightNumber(dto.getFlightNumber());
        flight.setAirlineName(dto.getAirlineName());
        flight.setEstDepartureTime(dto.getEstDepartureTime());
        flight.setEstArrivalTime(dto.getEstArrivalTime());
        flight.setAvailableSeats(dto.getAvailableSeats());
        return flightRepository.save(flight);
    }

    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    public Flight getById(Long id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found"));
    }

    public List<Flight> searchFlights(
            String flightNumber,
            String airline,
            LocalDate startDate,
            LocalDate endDate
    ) {
        return flightRepository.searchFlights(flightNumber, airline, startDate, endDate);
    }
}
