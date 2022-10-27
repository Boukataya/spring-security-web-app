package com.capgemini.controllers;

import com.capgemini.entities.Member;
import com.capgemini.repositories.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        List<Member> memberList = memberRepository.findAll();
        model.addAttribute("members", memberList);
        //model.addAttribute("name", "memberList");
        return "index";
    }
}
