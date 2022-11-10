package com.capgemini.controllers;

import com.capgemini.services.IMemberService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalController {

    private final IMemberService memberService;

    public GlobalController(IMemberService memberService) {
        this.memberService = memberService;
    }

    @ModelAttribute
    public void globalAttribute(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("userLogIn", auth.getName());
    }
}
