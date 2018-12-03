package com.acc.cloud.ms.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acc.cloud.ms.domain.User;
import com.acc.cloud.ms.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller for the {@link User} API.
 *
 * @author Laxminarayan Rajput
 */
@RestController
@Slf4j
@RequestMapping("/v1")
public class UserResource {

    private final UserService userService;
    
    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/users", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
    	log.info("User create Resource request: " + user.toString());
        return userService.createUser(user);
    }
}
