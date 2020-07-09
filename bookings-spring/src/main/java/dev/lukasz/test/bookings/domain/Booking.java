package dev.lukasz.test.bookings.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue
    private Long id;

    private String serviceId;
    private String serviceName;
    private Integer servicePrice;
    private String userEmail;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Booking(@JsonProperty(value = "serviceId", required = true) String serviceId,
                   @JsonProperty(value = "serviceName") String serviceName,
                   @JsonProperty(value = "servicePrice", required = true) Integer servicePrice,
                   @JsonProperty(value = "user", required = true) String user) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
        this.userEmail = user;
    }

    public Long getId() {
        return id;
    }

    public String getServiceId() {
        return serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public Money getServicePrice() {
        return Money.ofMinor(CurrencyUnit.EUR, servicePrice);
    }

    public String getUserEmail() {
        return userEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return getServiceId().equals(booking.getServiceId()) &&
                getServiceName().equals(booking.getServiceName()) &&
                getServicePrice().equals(booking.getServicePrice()) &&
                getUserEmail().equals(booking.getUserEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getServiceId(), getServiceName(), getServicePrice(), getUserEmail());
    }

    @Override
    public String toString() {
        return "Booking{" +
                "serviceId='" + serviceId + '\'' +
                ", bookingName='" + serviceName + '\'' +
                ", cost=" + servicePrice +
                ", user='" + userEmail + '\'' +
                '}';
    }


}