package com.capgemini.entities.dto;

import com.capgemini.entities.Role;
import com.capgemini.entities.UserEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto {

    private Long id;
    private String username;
    //private List<Role> roles = new ArrayList<>();


}


