package com.paul.carsharing.controller;

import com.paul.carsharing.dto.UserDto;
import com.paul.carsharing.model.User;
import com.paul.carsharing.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public User createUser(@RequestBody @Valid UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.username());
        user.setEmail(userDto.email());
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}