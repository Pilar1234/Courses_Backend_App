package com.example.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.Event;

public interface EventRepository extends CrudRepository<Event, Integer>{

    List<Event> findAll();

    Event findOne(int id);

    Event save(Event event);
}
