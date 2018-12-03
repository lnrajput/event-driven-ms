package com.acc.cloud.ms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.acc.cloud.ms.domain.User;
import com.acc.cloud.ms.event.EventType;
import com.acc.cloud.ms.event.UserEvent;
import com.acc.cloud.ms.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller for the {@link User} API.
 *
 * @author Laxminarayan Rajput
 */
@Service
@Slf4j
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final Source source;

    @Autowired
    public UserService(UserRepository userRepository, Source source) {
        this.userRepository = userRepository;
        this.source = source;
    }

    public User createUser(@RequestBody User user) {
        userRepository.save(user);

        log.info("User created: " + user.toString());
        source.output().send(MessageBuilder
                .withPayload(new UserEvent(user, EventType.USER_CREATED)).build());

        return user;
    }
}
