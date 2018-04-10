package com.example.converter;

import com.example.domain.Member;
import com.example.domain.MemberDto;
import com.example.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberConverter {

    public static MemberDto memberToMemberDto(Member member) {
        MemberDto memberDto = new MemberDto();
        memberDto.setId(member.getId());
        memberDto.setEmail(member.getEmail());
        memberDto.setName(member.getName());
        memberDto.setLastName(member.getLastName());

        return memberDto;
    }

    public static Member memberDtoToMember(MemberDto memberDto) {
        Member member = new Member();
        member.setId(memberDto.getId());
        member.setEmail(memberDto.getEmail());
        member.setName(memberDto.getName());
        member.setLastName(member.getLastName());

        return member;
    }
}