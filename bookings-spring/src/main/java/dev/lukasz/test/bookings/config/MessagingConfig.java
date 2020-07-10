package dev.lukasz.test.bookings.config;

import dev.lukasz.test.bookings.domain.Bookings;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class MessagingConfig {
    @Bean
    Queue queue(@Value("${bookings.queue.name}") String queueName) {
        return new Queue(queueName, false);
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Bookings bookings) {
        return new MessageListenerAdapter(bookings, "process");
    }

    @Bean
    ConnectionFactory connectionFactory(@Value("${bookings.queue.host}") String queueHost){
        return new CachingConnectionFactory(queueHost);
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
