package com.example.flightsearch.repository;

import com.example.flightsearch.entity.Flight;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@CommonsLog
public class FlightCustomRepositoryImpl implements FlightCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Iterable<Flight> findAll(String number, String origin, String destination, String departureTime, String  arrivalTime, BigDecimal price) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Flight> query = cb.createQuery(Flight.class);
        Root<Flight> flight = query.from(Flight.class);
//        EntityType<Flight> Flight_ = entityManager.getMetamodel().entity(Flight.class);

        log.debug("---------------------------------");
        log.debug("flight number " + number);
        log.debug("origin: " + origin);
        log.debug("destination: " + destination);
        log.debug("departure: " + departureTime);
        log.debug("arrival: " + arrivalTime);
        log.debug("price: " + price);

        List<Predicate> predicates = new ArrayList<>();
        if (number != null && !number.isEmpty())
            predicates.add((cb.like(flight.get("number"), number)));
        if (origin != null && !origin.isEmpty())
            predicates.add(cb.like(flight.get("origin"), origin));
        if (destination != null && !destination.isEmpty())
            predicates.add(cb.like(flight.get("destination"), destination));
        if (departureTime != null)
            predicates.add(cb.greaterThan(flight.get("departureTime"), departureTime));
        if (arrivalTime != null)
            predicates.add(cb.lessThan(flight.get("arrivalTime"), arrivalTime));
        if (price != null)
            predicates.add(cb.lessThan(flight.get("price"), price));

//
////        if (log.isDebugEnabled()) {
        log.debug("predicates array size: " + predicates.size());
////        }
//
        query.select(flight).where(predicates.toArray(new Predicate[predicates.size()]));
//
        return entityManager.createQuery(query).getResultList();
//        return null;
    }
}
