package com.paul.carsharing.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

    @Entity                  // Говорит Спрингу: "Это таблица в БД"
    @Table(name = "cars")    // Имя таблицы будет "cars"
    @Data                    // Lombok: генерирует геттеры, сеттеры, toString
    @NoArgsConstructor       // Lombok: пустой конструктор (нужен Hibernate)
    public class Car {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) // ID будет расти сам (1, 2, 3...)
        private Long id;

        @Column(nullable = false) // Не может быть пустым
        private String brand;

        @Column(nullable = false)
        private String model;

        @Column(nullable = false)
        private BigDecimal pricePerDay;

        private boolean isAvailable = true; // По умолчанию машина свободна
    }
