package com.capgemini.entities.converters;

import com.capgemini.entities.Car;
import com.capgemini.entities.dto.CarDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarConverter {

    public static List<CarDto> toCarDtoList(List<Car> CarList) {
        List<CarDto> listCarDto = new ArrayList<>();
        CarList.stream().map(Car -> listCarDto.add(toCarDto(Car))).collect(Collectors.toList());
        return listCarDto;
    }

    public static CarDto toCarDto(Car Car) {
        CarDto CarDto = new CarDto();
        CarDto.setCar_maker(Car.getCarMaker());
        CarDto.setCar_model(Car.getCarModel());
        CarDto.setCar_model_year(Car.getCarModelYear());
        CarDto.setCreation_date(Car.getCreationDate());
        CarDto.setId(Car.getId());
        return CarDto;
    }

}
