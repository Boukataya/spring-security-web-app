package com.capgemini.services;

import com.capgemini.entities.Car;
import com.capgemini.repositories.CarRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements ICarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Page<Car> carsPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return this.carRepository.findAll(pageable);
    }

    @Override
    public void saveCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void updateCar(Long id) {

    }

    @Override
    public void deleteCar(Long id) {

    }

    @Override
    public List<String> allMakers() {
        return carRepository.getALlMakers();
    }

}
