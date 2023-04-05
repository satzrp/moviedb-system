package com.example.learning.moviereview.user.listeners;

import com.example.learning.moviereview.common.event.DomainEvent;
import com.example.learning.moviereview.user.dto.UserRegisterEvent;
import com.example.learning.moviereview.utils.mail.WelcomeMailSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserRegistrationListener {

    @Autowired
    private WelcomeMailSender welcomeMailSender;

    @RabbitListener(queues = {"${events.user.welcome.queue}"})
    public void userWelcomeMailHandler(DomainEvent<UserRegisterEvent> message) throws Exception {
        log.info("User registered at: {} with message id: {}",
                message.eventTimestamp(), message.eventId());
        var payload = message.payload();
        welcomeMailSender.send(payload.email(), payload.name());
    }
}
