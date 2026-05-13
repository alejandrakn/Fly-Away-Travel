package com.example.fly_away_travel_api.dto;

import java.time.Instant;
import java.time.LocalDateTime;

public class BookingResponseDTO {

    private Long id;
    private LocalDateTime bookingDate;
    private Long flightId;
    private String flightNumber;
    private Long customerId;
    private String customerFirstName;
    private String customerLastName;
    private Instant estDepartureTime;
    private Instant estArrivalTime;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDateTime bookingDate) { this.bookingDate = bookingDate; }

    public Long getFlightId() { return flightId; }
    public void setFlightId(Long flightId) { this.flightId = flightId; }

    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public String getCustomerFirstName() { return customerFirstName; }
    public void setCustomerFirstName(String customerFirstName) { this.customerFirstName = customerFirstName; }

    public String getCustomerLastName() { return customerLastName; }
    public void setCustomerLastName(String customerLastName) { this.customerLastName = customerLastName; }

    public Instant getEstDepartureTime() { return estDepartureTime; }
    public void setEstDepartureTime(Instant estDepartureTime) { this.estDepartureTime = estDepartureTime; }

    public Instant getEstArrivalTime() { return estArrivalTime; }
    public void setEstArrivalTime(Instant estArrivalTime) { this.estArrivalTime = estArrivalTime; }
}
