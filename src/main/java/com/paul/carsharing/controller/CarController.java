package com.paul.carsharing.controller;

import com.paul.carsharing.model.Car;
import com.paul.carsharing.repository.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // 1. Получить список всех машин
    // GET http://localhost:8080/api/cars
    @GetMapping
    public List<Car> getAllCars() {
        return carRepository.findAllByOrderByIdAsc();
    }

    // 2. Добавить новую машину
    // POST http://localhost:8080/api/cars
    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return carRepository.save(car);
    }
}