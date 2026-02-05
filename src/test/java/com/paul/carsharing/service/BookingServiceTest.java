package com.paul.carsharing.service;

import com.paul.carsharing.model.Booking;
import com.paul.carsharing.model.Car;
import com.paul.carsharing.model.User;
import com.paul.carsharing.repository.BookingRepository;
import com.paul.carsharing.repository.CarRepository;
import com.paul.carsharing.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private CarRepository carRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private BookingService bookingService;

    @Test
    void createBooking_Success() {
        User user = new User();
        user.setId(1L);

        Car car = new Car();
        car.setId(1L);
        car.setAvailable(true);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(carRepository.findById(1L)).thenReturn(Optional.of(car));
        when(bookingRepository.save(any(Booking.class))).thenAnswer(i -> i.getArguments()[0]);

        Booking result = bookingService.createBooking(1L, 1L);

        assertNotNull(result);
        assertFalse(car.isAvailable());
        verify(bookingRepository, times(1)).save(any());
    }

    @Test
    void createBooking_Fail_WhenCarBusy() {
        Car busyCar = new Car();
        busyCar.setId(2L);
        busyCar.setAvailable(false);

        when(carRepository.findById(2L)).thenReturn(Optional.of(busyCar));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            bookingService.createBooking(1L, 2L);
        });

        assertEquals("Машина уже занята!", exception.getMessage());

        verify(bookingRepository, never()).save(any());
    }
}