package com.paul.carsharing.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

    @Entity                  
    @Table(name = "cars")

    public class Car {
        public Car() {
        }

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) 
        private Long id;

        @Column(nullable = false) 
        private String brand;

        @Column(nullable = false)
        private String model;

        @Column(nullable = false)
        private BigDecimal pricePerDay;

        private boolean isAvailable = true;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public BigDecimal getPricePerDay() {
            return pricePerDay;
        }

        public void setPricePerDay(BigDecimal pricePerDay) {
            this.pricePerDay = pricePerDay;
        }

        public boolean isAvailable() {
            return isAvailable;
        }

        public void setAvailable(boolean available) {
            isAvailable = available;
        }
    }
