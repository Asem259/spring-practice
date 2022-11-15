package com.example.springpractice.repository;

import com.example.springpractice.model.Thing;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ThingRepo extends MongoRepository<Thing,String> {
}
