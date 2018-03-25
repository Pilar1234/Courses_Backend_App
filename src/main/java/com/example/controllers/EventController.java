package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Event;
import com.example.domain.EventDto;
import com.example.services.EventService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api"})
public class EventController {

	@Autowired
	private EventService eventService;
	
	@PostMapping("/add")
	public EventDto addEventPost (@RequestBody Event event) {
		Event result = eventService.create(event);
		EventDto dto = new EventDto();
		
		dto.setId(result.getId());
		dto.setTitle(result.getTitle());
		dto.setAdress(result.getAdress());
		dto.setCity(result.getCity());
		dto.setMaxParticipants(result.getPeople());
		dto.setEventDate(result.getEventDate());
		dto.setDescription(result.getDescription());
		return dto;
	}
	
	@GetMapping("/add")
	public List<Event> getAllEvents () {
		return eventService.findAll();
	}

}
