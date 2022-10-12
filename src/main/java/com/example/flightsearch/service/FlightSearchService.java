package com.example.flightsearch.service;

import com.example.flightsearch.entity.Flight;

import java.math.BigDecimal;

public interface FlightSearchService {

    Iterable<Flight> searchFlights(String number, String origin, String destination, String departureTime, String arrivalTime, BigDecimal price);
}

