# ToDa App 

**ToDa App** is a microservices-based backend project built using Java 17, Spring Boot 3, and Spring Cloud.
It provides a structured and secure way to manage user authentication and todo tasks in a distributed architecture.



---

##  Index

* [Getting Started](#getting-started)
* [System Architecture](#system-architecture)
* [System Features and Use Cases](#system-features-and-use-cases)
* [Screenshots](#screenshots)

---

##  Getting Started

### 1. Built With

* Java 17
* Spring Boot 3
* Spring Cloud (Gateway, Eureka, Config Server)
* Spring Security & JWT
* Spring Data JPA
* MySQL
* Swagger (OpenAPI)
* Postman
* Java Mail Sender

### 2. Prerequisites

* [Java 17+]
* [Maven]
* MySQL 
* Postman (optional for testing)
* IntelliJ IDEA (recommended)

---

##  System Architecture

This project is composed of 5 main components:

1. **Authentication Service**

   * Responsible for registration, login, password reset via OTP, and JWT token generation/validation.
   * Supports **email verification** during registration using **Java Mail Sender**.
2. **Todo Service**

   * Manages user-specific tasks with full CRUD functionality.
3. **API Gateway**

   * Routes incoming requests securely to the appropriate microservice.
4. **Eureka Server**

   * Enables dynamic service discovery between microservices.
5. **Config Server**

   * Centralized external configuration for all services.


---

##  System Features and Use Cases

###  Authentication Service

* Register new users with validation
* Email verification using Java Mail Sender
* Login with email and password
* Forgot password + OTP via email
* JWT Token generation and validation
* Full CRUD operations on user data

###  ToDo Service

* Create, update, delete, and view todo items
* Search for tasks by title or status
* All endpoints secured with JWT and validated through Auth Service

###  Gateway & Discovery

* All API traffic flows through the Gateway
* Eureka handles dynamic discovery and load balancing
* Config Server provides centralized management of properties

---

##  Screenshots

### Swagger - ToDo Service

![Swagger Todo Service](https://github.com/AmrElhady11/Toda-App/blob/main/assests/screenshot1.jpeg)

### Swagger - Authentication Service

![Swagger Auth Service](https://github.com/AmrElhady11/Toda-App/blob/main/assests/screenShot2.jpeg)


---

##  Feedback & Contributions

Feel free to open issues or submit pull requests.
Feedback and suggestions are always welcome!

---
