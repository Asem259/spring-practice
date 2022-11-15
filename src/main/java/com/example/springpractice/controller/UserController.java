package com.example.springpractice.controller;

import com.example.springpractice.dto.NewUserRequest;
import com.example.springpractice.dto.UserResponse;
import com.example.springpractice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public UserResponse registerNewUser(@RequestBody @Valid NewUserRequest newUserData) {
       return service.createNewUser(newUserData);
    }
}
