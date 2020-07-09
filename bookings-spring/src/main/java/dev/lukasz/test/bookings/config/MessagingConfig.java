package dev.lukasz.test.bookings.config;

import dev.lukasz.test.bookings.domain.Bookings;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {
    @Bean
    Queue queue() {
        return new Queue("bookings", false);
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Bookings bookings) {
        return new MessageListenerAdapter(bookings, "process");
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("bookings");
        container.setMessageListener(listenerAdapter);
        return container;
    }
}
