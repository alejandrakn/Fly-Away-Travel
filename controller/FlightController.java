package com.example.fly_away_travel_api.controller;

import com.example.fly_away_travel_api.model.Flight;
import com.example.fly_away_travel_api.service.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    //create
    @PostMapping("/create")
    public ResponseEntity<Flight> create(@RequestBody Flight flight) {
        return ResponseEntity.ok(flightService.create(flight));
    }

    //get all
    @GetMapping
    public ResponseEntity<List<Flight>> getAll() {
        return ResponseEntity.ok(flightService.getAll());
    }

    //get by id
    @GetMapping("/{id}")
    public ResponseEntity<Flight> getById(@PathVariable Long id) {
        return ResponseEntity.ok(flightService.getById(id));
    }

    //search protegido
    @GetMapping("/search")
    public ResponseEntity<List<Flight>> searchFlights(
            @RequestParam(required = false) String flightNumber,
            @RequestParam(required = false) String airline,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate
    ) {
        return ResponseEntity.ok(
                flightService.searchFlights(
                        flightNumber, airline, startDate, endDate
                )
        );
    }
}