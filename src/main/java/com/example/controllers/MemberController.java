package com.example.controllers;

import java.util.List;

import com.example.domain.EventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Member;
import com.example.domain.MemberDto;
import com.example.services.MemberService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api"})
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/addMember")
	public MemberDto addMemberPost (@RequestBody Member member) {
		Member result = memberService.create(member);
		MemberDto dto = new MemberDto();

		dto.setId(result.getId());
		dto.setEmail(result.getEmail());
		dto.setLastName(result.getLastName());
		dto.setName(result.getName());
		return dto;
	}
	
	@GetMapping("/addMember")
	public List<Member> getAllMembers () {
		return memberService.findAll();
	}
}
