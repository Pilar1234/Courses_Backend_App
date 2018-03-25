package com.example.domain;

public class MemberDto {

	private Long id;
	private String email;
	private String name;
	private String lastName;
	
	private EventDto eventDto;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public EventDto getEventDto() {
		return eventDto;
	}

	public void setEventDto(EventDto eventDto) {
		this.eventDto = eventDto;
	}
}
