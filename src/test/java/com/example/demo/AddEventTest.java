package com.example.demo;

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
import com.example.domain.EventDto;
import com.example.domain.Member;
import com.example.domain.MemberDto;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddEventTest {

	@Autowired
	TestRestTemplate restTemplate;
	
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
	}
	
	@Test
	public void addMember() {
		Assertions.assertThat(restTemplate).isNotNull();
		
		Member item = new Member();
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
		Event item = new Event();
		item.setAdress("Krakowskie Przedmiescie 5");
		item.setCity("Warszawa");
		item.setDescription("Przykładowy opis szkolenia");
		item.setEventDate("5/10/2017");
		item.setPeople(20);
		item.setTitle("Przykładowy test");
		ResponseEntity<EventDto> response = restTemplate.postForEntity("/api/add", item, EventDto.class);
		EventDto actual = response.getBody();
		Assertions.assertThat(actual.getAdress()).hasToString("Krakowskie Przedmiescie 5");
		Assertions.assertThat(actual.getCity()).hasToString("Warszawa");
		Assertions.assertThat(actual.getDescription()).hasToString("Przykładowy opis szkolenia");
		Assertions.assertThat(actual.getEventDate()).hasToString("5/10/2017");
		Assertions.assertThat(actual.getMaxParticipants()).isEqualTo(20);
		Assertions.assertThat(actual.getTitle()).hasToString("Przykładowy test");

		Member item1 = new Member();
		item1.setEmail("pilar@gmail.com");
		item1.setLastName("Pilarski");
		item1.setName("Pilar");
		item1.setEvent(item);
		ResponseEntity<MemberDto> response1 = restTemplate.postForEntity("/api/addMember", item1, MemberDto.class);
		MemberDto actual1 = response1.getBody();
		Assertions.assertThat(actual1.getEmail()).hasToString("pilar@gmail.com");
		Assertions.assertThat(actual1.getLastName()).hasToString("Pilarski");
		Assertions.assertThat(actual1.getName()).hasToString("Pilar");
	}
}
