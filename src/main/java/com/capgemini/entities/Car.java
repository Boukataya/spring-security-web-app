package com.capgemini.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "car_maker")
    private String carMaker;
    @Column(name = "car_model")
    private String carModel;
    @Column(name = "car_model_year")
    private Long carModelYear;
    @Column(name = "creation_date")
    @CreationTimestamp
    private Date creationDate;

}
