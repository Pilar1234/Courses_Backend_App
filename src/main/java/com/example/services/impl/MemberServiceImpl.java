package com.example.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Member;
import com.example.repositories.MemberRepository;
import com.example.services.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberRepository memberRepository;
	
	public List<Member> findAll() {
		return memberRepository.findAll();
	}
	
	public Member create(Member member) {
		
		return memberRepository.save(member);
	}
	
}
