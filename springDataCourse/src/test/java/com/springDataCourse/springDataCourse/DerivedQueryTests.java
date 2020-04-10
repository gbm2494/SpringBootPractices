package com.springDataCourse.springDataCourse;

import com.springDataCourse.springDataCourse.entity.Flight;
import com.springDataCourse.springDataCourse.repository.FlightRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DerivedQueryTests {

    @Autowired
    private FlightRepository flightRepository;

    @Before
    public void setup(){
        flightRepository.deleteAll();
    }

    @Test
    public void shouldFindFlightsFromLondon(){
        final Flight flight1 = createFlight("London");
        final Flight flight2 = createFlight("London");
        final Flight flight3 = createFlight("New York");

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        List<Flight> flightsFromLondon = flightRepository.findByOrigin("London");

        Assertions.assertThat(flightsFromLondon).hasSize(2);
        Assertions.assertThat(flightsFromLondon.get(0)).isEqualToComparingFieldByField(flight1);
        Assertions.assertThat(flightsFromLondon.get(1)).isEqualToComparingFieldByField(flight2);
    }

    @Test
    public void shouldFindFlightsFromLondonToParis(){
        final Flight flight1 = createFlight("London", "Paris");
        final Flight flight2 = createFlight("London", "New York");
        final Flight flight3 = createFlight("Madrid" , "Paris");

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        List<Flight> flights = flightRepository.findByOriginAndDestination("London", "Paris");

        Assertions.assertThat(flights).hasSize(1).first().isEqualToComparingFieldByField(flight1);
    }

    @Test
    public void shouldFindFlightsFromLondonOrMadrid(){
        final Flight flight1 = createFlight("London", "New York");
        final Flight flight2 = createFlight("Tokyo", "New York");
        final Flight flight3 = createFlight("Madrid" , "New York");

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        List<Flight> flights = flightRepository.findByOriginIn("London", "Madrid");

        Assertions.assertThat(flights).hasSize(2);

        Assertions.assertThat(flights.get(0)).isEqualToComparingFieldByField(flight1);
        Assertions.assertThat(flights.get(1)).isEqualToComparingFieldByField(flight3);
    }

    private Flight createFlight(String origin, String destination) {
        final Flight flight = new Flight();
        flight.setOrigin(origin);
        flight.setDestination(destination);
        flight.setScheduledAt(LocalDateTime.parse("2021-03-24T14:14:00"));
        return flight;
    }

    private Flight createFlight(String origin){
        return createFlight(origin, "Madrid");
    }
}
