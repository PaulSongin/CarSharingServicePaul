package com.paul.carsharing.controller;

import com.paul.carsharing.model.Booking;
import com.paul.carsharing.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    // POST http://localhost:8080/api/bookings?userId=1&carId=1
    @PostMapping
    public Booking bookCar(@RequestParam Long userId, @RequestParam Long carId) {
        return bookingService.createBooking(userId, carId);
    }
}