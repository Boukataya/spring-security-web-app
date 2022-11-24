package com.capgemini.entities.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CarDto {

    private Long id;
    private String car_maker;
    private String car_model;
    private Long car_model_year;
    private Date creation_date;

}
