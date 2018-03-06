package com.example.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Event;
import com.example.repositories.EventRepository;
import com.example.services.EventService;

@Service
public class EventServiceImpl implements EventService{

	@Autowired
	private EventRepository eventRepository;
	
	public Event create(Event event) {
		return eventRepository.save(event);
	}

	@Override
	public Event findOne(long id) {
		return eventRepository.findOne(id);
	}

	@Override
	public List<Event> findAll() {
		return eventRepository.findAll();
	}
}
