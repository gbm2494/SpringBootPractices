package com.springDataCourse.springDataCourse;

import com.springDataCourse.springDataCourse.entity.Flight;
import com.springDataCourse.springDataCourse.repository.FlightRepository;
import com.springDataCourse.springDataCourse.service.FlightService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionalTests {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightService flightService;

    @Before
    public void setup(){
        flightRepository.deleteAll();
    }

    @Test
    public void shouldNotRollBackWhenTheresNoTransaction(){
        try{
            flightService.saveFlight(new Flight());
        }catch (Exception e){
            //Do nothing
        }
        finally {
            assertThat(flightRepository.findAll()).isNotEmpty();
        }
    }

    @Test
    public void shouldNotRollBackWhenThereIsATransaction(){
        try{
            flightService.saveFlightTransactional(new Flight());
        }catch (Exception e){
            //Do nothing
        }
        finally {
            assertThat(flightRepository.findAll()).isEmpty();
        }
    }
}
