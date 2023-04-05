package com.example.learning.moviereview.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    @Value("${events.user.registration.topic}")
    private String userRegistrationTopic;

    @Value("${events.user.welcome.queue}")
    private String welcomeEmailQueue;

    @Value("${events.user.welcome.routingKey}")
    private String welcomeEmailRoutingKey;

    @Bean
    Queue welcomeMailQueue() {
        return new Queue(welcomeEmailQueue, true);
    }

    @Bean
    TopicExchange userRegistrationTopic() {
        return new TopicExchange(userRegistrationTopic);
    }

    @Bean
    Binding welcomeMailBinding(Queue welcomeMailQueue, Exchange userRegistrationTopic) {
        return BindingBuilder.bind(welcomeMailQueue)
                .to(userRegistrationTopic)
                .with(welcomeEmailRoutingKey).noargs();
    }

    @Bean
    Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
