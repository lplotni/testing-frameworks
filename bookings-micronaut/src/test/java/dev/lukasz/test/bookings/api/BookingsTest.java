package dev.lukasz.test.bookings.api;

import com.jayway.jsonpath.JsonPath;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static com.revinate.assertj.json.JsonPathAssert.assertThat;


@MicronautTest
public class BookingsTest {

    @Inject
    @Client("/")
    RxHttpClient client;

    @Test
    @DisplayName("should expose booking's statistic on /statistics")
    void getStatistics(){
        var request = HttpRequest.GET("/statistics");
        final String result = client.toBlocking().retrieve(request);

        assertThat(JsonPath.parse(result)).jsonPathAsString("$.numberOfBookings").isEqualTo("0");
    }
}
