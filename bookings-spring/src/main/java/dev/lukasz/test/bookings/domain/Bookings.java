package dev.lukasz.test.bookings.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Bookings {
    private final Archive archive;

    private final ObjectMapper jsonMapper;

    @Autowired
    public Bookings(Archive archive, ObjectMapper jsonMapper) {
        this.archive = archive;
        this.jsonMapper = jsonMapper;
    }

    public void process(byte[] msg) throws IOException {
        var booking = jsonMapper.readValue(msg, Booking.class);
        archive.store(booking);
   }
}
