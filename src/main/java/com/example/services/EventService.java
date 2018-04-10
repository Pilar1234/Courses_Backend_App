package com.example.services;

import java.util.List;

import com.example.domain.Event;

public interface EventService {

	Event create(Event event);
	
	List<Event> findAll();
	
	Event findOne(int id);
}
