package com.capgemini.controllers;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        if (isAuthenticated()) {
            return "redirect:index?alreadyLoggedIn";
        }
        return "login";
    }

//	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
//	public ModelAndView welcome() {
//		ModelAndView modelAndView = new ModelAndView();
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		modelAndView.addObject("userLogIn", auth.getName());
//		modelAndView.setViewName("welcome");
//		return modelAndView;
//	}

    @GetMapping(value = "/index")
    public String welcome() {
        // Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // m.addAttribute("userLogIn", auth.getName());
        return "members";
    }


    @RequestMapping(value = "/access-denied", method = RequestMethod.GET)
    public ModelAndView accessdenied() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("access-denied");
        return modelAndView;
    }

    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || AnonymousAuthenticationToken.class.
                isAssignableFrom(authentication.getClass())) {
            return false;
        }
        return authentication.isAuthenticated();
    }
}