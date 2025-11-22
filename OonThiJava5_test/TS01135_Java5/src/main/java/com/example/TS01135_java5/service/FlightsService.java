package com.example.TS01135_java5.service;

import com.example.TS01135_java5.entity.Flights;
import java.util.List;

public interface FlightsService {
    List<Flights> findAll();
    Flights findById(Integer id);
    Flights save(Flights flight);
    void deleteById(Integer id);
    List<Flights> search(Integer id, String airline);
}
