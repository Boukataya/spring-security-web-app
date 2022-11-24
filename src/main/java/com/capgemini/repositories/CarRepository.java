package com.capgemini.repositories;

import com.capgemini.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query(value = "select distinct c.carMaker from Car c ORDER BY c.carMaker")
    List<String> getALlMakers();

}
