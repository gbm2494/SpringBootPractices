package com.springDataCourse.springDataCourse.repository;

import com.springDataCourse.springDataCourse.entity.Flight;
import org.springframework.data.repository.CrudRepository;


public interface FlightRepository extends CrudRepository<Flight, Long> {
}
