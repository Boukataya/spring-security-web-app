package com.capgemini.entities.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class MemberDto {

    private String image;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String address;
    private String country;
    private String city;
}
