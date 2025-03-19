# 🚆 TrainBooking - Spring Boot Project

Simple Train Ticket Booking System using Spring Boot and Java. This project demonstrates how to build REST APIs for ticket management.

## ✨ Features
- Book train tickets (default London → France, fixed price & seat auto-assigned)
- View booking receipt by user email
- List users by seat section (A/B)
- Modify a user's seat
- Delete a user's ticket

## ⚙ Technologies Used
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
```
| Method | Endpoint               | Description               |
|--------|------------------------|---------------------------|
| POST   | /api/purchaseTicket    | Book a new ticket         |
| GET    | /api/receipt?email=... | Get ticket by user email  |
| GET    | /api/users?section=A   | Get users by seat section |
| PUT    | /api/modifySeat        | Change a user’s seat      |
| DELETE | /api/removeUser        | Remove a user's ticket    |
```

## 🧪 Run Tests
```
mvn test
```
