package com.capgemini.controllers;

import com.capgemini.entities.Member;
import com.capgemini.services.IMemberService;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MemberController {

    private final IMemberService memberService;

    public MemberController(IMemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/members/page/{pageNo}")
    public String membersPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 15;

        Page<Member> page = memberService.membersPage(pageNo, pageSize);
        List<Member> membersList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("members", membersList);
        return "members";
    }

    @GetMapping("/members")
    public String members(Model model) {
        return membersPaginated(1, model);
    }

    @GetMapping("/edit-member/{id}")
    public String updateMemberView(@PathVariable Long id, Model model) {
        Member member = memberService.findMemberById(id);
        model.addAttribute("member", member);
        return "edit-member";
    }

    //@PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/edit-member/{id}")
    public String updateMember(@PathVariable Long id, @ModelAttribute Member member, Model model) {
        Member editedMember = memberService.findMemberById(id);
        editedMember.setFirstname(member.getFirstname());
        editedMember.setLastname(member.getLastname());
        editedMember.setAddress(member.getAddress());
        editedMember.setPhone(member.getPhone());
        editedMember.setCountry(member.getCountry());
        editedMember.setCity(member.getCity());
        editedMember.setActive(member.isActive());
        System.out.println(member.isActive());
        memberService.saveMember(editedMember);
        model.addAttribute("member", editedMember);
        return "edit-member";
    }

    @GetMapping("/members/delete/{id}")
    public String deleteMember(@PathVariable(value = "id") Long id, Model model) {
        System.out.println(id);
        memberService.deleteMember(id);
        return "redirect:/members";
    }

    @PostMapping("/save-member")
    @PostAuthorize("hasAuthority('ADMIN')")
    public String saveNewMember(@ModelAttribute Member member, Model model) {
        memberService.saveMember(member);
        return membersPaginated(1, model);
    }

    @GetMapping("/add-member")
    public String saveNewMemberView(Model model) {
        model.addAttribute("member", new Member());
        return "add-member";
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
