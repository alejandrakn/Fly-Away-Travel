package com.example.fly_away_travel_api.service;

import com.example.fly_away_travel_api.model.Booking;
import com.example.fly_away_travel_api.model.Flight;
import com.example.fly_away_travel_api.repository.BookingRepository;
import com.example.fly_away_travel_api.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final FlightRepository flightRepository;

    public BookingService(
            BookingRepository bookingRepository,
            FlightRepository flightRepository
    ) {
        this.bookingRepository = bookingRepository;
        this.flightRepository = flightRepository;
    }

    //crera bookking
    public Booking bookFlight(Long flightId, String email) {

        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("Flight not found"));

        //eeem evita vueklos pasados
        if (flight.getDepartureDate().isBefore(LocalDate.now())) {
            throw new RuntimeException("Cannot book past flight");
        }

        Booking booking = new Booking();

        booking.setFlightId(flightId);

        booking.setCustomerId((long) email.hashCode());

        booking.setCustomerName(email);

        booking.setBookingDate(LocalDateTime.now());

        Booking savedBooking = bookingRepository.save(booking);

        //generta txt
        try {
            generateBookingEmailFile(savedBooking, flight);
        } catch (IOException e) {
            throw new RuntimeException("Error generating email file");
        }

        return savedBooking;
    }

    // get reserva
    public Booking getBooking(Long id) {

        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }



    //txt
    private void generateBookingEmailFile(
            Booking booking,
            Flight flight
    ) throws IOException {

        String fileName =
                "flight_booking_email_" + booking.getId() + ".txt";

        FileWriter writer = new FileWriter(fileName);

        writer.write("FLIGHT BOOKING CONFIRMATION\n");
        writer.write("===========================\n\n");

        writer.write("Customer: "
                + booking.getCustomerName() + "\n");

        writer.write("Flight Number: "
                + flight.getFlightNumber() + "\n");

        writer.write("Origin: "
                + flight.getOrigin() + "\n");

        writer.write("Destination: "
                + flight.getDestination() + "\n");

        writer.write("Departure Date: "
                + flight.getDepartureDate() + "\n");

        writer.write("Booking Date: "
                + booking.getBookingDate() + "\n");

        writer.close();
    }
}