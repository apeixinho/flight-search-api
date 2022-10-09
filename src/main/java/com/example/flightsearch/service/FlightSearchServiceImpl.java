package com.example.flightsearch.service;

import org.springframework.stereotype.Service;

import com.example.flightsearch.entity.Flight;
import com.example.flightsearch.repository.FlightRepository;

@Service
public class FlightSearchServiceImpl implements FlightSearchService {

    private FlightRepository flightRepository;

    @Override
    public Iterable<Flight> getAllFlights() {
        return this.flightRepository.findAll();
    }
}