package com.example.controller;

import com.example.model.User;
import com.example.UserNotFoundException;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Axe on 24.01.2017.
 */
@RestController
@RequestMapping("user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    how to handle java exceptions single page application

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
    }

    @RequestMapping(value = "/{userId}/posts", method = RequestMethod.GET)
    public User getPosts(@PathVariable long userId) {
        validateUser(userId);
        return new User("child");
    }

    @RequestMapping(value = "/{userId}/posts/{postId}", method = RequestMethod.GET)
    public User getPost(@PathVariable long userId, @PathVariable long postId) {
        validateUser(userId);
        return new User("child");
    }

    private void validateUser(long userId) {
        this.userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
    }
}
