package com.example.fly_away_travel_api.repository;

import com.example.fly_away_travel_api.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

import java.util.Optional;
@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("""
    SELECT f FROM Flight f
    WHERE (:flightNumber IS NULL OR LOWER(f.flightNumber) LIKE LOWER(CONCAT('%', :flightNumber, '%')))
      AND (:airline IS NULL OR LOWER(f.airline) LIKE LOWER(CONCAT('%', :airline, '%')))
      AND (:startDate IS NULL OR f.departureDate >= :startDate)
      AND (:endDate IS NULL OR f.departureDate <= :endDate)
""")
    List<Flight> searchFlights(
            @Param("flightNumber") String flightNumber,
            @Param("airline") String airline,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
}