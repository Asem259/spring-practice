package com.example.springpractice.controller;

import com.example.springpractice.dto.NewThingRequest;
import com.example.springpractice.model.Thing;
import com.example.springpractice.service.ThingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/things")
@RequiredArgsConstructor
public class ThingController {

    private final ThingService service;

    @PostMapping
    public Thing createSomething(@Valid @RequestBody NewThingRequest something) {
        return service.createSomething(something);
    }

    @GetMapping
    public String getAnything(){
        return "Anything";
    }
}
