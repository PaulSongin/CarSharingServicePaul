package com.paul.carsharing.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

    @Entity                  
    @Table(name = "cars")    
    @Data                    
    @NoArgsConstructor     
    public class Car {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) 
        private Long id;

        @Column(nullable = false) 
        private String brand;

        @Column(nullable = false)
        private String model;

        @Column(nullable = false)
        private BigDecimal pricePerDay;

        private boolean isAvailable = true; // По умолчанию машина свободна
    }
