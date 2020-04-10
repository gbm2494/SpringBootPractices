package com.springDataCourse.springDataCourse;

import com.springDataCourse.springDataCourse.entity.Flight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest //only spring concept will be created containing persistence specific beans
class SpringDataCourseApplicationTests {

	@Autowired
	private EntityManager entityManager;

	@Test
	void verifyFlightCanBeSaved() {
		final Flight flight = new Flight();
		flight.setOrigin("Costa Rica");
		flight.setDestination("Madrid");
		flight.setScheduledAt(LocalDateTime.parse("2021-03-24T14:14:00"));

		entityManager.persist(flight);

		final TypedQuery<Flight> results = entityManager.createQuery("Select f from Flight f ", Flight.class);

		final List<Flight> resultList = results.getResultList();

		assertThat(resultList).hasSize(1).first().isEqualTo(flight);

	}

}
