package com.example.fly_away_travel_api.service;

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

    //create
    public Flight create(Flight flight) {
        return flightRepository.save(flight);
    }

    //getall
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    //get by id
    public Flight getById(Long id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found"));
    }

    //serach
    public List<Flight> searchFlights(
            String flightNumber,
            String airline,
            LocalDate startDate,
            LocalDate endDate
    ) {
        return flightRepository.searchFlights(
                flightNumber, airline, startDate, endDate
        );
    }
}