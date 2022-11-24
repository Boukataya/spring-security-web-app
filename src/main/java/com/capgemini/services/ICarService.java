package com.capgemini.services;

import com.capgemini.entities.Car;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICarService {

    Page<Car> carsPage(int pageNumber, int pageSize);

    void saveCar(Car car);

    void updateCar(Long id);

    void deleteCar(Long id);

    List<String> allMakers();

}
