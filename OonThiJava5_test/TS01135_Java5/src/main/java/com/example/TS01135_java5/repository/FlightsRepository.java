package com.example.TS01135_java5.repository;

import com.example.TS01135_java5.entity.Flights;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FlightsRepository extends JpaRepository<Flights, Integer> {

    // Phương thức tìm kiếm (theo ID hoặc Airline)
    List<Flights> findByFlightIDOrAirlineContainingIgnoreCase(Integer id, String airline);
}