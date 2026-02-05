package com.paul.carsharing.controller;

import com.paul.carsharing.dto.*;
import com.paul.carsharing.model.Car;
import com.paul.carsharing.repository.CarRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public List<CarResponseDto> getAllCars() {
        return carRepository.findAllByOrderByIdAsc().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public CarResponseDto addCar(@RequestBody @Valid CarDto carDto) {
        Car car = new Car();
        car.setBrand(carDto.brand());
        car.setModel(carDto.model());
        car.setPricePerDay(carDto.pricePerDay());
        Car savedCar = carRepository.save(car);
        return mapToDto(savedCar);
    }

    private CarResponseDto mapToDto(Car car) {
        return new CarResponseDto(
                car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getPricePerDay(),
                car.isAvailable()
        );
    }
}