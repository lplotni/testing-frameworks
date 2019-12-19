package dev.lukasz.test.bookings.api;

import dev.lukasz.test.bookings.domain.Statistics;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

import java.util.List;

@Controller("/statistics")
public class Bookings {

    @Get
    public HttpResponse<Statistics> getStatistics(){
        return HttpResponse.ok(Statistics.forBookings(List.of()));
    }
}
