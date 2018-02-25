package com.example.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.Event;

public interface EventRepository extends CrudRepository<Event, Long>{

    List<Event> findAll();

    Event findOne(Long id);

    Event save(Event event);
}
