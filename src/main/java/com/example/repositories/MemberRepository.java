package com.example.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.Member;

public interface MemberRepository extends CrudRepository<Member, Long>{

	Member save(Member member);
	
	List<Member> findAll();
}
