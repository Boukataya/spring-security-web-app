package com.capgemini.controllers;

import com.capgemini.entities.Member;
import com.capgemini.services.IMemberService;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MemberController {

    private final IMemberService memberService;

    public MemberController(IMemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/page/{pageNo}")
    public String membersPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 15;

        Page<Member> page = memberService.membersPage(pageNo, pageSize);
        List<Member> membersList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("members", membersList);
        return "index";
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        return membersPaginated(1, model);
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        model.addAttribute("loggedUser", currentPrincipalName);
        //model.addAttribute("name", "memberList");
        return "dashboard";
    }
}
