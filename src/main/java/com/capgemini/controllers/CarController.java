package com.capgemini.controllers;

import com.capgemini.entities.Car;
import com.capgemini.entities.Member;
import com.capgemini.services.ICarService;
import com.capgemini.util.FileUploadUtil;
import org.apache.commons.io.FilenameUtils;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class CarController {

    private final ICarService carService;

    public CarController(ICarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars/page/{pageNo}")
    public String carsPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;
        Page<Car> page = carService.carsPage(pageNo, pageSize);
        List<Car> carsList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("cars", carsList);
        return "cars";
    }

    @GetMapping("/cars")
    public String members(Model model) {
        return carsPaginated(1, model);
    }

    @PostMapping("/save-car")
    @PostAuthorize("hasAuthority('ADMIN')")
    public String saveNewCar(@ModelAttribute Car car, Model model) {
        carService.saveCar(car);
        return carsPaginated(1, model);
    }

    @GetMapping("/add-car")
    public String saveNewMemberView(Model model) {
        List<String> allMakers = carService.allMakers();
        model.addAttribute("makers", allMakers);
        model.addAttribute("member", new Car());
        return "add-car";
    }

}
