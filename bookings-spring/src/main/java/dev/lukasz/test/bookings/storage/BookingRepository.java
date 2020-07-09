package dev.lukasz.test.bookings.storage;

import dev.lukasz.test.bookings.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByServiceId(String serviceId);

}
