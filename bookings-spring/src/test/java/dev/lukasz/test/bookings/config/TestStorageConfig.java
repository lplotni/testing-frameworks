package dev.lukasz.test.bookings.config;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import com.opentable.db.postgres.embedded.EmbeddedPostgres;

import java.io.IOException;
@TestConfiguration
public class TestStorageConfig {
    @Bean
    public DataSource dataSource() throws IOException {
        final EmbeddedPostgres embeddedPostgres = EmbeddedPostgres.start();
        return embeddedPostgres.getPostgresDatabase();
    }
}
