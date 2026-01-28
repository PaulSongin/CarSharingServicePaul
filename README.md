# 🚗 Car Sharing Service API

A RESTful API for a car rental system.
This pet project demonstrates backend development skills using **Spring Boot 3**, **PostgreSQL**, and **Hibernate**.

## 🛠 Tech Stack
*   **Java 17+**
*   **Spring Boot 3** (Web, Data JPA, Validation)
*   **PostgreSQL** (Relational Database)
*   **Hibernate** (ORM)
*   **Lombok** (Boilerplate code reduction)
*   **Swagger / OpenAPI** (API Documentation)
*   **Docker** (Containerization)

## 🚀 Key Features
1.  **Car Management:**
    *   Add new vehicles to the fleet.
    *   View available cars.
    *   Automatic status tracking (Available / Booked).
2.  **Booking System:**
    *   Book a car with availability validation.
    *   **Transactional integrity:** Prevents double-booking (race conditions).
    *   Automatic status updates for cars upon reservation.
3.  **User Management:**
    *   Basic user registration and data handling.

## 📄 API Documentation
Once the application is running, you can access the interactive Swagger UI documentation here:
👉 `http://localhost:8080/swagger-ui/index.html`

## ⚙️ How to Run

### 1. Clone the repository
```bash
git clone https://github.com/PaulSongin/CarSharingServicePaul.git