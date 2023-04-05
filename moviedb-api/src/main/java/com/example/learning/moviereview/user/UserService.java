package com.example.learning.moviereview.user;

import com.example.learning.moviereview.common.event.DomainEvent;
import com.example.learning.moviereview.user.dto.UserRegisterEvent;
import com.example.learning.moviereview.user.exceptions.UserEmailAlreadyExistsException;
import com.example.learning.moviereview.user.exceptions.UserNotFoundException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserService {
    @Value("${events.user.registration.topic}")
    private String userRegistrationTopic;

    @Value("${events.user.welcome.routingKey}")
    private String welcomeEmailRoutingKey;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RabbitTemplate rabbitTemplate;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       RabbitTemplate rabbitTemplate,
                       AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.rabbitTemplate = rabbitTemplate;
        this.authenticationManager = authenticationManager;
    }

    public User register(String email, String password, String name) throws UserEmailAlreadyExistsException {
        var user = userRepository.findByEmail(email);
        if(user.isPresent()) {
            throw new UserEmailAlreadyExistsException("user email already exists");
        }
        var currentTimestamp = LocalDateTime.now();
        var newUser = User.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .name(name)
                .role(Role.USER)
                .createdAt(currentTimestamp)
                .updatedAt(currentTimestamp)
                .build();
        User savedUser = userRepository.save(newUser);
        publishUserRegistrationEvent(savedUser);
        return savedUser;
    }

    public User login(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                email, password));
        var user = userRepository.findByEmail(email);
        return user.orElseThrow(() -> new UsernameNotFoundException("User [" + email +"] not found"));
    }

    public User getUserDetails(Integer userId) throws UserNotFoundException {
        var user = userRepository.findById(userId);
        return user.orElseThrow(() -> new UserNotFoundException("User with id [" + userId + "] doesn't exist"));
    }

    public User getUserReference(Integer userId) {
        return userRepository.getReferenceById(userId);
    }

    private void publishUserRegistrationEvent(User user) {
        var userRegisterEventPayload = new UserRegisterEvent(user.getEmail(), user.getName());
        var userRegisterEvent = new DomainEvent<>(
                UUID.randomUUID().toString(),
                System.currentTimeMillis(),
                userRegisterEventPayload
        );
        rabbitTemplate.convertAndSend(userRegistrationTopic,
                welcomeEmailRoutingKey,
                userRegisterEvent);
    }
}