package dev.lukasz.test.bookings.api;

import dev.lukasz.test.bookings.domain.Statistics;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Bookings {

    @RequestMapping("/statistics/")
    public Statistics getStatistics(){
        return Statistics.forBookings(List.of());
    }
}
