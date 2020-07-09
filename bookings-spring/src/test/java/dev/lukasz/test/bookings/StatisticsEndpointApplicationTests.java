package dev.lukasz.test.bookings;

import dev.lukasz.test.bookings.config.TestStorageConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TestStorageConfig.class)
class StatisticsEndpointApplicationTests {

	@Test
	@DisplayName("spring context should load")
	void contextLoads() {
	}

}
