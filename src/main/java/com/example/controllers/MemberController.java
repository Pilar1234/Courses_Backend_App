package com.example.controllers;

import java.util.List;

import com.example.converter.EventConverter;
import com.example.converter.MemberConverter;
import com.example.domain.Event;
import com.example.domain.EventDto;
import com.example.domain.MemberDto;
import com.example.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Member;
import com.example.services.MemberService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api"})
public class MemberController {

    private EventConverter eventConverter = new EventConverter();
private Event event;

    @Autowired
    private EventService eventService;

    @Autowired
    private MemberService memberService;

    @PostMapping("/addMember")
    public MemberDto addMemberPost(@RequestBody MemberDto member) {
        Member entry = new Member();
        entry.setEmail(member.getEmail());
        entry.setLastName(member.getLastName());
        entry.setName(member.getName());
        entry.setEvent(eventService.findOne(member.getEventDto().getId()));

        Member result = memberService.create(entry);
        MemberDto dto = new MemberDto();

        dto.setId(result.getId());
        dto.setEmail(result.getEmail());
        dto.setLastName(result.getLastName());
        dto.setName(result.getName());
        dto.setEventDto(eventConverter.eventToEventDto(result.getEvent()));
        return dto;
    }

    @GetMapping("/addMember")
    public List<Member> getAllMembers() {
        return memberService.findAll();
    }
}
