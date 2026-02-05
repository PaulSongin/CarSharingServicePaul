# 🚗 Car Sharing Service API

A professional RESTful API for a car rental system, built with **Java 21** and **Spring Boot 3.4.2**.
This project demonstrates a clean architecture, reliable data handling, and full containerization.

## 🌟 Key Features
*   **Complete Booking Flow:** Create users, add cars, and manage rentals with real-time availability tracking.
*   **Transactional Integrity:** Uses `@Transactional` to ensure data consistency during the booking process.
*   **Advanced Validation:** Input data is strictly validated using DTOs (Data Transfer Objects) and `jakarta.validation`.
*   **Global Error Handling:** Friendly and informative JSON error responses instead of standard stack traces.
*   **Unit Testing:** Core business logic is covered by tests using **JUnit 5** and **Mockito**.
*   **Full Dockerization:** Ready to run anywhere with a single command.

## 🛠 Tech Stack
*   **Language:** Java 21 (LTS)
*   **Framework:** Spring Boot 3.4.2
*   **Database:** PostgreSQL 15
*   **ORM:** Hibernate / Spring Data JPA
*   **Documentation:** Swagger UI (OpenAPI 3)
*   **Containerization:** Docker & Docker Compose
*   **Build Tool:** Maven

## 📋 Architecture
The project follows a classic three-tier architecture for better maintainability:
1.  **Controller Layer:** Handles HTTP requests and DTO mapping.
2.  **Service Layer:** Contains business logic and transactional boundaries.
3.  **Repository Layer:** Manages database interactions via JPA.

## 🚀 Getting Started

### Prerequisites
*   Docker Desktop installed and running.

### Installation & Run
1. **Clone the repository:**
   ```bash
   git clone https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git
Launch everything using Docker Compose:
code
Bash
docker-compose up --build
The app will be available at http://localhost:8080.
📄 API Documentation
Explore and test the API directly through the Swagger UI:
👉 http://localhost:8080/swagger-ui/index.html
🧪 Testing
To run the unit tests locally:
code
Bash
./mvnw test

Author: Paul Songin
Contacts:

    email: songinpavel2006@gmail.com
    Telegram: @PavlikZhid