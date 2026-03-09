# BookMyStay – Hotel Booking Management System

## Overview

BookMyStay is a hotel booking management system developed as a pedagogical project to demonstrate core Java programming concepts and data structure usage in a real-world application scenario.

The system supports inventory management, room search, reservation processing, service attachment, booking history tracking, and administrative reporting.

---

## System Architecture

The application follows a layered architecture:

```
Main
 ↓
Controllers (HotelAdmin, HotelGuest)
 ↓
Services
 ↓
Repositories
 ↓
Data Structures
```

---

## Implemented Use Cases

### UC1 – Room Inventory Management

Allows administrators to create and manage room types, pricing, and availability.

### UC2 – Room Search

Allows guests to search available rooms without modifying inventory.

### UC3 – Booking Queue

Introduces FIFO-based booking requests using a queue to ensure fair allocation.

### UC4 – Room Allocation

Assigns unique room IDs to confirmed bookings and prevents duplicate allocation.

### UC5 – Add-On Services

Allows guests to attach optional services such as breakfast and spa to reservations.

### UC6 – Booking History & Reporting

Stores confirmed reservations and generates administrative booking reports.

---

## Data Structures Used

```
HashMap<String, RoomType>            → Inventory
Queue<Reservation>                   → Booking queue
HashMap<String, Set<String>>         → Room allocation
Set<String>                          → Unique room IDs
Map<String, List<Service>>           → Reservation services
List<Reservation>                    → Booking history
```

---

## Key Features

* Room inventory management
* Guest room search
* FIFO booking request handling
* Unique room allocation
* Add-on service management
* Booking history tracking
* Administrative reporting

---

## Technologies

* Java
* Core Java Collections Framework
* Object-Oriented Programming
* Layered architecture

---

## Project Structure

```
model/
repository/
service/
hotel/
exception/
main/
```

---

## Learning Outcomes

This project demonstrates:

* practical use of Java collections
* separation of concerns
* layered system design
* queue-based request handling
* reservation management workflows

---

## Future Enhancements

Potential improvements include:

* persistent database storage
* concurrent booking processing
* REST API integration
* web-based user interface
