package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.domain.Event;
import com.example.domain.Member;
import com.example.services.EventService;
import com.example.services.MemberService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api"})
public class EventController {

	@Autowired
	private EventService eventService;
	
	@PostMapping("/add")
	public Event addEventPost (@RequestBody Event event) {
		return eventService.create(event);
	}
	
	@GetMapping("/add")
	public List<Event> getAllEvents () {
		return eventService.findAll();
	}

}
