package com.paul.carsharing.service;

import com.paul.carsharing.model.*;
import com.paul.carsharing.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;

    public BookingService(BookingRepository bookingRepository, CarRepository carRepository, UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Booking createBooking(Long userId, Long carId) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new RuntimeException("Машина не найдена"));
        if (!car.isAvailable()) {
            throw new RuntimeException("Машина уже занята!");
        }
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setCar(car);
        booking.setStartTime(LocalDateTime.now());
        booking.setEndTime(LocalDateTime.now().plusDays(1));
        booking.setStatus("ACTIVE");

        car.setAvailable(false);
        carRepository.save(car);
        return bookingRepository.save(booking);
    }
}