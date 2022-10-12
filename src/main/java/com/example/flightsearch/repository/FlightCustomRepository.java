package com.example.flightsearch.repository;

import com.example.flightsearch.entity.Flight;

import java.math.BigDecimal;

public interface FlightCustomRepository {

    Iterable<Flight> findAll(String number, String origin, String destination, String departureTime, String arrivalTime, BigDecimal price);

}
