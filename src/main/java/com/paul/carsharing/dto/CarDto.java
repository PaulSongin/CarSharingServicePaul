package com.paul.carsharing.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;

public record CarDto(
        @NotBlank(message = "Brand cannot be empty")
        String brand,

        @NotBlank(message = "Model cannot be empty")
        String model,

        @Min(value = 0, message = "Price must be positive")
        BigDecimal pricePerDay
) {}