package com.example.flightsearch.entity;


import com.example.flightsearch.controller.CustomTimeConstraint;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;


@Entity
@Table
//@Data
@ToString
@RequiredArgsConstructor
@Getter
@Setter
public class Flight {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Pattern(regexp = "[(A-Z)]{1}[0-9]{3}")
    @Nullable
    @Column(name = "number")
    private String number;

    @Pattern(regexp = "[(A-Z)]{3}")
    @Nullable
    @Column(name = "origin")
    private String origin;

    @Pattern(regexp = "[(A-Z)]{3}")
    @Nullable
    @Column(name = "destination")
    private String destination;

    @JsonFormat(pattern = "HH:mm")
//    @DateTimeFormat(pattern = "HH:mm")
//    @Temporal(TemporalType.TIME)
    @Nullable
    @CustomTimeConstraint
    @Column(name = "departure_time")
    private String departureTime;
    @JsonFormat(pattern = "HH:mm")
//    @DateTimeFormat(pattern = "HH:mm")
//    @Temporal(TemporalType.TIME)
    @Nullable
    @CustomTimeConstraint
    @Column(name = "arrival_time")
    private String arrivalTime;

    @Basic
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 6, fraction = 2)
    @Nullable
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
