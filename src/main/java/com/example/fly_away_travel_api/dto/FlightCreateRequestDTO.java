package com.example.fly_away_travel_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;

@Getter
@Setter
public class FlightCreateRequestDTO {

    @NotBlank(message = "airlineName is required")
    private String airlineName;

    @NotBlank(message = "flightNumber is required")
    @Pattern(regexp = "^[A-Z]{2,3}[0-9]{3}$", message = "flightNumber must match ^[A-Z]{2,3}[0-9]{3}$")
    private String flightNumber;

    @NotNull(message = "estDepartureTime is required")
    private Instant estDepartureTime;

    @NotNull(message = "estArrivalTime is required")
    private Instant estArrivalTime;

    @NotNull(message = "availableSeats is required")
    @Min(value = 1, message = "availableSeats must be greater than zero")
    private Integer availableSeats;
}
