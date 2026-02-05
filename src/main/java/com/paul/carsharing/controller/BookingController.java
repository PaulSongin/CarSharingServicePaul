package com.paul.carsharing.controller;

import com.paul.carsharing.dto.BookingResponseDto;
import com.paul.carsharing.model.Booking;
import com.paul.carsharing.service.BookingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public BookingResponseDto bookCar(@RequestParam Long userId, @RequestParam Long carId) {
        Booking booking = bookingService.createBooking(userId, carId);
        return new BookingResponseDto(
                booking.getId(),
                booking.getStartTime(),
                booking.getEndTime(),
                booking.getStatus(),
                booking.getCar().getId(),
                booking.getUser().getId()
        );
    }
}