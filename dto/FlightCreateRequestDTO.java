package com.example.fly_away_travel_api.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class FlightCreateRequestDTO {

    private String flightNumber;
    private String origin;
    private String destination;
    private Double price;

    private String airline;
    private LocalDate departureDate;
}