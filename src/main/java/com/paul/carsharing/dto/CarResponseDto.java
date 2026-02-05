package com.paul.carsharing.dto;

import java.math.BigDecimal;

public record CarResponseDto(
        Long id,
        String brand,
        String model,
        BigDecimal pricePerDay,
        boolean isAvailable
) {}