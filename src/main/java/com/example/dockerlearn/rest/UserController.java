package com.example.dockerlearn.rest;

import com.example.dockerlearn.data.User;
import com.example.dockerlearn.exeption.ResourceNotFoundException;
import com.example.dockerlearn.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Transactional
    public User creatUser(@RequestBody User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("User with email: " + user.getEmail() + " exists");
        }
        return userRepository.save(user);
    }

    @GetMapping(path = "/{id}")
    @Transactional
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @DeleteMapping(path = "/{id}")
    @Transactional
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    @PutMapping(path = "/{id}")
    @Transactional
    public User updateUser(@RequestBody User user, @PathVariable Long id) {
        User presentUser = userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        user.setId(presentUser.getId());
        return userRepository.save(user);
    }

    @GetMapping(path = "/list")
    @Transactional
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
