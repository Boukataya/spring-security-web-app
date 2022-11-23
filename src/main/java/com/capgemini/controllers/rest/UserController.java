package com.capgemini.controllers.rest;

import com.capgemini.entities.converters.UserCoverter;
import com.capgemini.entities.UserEntity;
import com.capgemini.entities.dto.UserDto;
import com.capgemini.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<UserDto> allUsers() {
        List<UserEntity> users = userRepository.findAll();
        return UserCoverter.toUserDtoList(users);
    }



}
