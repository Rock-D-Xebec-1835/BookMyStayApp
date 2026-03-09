# Use Case 2: Room Search & Availability Check

## Overview

This use case introduces the ability for guests to search for available room types without modifying the hotel inventory.

Guests can view room types that currently have available rooms, along with their pricing details.

---

## Key Concepts

* Read-only access
* Availability filtering
* Defensive validation
* Fast lookup using HashMap

---

## Data Structures Used

```
HashMap<String, RoomType>
```

The same inventory structure from Use Case 1 is used, but only **read operations** are performed.

---

## Actors

* Guest
* Search Service

---

## Functional Requirements

Guests should be able to:

1. View available room types
2. View room pricing
3. Prevent booking unavailable rooms

---

## Workflow

```
Guest search request
      ↓
InventoryService
      ↓
HashMap lookup
      ↓
Filter available rooms
      ↓
Display results
```

---

## Core Components

### HotelGuest

Provides guest-level access to room search functionality.

---

### InventoryService

Provides read-only methods to retrieve available room types.

Example logic:

```
if(room.getAvailableRooms() > 0)
    include in search results
```

---

## Example Output

```
Available Rooms

Single   | Price: 2000 | Available: 5
Double   | Price: 3500 | Available: 3
```

Rooms with zero availability are excluded.

---

## Benefits

* Fast search performance
* Read-only inventory access
* Prevents inconsistent booking attempts
* Maintains inventory integrity

---

## Limitations of Previous Approach

Without proper filtering:

* users could attempt to book unavailable rooms
* booking conflicts could occur

This use case ensures that only **valid inventory is visible to guests**.

---

## Outcome

This feature provides the **search capability required before implementing reservations** and forms the basis for the booking system in later use cases.
