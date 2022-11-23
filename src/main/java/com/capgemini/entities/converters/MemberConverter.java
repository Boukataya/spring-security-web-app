package com.capgemini.entities.converters;

import com.capgemini.entities.Member;
import com.capgemini.entities.UserEntity;
import com.capgemini.entities.dto.MemberDto;
import com.capgemini.entities.dto.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {

    public static List<MemberDto> toMemberDtoList(List<Member> memberList) {
        List<MemberDto> listMemberDto = new ArrayList<>();
        memberList.stream().map(member -> listMemberDto.add(toMemberDto(member))).collect(Collectors.toList());
        return listMemberDto;
    }

    public static MemberDto toMemberDto(Member member) {
        MemberDto memberDto = new MemberDto();
        memberDto.setImage(member.getImage());
        memberDto.setFirstname(member.getFirstname());
        memberDto.setLastname(member.getLastname());
        memberDto.setEmail(member.getEmail());
        memberDto.setAddress(member.getAddress());
        memberDto.setPhone(member.getPhone());
        memberDto.setCountry(member.getCountry());
        memberDto.setCity(member.getCity());
        return memberDto;
    }
}
