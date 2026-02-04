package com.paul.carsharing.service;

import com.paul.carsharing.model.Booking;
import com.paul.carsharing.model.Car;
import com.paul.carsharing.model.User;
import com.paul.carsharing.repository.BookingRepository;
import com.paul.carsharing.repository.CarRepository;
import com.paul.carsharing.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;

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

        car.setAvailable(false);
        carRepository.save(car);

        return bookingRepository.save(booking);
    }
}