package com.springDataCourse.springDataCourse.repository;

import com.springDataCourse.springDataCourse.entity.Flight;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface FlightRepository extends CrudRepository<Flight, Long> {
    List<Flight> findByOrigin(String origin);

    List<Flight> findByOriginAndDestination(String origin, String destination);

    List<Flight> findByOriginIn(String ... origins); //SELECT * FROM flight WHERE origin IN (?)
}
