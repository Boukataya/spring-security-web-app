package com.capgemini.controllers;

import com.capgemini.entities.Member;
import com.capgemini.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    @PostMapping("/login")
    public ResponseEntity<HttpStatus> login(@RequestBody UserEntity user) throws Exception {

        Authentication authObject = null;
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authObject);
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid credentials");
        }

        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

}
