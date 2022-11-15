package com.example.springpractice.service;

import com.example.springpractice.dto.NewThingRequest;
import com.example.springpractice.model.Thing;
import com.example.springpractice.repository.ThingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ThingService {
    private final ThingRepo repo;

    public Thing createSomething(NewThingRequest something) {
        String id = UUID.randomUUID().toString();
        Thing newThing = new Thing(id, something.desc(), something.type());
        return repo.save(newThing);
    }

}
