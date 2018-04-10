package com.example.demo;

import com.example.domain.EventDto;
import com.example.domain.MemberDto;
import com.example.services.EventService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.BackendApplication;
import com.example.domain.Event;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddEventTest {

	private EventDto eventDto;
	private Event event;

	private int id;
	@Autowired
	TestRestTemplate restTemplate;

	@Autowired
	EventService eventService;

	@Test
	public void registerEvent() {
		EventDto item = new EventDto();
		item.setAdress("Krakowskie Przedmiescie 5");
		item.setCity("Warszawa");
		item.setDescription("Przykładowy opis szkolenia");
		item.setEventDate("5/10/2017");
		item.setMaxParticipants(20);
		item.setTitle("Przykładowy test");

		ResponseEntity<EventDto> response = restTemplate.postForEntity("/api/add", item, EventDto.class);
		EventDto actual = response.getBody();

		Assertions.assertThat(actual.getAdress()).hasToString("Krakowskie Przedmiescie 5");
		Assertions.assertThat(actual.getCity()).hasToString("Warszawa");
		Assertions.assertThat(actual.getDescription()).hasToString("Przykładowy opis szkolenia");
		Assertions.assertThat(actual.getEventDate()).hasToString("5/10/2017");
		Assertions.assertThat(actual.getMaxParticipants()).isEqualTo(20);
		Assertions.assertThat(actual.getTitle()).hasToString("Przykładowy test");
		Assertions.assertThat(actual.getCurrentParticipants()).hasSize(0);
	}

	@Test
	public void addMember() {
		
		MemberDto item = new MemberDto();
		item.setEmail("pilar@gmail.com");
		item.setLastName("Pilarski");
		item.setName("Pilar");
		ResponseEntity<MemberDto> response = restTemplate.postForEntity("/api/addMember", item, MemberDto.class);
		MemberDto actual = response.getBody();
		Assertions.assertThat(actual.getEmail()).hasToString("pilar@gmail.com");
		Assertions.assertThat(actual.getLastName()).hasToString("Pilarski");
		Assertions.assertThat(actual.getName()).hasToString("Pilar");
	}
	
	@Test
	public void shouldAddMember() {
		EventDto item = new EventDto();
		item.setAdress("Krakowskie Przedmiescie 5");
		item.setCity("Warszawa");
		item.setDescription("Przykładowy opis szkolenia");
		item.setEventDate("5/10/2017");
		item.setMaxParticipants(20);
		item.setTitle("Test");

		ResponseEntity<EventDto> response = restTemplate.postForEntity("/api/add", item, EventDto.class);
		EventDto actual = response.getBody();

		Assertions.assertThat(actual.getAdress()).hasToString("Krakowskie Przedmiescie 5");
		Assertions.assertThat(actual.getCity()).hasToString("Warszawa");
		Assertions.assertThat(actual.getDescription()).hasToString("Przykładowy opis szkolenia");
		Assertions.assertThat(actual.getEventDate()).hasToString("5/10/2017");
		Assertions.assertThat(actual.getMaxParticipants()).isEqualTo(20);
		Assertions.assertThat(actual.getTitle()).hasToString("Test");
		Assertions.assertThat(actual.getCurrentParticipants()).hasSize(0);

		MemberDto item1 = new MemberDto();
		item1.setEmail("pilar@gmail.com");
		item1.setLastName("Pilarski");
		item1.setName("Pilar");
		item1.setEventDto(actual);
		ResponseEntity<MemberDto> response1 = restTemplate.postForEntity("/api/addMember", item1, MemberDto.class);
		MemberDto actual1 = response1.getBody();
		Assertions.assertThat(actual1.getEmail()).hasToString("pilar@gmail.com");
		Assertions.assertThat(actual1.getLastName()).hasToString("Pilarski");
		Assertions.assertThat(actual1.getName()).hasToString("Pilar");
		Assertions.assertThat(actual1.getEventDto().getCurrentParticipants()).hasSize(1);

	}
}
