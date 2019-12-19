package dev.lukasz.test.bookings.domain;

import io.micronaut.core.annotation.Introspected;

import java.util.List;

@Introspected
public class Statistics {
    private final Integer numberOfBookings;
    Statistics(Integer numberOfBookings){
        this.numberOfBookings = numberOfBookings;
    }

    public static Statistics forBookings(List<String> bookings){
        return new Statistics(bookings.size());
    }

    public Integer getNumberOfBookings() {
        return numberOfBookings;
    }
}
