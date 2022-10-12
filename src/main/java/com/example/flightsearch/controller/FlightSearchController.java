package com.example.flightsearch.controller;

import com.example.flightsearch.entity.Flight;
import com.example.flightsearch.service.FlightSearchService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CommonsLog
@RequestMapping("/search")
@RestController
public class FlightSearchController {

    private final FlightSearchService flightSearchService;

    @Autowired
    public FlightSearchController(FlightSearchService flightSearchService) {
        this.flightSearchService = flightSearchService;
    }


//    @PostMapping
//    public Iterable<Flight> getAllFlights(
//            @RequestParam(required = false) String number ,
//            @RequestParam(required = false) String origin,
//            @RequestParam(required = false) String destination,
//            @RequestParam(required = false) String departureTime,
//            @RequestParam(required = false) String arrivalTime,
//            @RequestParam(required = false) String price) {
//
//        return this.flightSearchService.searchFlights(number,origin,destination,departureTime,arrivalTime,price);
//    }

    @PostMapping(value = "/", produces = APPLICATION_JSON_VALUE)
    public Iterable<Flight> searchFlights(@Valid @RequestBody Flight flight) {

//        if(log.isDebugEnabled()) {
            log.debug("Controller request body Flight");
            log.debug("number: " + flight.getNumber());
            log.debug("origin: " + flight.getOrigin());
            log.debug("destination: " + flight.getDestination());
            log.debug("departure: " + flight.getDepartureTime());
            log.debug("arrival: " + flight.getArrivalTime());
            log.debug("price: " + flight.getPrice());
//        }
        return this.flightSearchService.searchFlights(flight.getNumber(), flight.getOrigin(), flight.getDestination(), flight.getDepartureTime(),flight.getArrivalTime(),flight.getPrice());
    }

    // https://stackoverflow.com/questions/55256567/spring-boot-jackson-date-and-timestamp-format
//    @Bean
//    public Jackson2ObjectMapperBuilder objectMapperBuilder() {
//        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
////        builder.modules(new ParameterNamesModule());
//        builder.modules(new Jdk8Module());
//        builder.modules(new JavaTimeModule());
//        builder.dateFormat(new SimpleDateFormat("HH:mm"));
//        builder.timeZone(TimeZone.getDefault());
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//        builder.configure(objectMapper);
//        //        builder.dateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//        return builder;
//    }

}
