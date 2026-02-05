package com.paul.carsharing.dto;

import java.time.LocalDateTime;

public record BookingResponseDto(
        Long id,
        LocalDateTime startTime,
        LocalDateTime endTime,
        String status,
        Long carId,
        Long userId
) {}