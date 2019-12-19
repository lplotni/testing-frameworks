package dev.lukasz.test.bookings.domain;

import java.util.List;

public class Statistics {
    private final Integer numberOfBookings;
    private Statistics(Integer numberOfBookings){
        this.numberOfBookings = numberOfBookings;
    }

    public static Statistics forBookings(List<String> bookings){
        return new Statistics(bookings.size());
    }

    public Integer getNumberOfBookings() {
        return numberOfBookings;
    }
}
