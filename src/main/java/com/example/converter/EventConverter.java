package com.example.converter;

import com.example.domain.Event;
import com.example.domain.EventDto;
import java.util.stream.Collectors;

public class EventConverter {

    public EventDto eventToEventDto(Event event){
        EventDto dto = new EventDto();
        dto.setId(event.getId());
        dto.setTitle(event.getTitle());
        dto.setAdress(event.getAdress());
        dto.setCity(event.getCity());
        dto.setMaxParticipants(event.getPeople());
        dto.setEventDate(event.getEventDate());
        dto.setDescription(event.getDescription());
        dto.setCurrentParticipants(event.getMembersNumber().stream().map(MemberConverter::memberToMemberDto).collect(Collectors.toList()));

        return dto;
    }

    public Event eventDtoToEvent(EventDto eventDto){
        Event event = new Event();
        event.setTitle(eventDto.getTitle());
        event.setAdress(eventDto.getAdress());
        event.setCity(eventDto.getCity());
        event.setPeople(eventDto.getMaxParticipants());
        event.setEventDate(eventDto.getEventDate());
        event.setDescription(eventDto.getDescription());
        event.setMembersNumber(eventDto.getCurrentParticipants().stream().map(MemberConverter::memberDtoToMember).collect(Collectors.toList()));

        return event;
    }

}
