package dev.lukasz.test.bookings.domain;

import dev.lukasz.test.bookings.storage.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class Archive {
    private final BookingRepository repository;
    private final Logger logger = Logger.getLogger(String.valueOf(Archive.class));

    @Autowired
    public Archive(BookingRepository repository) {
        this.repository = repository;
    }

    public void store(Booking newBooking) {
        Booking booking = repository.save(newBooking);
        logger.info(() -> String.format("New booking stored. Id %s", booking.getId()));
    }
}
