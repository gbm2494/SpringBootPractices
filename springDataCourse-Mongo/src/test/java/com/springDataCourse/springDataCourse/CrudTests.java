package com.springDataCourse.springDataCourse;

import com.springDataCourse.springDataCourse.entity.Flight;
import com.springDataCourse.springDataCourse.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataMongoTest
		//only spring concept will be created containing persistence specific beans
class CrudTests {

	@Autowired
	private FlightRepository flightRepository;

	@Test
	public void shouldPerformCRUDOperations(){
		final Flight flight = new Flight();
		flight.setOrigin("Costa Rica");
		flight.setDestination("Madrid");
		flight.setScheduledAt(LocalDateTime.parse("2021-03-24T14:14:00"));

		flightRepository.save(flight);

		assertThat(flightRepository.findAll()).hasSize(1).first().isEqualToComparingFieldByField(flight);

		flightRepository.deleteById(flight.getId());

		assertThat(flightRepository.count()).isZero();

	}

}
