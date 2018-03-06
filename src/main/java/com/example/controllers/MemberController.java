package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.domain.Member;
import com.example.services.MemberService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api"})
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/addMember")
	public Member addMemberPost (@RequestBody Member member) {
		return memberService.create(member);
	}
	
	@GetMapping("/addMember")
	public List<Member> getAllMembers () {
		return memberService.findAll();
	}
}
