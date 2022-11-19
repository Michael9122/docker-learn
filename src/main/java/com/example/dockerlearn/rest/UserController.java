package com.example.dockerlearn.rest;

import com.example.dockerlearn.data.User;
import com.example.dockerlearn.exeption.ResourceNotFoundException;
import com.example.dockerlearn.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/create")
    public User creatUser(User user) {
        return userRepository.save(user);
    }

    @PostMapping(path = "/delete/{id}")
    public void creatUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    @GetMapping
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public User getAllUser(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}
