package com.capgemini.controllers;

import com.capgemini.entities.Member;
import com.capgemini.repositories.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/member")
public class MemberRestController {
    private MemberRepository memberRepository;

    public MemberRestController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> findMember(@PathVariable("id") Long id) {
        Member member = memberRepository.findById(id).get();
        System.out.println(member);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }
}
