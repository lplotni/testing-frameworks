package dev.lukasz.test.bookings.domain;

import dev.lukasz.test.bookings.storage.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Archive {
    private final BookingRepository repository;

    @Autowired
    public Archive(BookingRepository repository) {
        this.repository = repository;
    }

    public void store(Booking newBooking){

        repository.save(newBooking);

    }
}
