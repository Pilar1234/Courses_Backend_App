package com.example.controllers;

import java.util.List;

import com.example.converter.EventConverter;
import com.example.domain.EventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Event;
import com.example.services.EventService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api"})
public class EventController {

	EventConverter eventConverter;

	@Autowired
	private EventService eventService;
	
	@PostMapping("/add")
	public EventDto addEventPost (@RequestBody EventDto eventDto) {
		Event entry = new Event();
		entry.setTitle(eventDto.getTitle());
		entry.setAdress(eventDto.getAdress());
		entry.setCity(eventDto.getCity());
		entry.setPeople(eventDto.getMaxParticipants());
		entry.setEventDate(eventDto.getEventDate());
		entry.setDescription(eventDto.getDescription());

		Event result = eventService.create(entry);
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
