# **Train Booking System**

**Description**
The Train Booking System is a Java-based application designed to manage train reservations. The project provides features like user registration, train search, ticket booking, and cancellation. With a modular and object-oriented design, it ensures scalability, maintainability, and efficient performance.

**Features**
User Registration and Login:

New users can register with their details.
Existing users can log in and access their accounts.
Train Search:

Search for trains by route, train number, or schedule.
Ticket Booking:

Book tickets for available trains with real-time seat availability updates.
Ticket Cancellation:

Cancel booked tickets and update availability.
Admin Functions:

Manage train schedules, add/remove trains, and view bookings.

**Project Structure**
**Main Classes**
User:
Handles user registration, login, and profile management.

Train:
Manages train information, including routes, schedules, and seat availability.

Booking:
Handles ticket booking and cancellation processes.

Admin:
Includes functionality for administrators to manage trains and monitor bookings.

Main:
The entry point of the application; integrates all modules and manages user interactions.

**Supporting Files**
DataStorage.java: Simulates data persistence for trains, users, and bookings.
Utils.java: Contains utility methods for date and input validation.

**Technologies Used**
Java: Core programming language.
Object-Oriented Programming: Ensures a modular and scalable codebase.
Data Persistence: Simulated through in-memory storage for rapid prototyping.

**How to Run**
Clone this repository:
`git clone https://github.com/Aman-Prakash-19/TrainBooking.git
cd TrainBooking`

Compile the project:
`javac *.java`

Run the application:
`java Main`
