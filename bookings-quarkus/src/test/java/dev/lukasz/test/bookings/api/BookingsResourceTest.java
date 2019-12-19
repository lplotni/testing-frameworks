package dev.lukasz.test.bookings.api;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BookingsResourceTest {

    @Test
    @DisplayName("should expose booking's statistic on /statistics")
    public void getStatistics() {
        given()
                .when().get("/statistics")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("numberOfBookings", equalTo(0));
    }

}