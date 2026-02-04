package com.paul.carsharing.controller;

import com.paul.carsharing.dto.CarDto;
import com.paul.carsharing.model.Car;
import com.paul.carsharing.repository.CarRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarRepository carRepository;

    @GetMapping
    public List<Car> getAllCars() {
        return carRepository.findAllByOrderByIdAsc();
    }

    @PostMapping
    public Car addCar(@RequestBody @Valid CarDto carDto) {
        Car car = new Car();
        car.setBrand(carDto.brand());
        car.setModel(carDto.model());
        car.setPricePerDay(carDto.pricePerDay());

        return carRepository.save(car);
    }
}