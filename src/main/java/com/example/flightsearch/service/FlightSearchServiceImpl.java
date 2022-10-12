package com.example.flightsearch.service;

import com.example.flightsearch.entity.Flight;
import com.example.flightsearch.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class FlightSearchServiceImpl implements FlightSearchService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightSearchServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override

    public Iterable<Flight> searchFlights(String number, String origin, String destination, String departureTime, String arrivalTime, BigDecimal price) {
        return this.flightRepository.findAll(number, origin, destination, departureTime, arrivalTime, price);
    }
}