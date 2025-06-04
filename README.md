# Toda App 

## 🧩 Overview

Toda App is a backend microservices-based system built with Spring Boot and MySQL. It is divided into two main services:

1. **Auth Service** – Handles user authentication, registration, and token issuance using JWT.
2. **Todo Service** – Provides task management features (CRUD operations) for authenticated users.

Both services communicate securely, allowing token validation through inter-service HTTP calls.

---

## 📂 Project Structure

toda-app/
├── auth-service/       # Authentication microservice (JWT-based)
├── todo-service/       # Task management microservice (To-Do)
└── README.md           # Project documentation

---

## 🛠️ Technologies Used

- Java 17+
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- MySQL
- Spring Web
- Spring Data JPA
- RESTful APIs

---

## 🔐 Auth Service

### Features

- User registration and login
- JWT generation and validation
- Exposes an endpoint to verify and extract claims from JWT tokens (used by the Todo service)


## 📋 Todo Service

### Features

- CRUD operations for personal to-do tasks
- Protected endpoints with JWT
- Uses `JwtFilter` to intercept requests and validate tokens by calling Auth Service


---

## 🔄 Service Communication

- The **Todo Service** uses a **JWT filter** to intercept incoming requests.
- It sends the token to Auth Service endpoint.
- If the token is valid, the Auth Service returns user information, and the request is allowed to proceed.

---

📚 API Documentation
Swagger UI is available for both services:

Auth Service: http://localhost:8080/swagger-ui/index.html

Todo Service: http://localhost:7070/swagger-ui/index.html

🧪 Future Enhancements

API Gateway integration

Social login (OAuth2) using:
  - Google
  - Facebook
  - GitHub
  - Twitter
    
Unit & integration tests

👨‍💻 Author
Developed by Amr Elhady – Java Backend Engineer



