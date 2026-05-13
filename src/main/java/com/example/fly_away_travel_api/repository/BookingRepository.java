package com.example.fly_away_travel_api.repository;

import com.example.fly_away_travel_api.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}