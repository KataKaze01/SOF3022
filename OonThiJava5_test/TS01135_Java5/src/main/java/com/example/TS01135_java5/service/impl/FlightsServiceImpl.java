package com.example.TS01135_java5.service.impl;

import com.example.TS01135_java5.entity.Flights;
import com.example.TS01135_java5.repository.FlightsRepository;
import com.example.TS01135_java5.service.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FlightsServiceImpl implements FlightsService {

    @Autowired
    private FlightsRepository repo; // Đổi repo

    @Override
    public List<Flights> findAll() { return repo.findAll(); }

    @Override
    public Flights findById(Integer id) { return repo.findById(id).orElse(null); }

    @Override
    public Flights save(Flights flight) { return repo.save(flight); } // Đổi kiểu

    @Override
    public void deleteById(Integer id) { repo.deleteById(id); }

    @Override
    public List<Flights> search(Integer id, String airline) { // Đổi tham số
        boolean idInvalid = (id == null);
        boolean nameInvalid = (airline == null || airline.trim().isEmpty());

        if (idInvalid && nameInvalid) {
            return repo.findAll();
        }
        return repo.findByFlightIDOrAirlineContainingIgnoreCase(id, airline); // Đổi phương thức
    }
}