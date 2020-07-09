package dev.lukasz.test.bookings.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookingsTest {

    private Archive mockedArchive;
    private Bookings bookings;

    @BeforeEach
    void setUp() {
        mockedArchive = mock(Archive.class);
        bookings = new Bookings(mockedArchive, new ObjectMapper());
    }

    @Test
    @DisplayName("should construct a booking and store it")
    void processBooking() throws IOException {
        final String msg = "{\n" +
                "\"serviceId\":\"3888054\",\n" +
                "\"serviceName\":\"eventually\",\n" +
                "\"servicePrice\":5045825,\n" +
                "\"user\":\"voice@example.com\"\n" +
                "}\n";

        final Booking expected =
                new Booking("3888054",
                        "eventually",
                        5045825,
                        "voice@example.com");

        bookings.process(msg.getBytes());

        verify(mockedArchive).store(eq(expected));
    }

    @Test
    @DisplayName("should throw an exception if Booking cannot be created from the msg")
    void failIfMsgIncorrect() {
        final String incorrectMsg = "{\n" +
                "\"serviceName\":\"eventually\",\n" +
                "\"servicePrice\":5045825,\n" +
                "\"user\":\"voice@example.com\"\n" +
                "}\n";

        assertThrows(MismatchedInputException.class, () ->
                bookings.process(incorrectMsg.getBytes()));
    }
}
