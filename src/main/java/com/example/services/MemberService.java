package com.example.services;

import java.util.List;

import com.example.domain.Member;

public interface MemberService {

	Member create(Member member);

	List<Member> findAll();
}
