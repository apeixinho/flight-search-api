package com.example.flightsearch.service;

import com.example.flightsearch.entity.Flight;

public interface FlightSearchService {

    Iterable<Flight> getAllFlights();
}

