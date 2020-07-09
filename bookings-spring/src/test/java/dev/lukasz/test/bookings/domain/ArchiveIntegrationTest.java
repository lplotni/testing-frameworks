package dev.lukasz.test.bookings.domain;

import dev.lukasz.test.bookings.config.TestStorageConfig;
import dev.lukasz.test.bookings.storage.BookingRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest()
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringJUnitConfig(classes = TestStorageConfig.class)
class ArchiveIntegrationTest {

   @Autowired
   BookingRepository repo;

    @Test
    @DisplayName("should store Booking")
    void store() {
        Booking booking = new Booking(
                "cea93ceb-d9f5-4b23-b5df-9baff6f9d44d",
                "Service by Lukasz.dev",
                123001,
                "john@example.com"
        );

        new Archive(repo).store(booking);
        List<Booking> result = repo.findByServiceId("cea93ceb-d9f5-4b23-b5df-9baff6f9d44d");

        assertThat(result).containsExactly(booking);
    }
}