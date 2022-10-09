package com.example.flightsearch.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;


@Entity
@Table
@ToString
@RequiredArgsConstructor
@Getter
@Setter
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "departure_time")
    private Time departureTime;

    @Column(name = "arrival_time")
    private Time arrivalTime;

    @Column(name = "price")
    private BigDecimal price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Flight flight)) return false;

        return new EqualsBuilder().append(id, flight.id).append(number, flight.number).append(origin, flight.origin).append(destination, flight.destination).append(departureTime, flight.departureTime).append(arrivalTime, flight.arrivalTime).append(price, flight.price).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(number).append(origin).append(destination).append(departureTime).append(arrivalTime).append(price).toHashCode();
    }
}
