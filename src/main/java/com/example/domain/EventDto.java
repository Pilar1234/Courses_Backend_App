package com.example.domain;

import java.util.List;

public class EventDto {

	private int id;
	private String title;
	private String eventDate;
	private int maxParticipants;
	private String city;
	private String adress;
	private String description;

	private List<MemberDto> currentParticipants;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public int getMaxParticipants() {
		return maxParticipants;
	}

	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<MemberDto> getCurrentParticipants() {
		return currentParticipants;
	}

	public void setCurrentParticipants(List<MemberDto> currentParticipants) {
		this.currentParticipants = currentParticipants;
	}
}
