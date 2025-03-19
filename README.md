# 🚆 TrainBooking - Spring Boot Project

Simple Train Ticket Booking System using Spring Boot and Java. This project demonstrates how to build REST APIs for ticket management.

## ✨ Features
- Book and view tickets
- Clean REST API
- Layered architecture (Controller → Service → Model)
- Basic unit testing

## ⚙ Technologies
- Java
- Spring Boot
- Maven
- JUnit

## 📁 Structure
```
src/
├── controller/
  │
  └── TicketController.java # API endpoints
├── model/
  │
  ├── Ticket.java # Ticket model
  │
  └── User.java # User model
├── service/
  │
  └── TicketService.java # Business logic
└── TrainbookingApplication.java # Main Spring Boot class
```

## ▶ Run App
```
git clone https://github.com/your-username/TrainBooking.git
cd TrainBooking
mvn spring-boot:run
```

## 📬 API Endpoints
POST /ticket/book   → Book a ticket
GET  /ticket/all    → View all tickets

## 🧪 Run Tests
```
mvn test
```

