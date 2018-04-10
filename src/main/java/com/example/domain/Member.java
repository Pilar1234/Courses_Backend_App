package com.example.domain;

import javax.persistence.*;

@Entity
@Table(name = "member")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String email;
	private String name;
	private String lastName;

	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private Event event;

	public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

}
