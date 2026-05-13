package com.example.fly_away_travel_api.model;

import jakarta.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String flightNumber;

    private String airlineName;

    private String origin;
    private String destination;
    private Double price;
    private String airline;
    private LocalDate departureDate;

    private Instant estDepartureTime;
    private Instant estArrivalTime;
    private Integer availableSeats;

    public Flight() {}

    // Getters y Setters

    public Long getId() { return id; }

    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public String getAirlineName() { return airlineName; }
    public void setAirlineName(String airlineName) { this.airlineName = airlineName; }

    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getAirline() { return airline; }
    public void setAirline(String airline) { this.airline = airline; }

    public LocalDate getDepartureDate() { return departureDate; }
    public void setDepartureDate(LocalDate departureDate) { this.departureDate = departureDate; }

    public Instant getEstDepartureTime() { return estDepartureTime; }
    public void setEstDepartureTime(Instant estDepartureTime) { this.estDepartureTime = estDepartureTime; }

    public Instant getEstArrivalTime() { return estArrivalTime; }
    public void setEstArrivalTime(Instant estArrivalTime) { this.estArrivalTime = estArrivalTime; }

    public Integer getAvailableSeats() { return availableSeats; }
    public void setAvailableSeats(Integer availableSeats) { this.availableSeats = availableSeats; }
}
