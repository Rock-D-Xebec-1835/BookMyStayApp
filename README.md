# Use Case 1: Room Inventory Setup & Management

## Overview

This use case implements the core inventory management system for the BookMyStay application. It allows the hotel administrator to define and manage room types, their pricing, and available counts.

The system maintains a centralized inventory using efficient in-memory data structures to enable fast lookups and updates.

---

## Key Concepts

* Centralized inventory management
* Fast lookup using HashMap
* Data consistency
* Dynamic inventory updates

---

## Data Structures Used

```
HashMap<String, RoomType>
```

Where:

* **Key** → Room Type (Single, Double, Suite)
* **Value** → RoomType object containing

  * room type name
  * price per night
  * available room count

This enables **O(1)** access time for inventory operations.

---

## Actors

* Hotel Admin
* Inventory Service

---

## Functional Requirements

The system must support:

1. Creating new room types
2. Updating room count
3. Updating room price
4. Deleting room types
5. Viewing complete inventory

---

## Workflow

```
Admin action
      ↓
InventoryService
      ↓
InventoryRepository
      ↓
HashMap Inventory
```

Example Flow:

```
Create Room Type
      ↓
Store in HashMap
      ↓
Inventory updated
```

---

## Core Components

### RoomType

Represents a type of room in the hotel.

Attributes:

* room type
* price
* available room count

---

### InventoryRepository

Responsible for storing and retrieving room inventory.

Responsibilities:

* store room types
* update counts
* update pricing
* retrieve inventory

---

### InventoryService

Handles business logic for inventory operations.

Responsibilities:

* validation
* updating room counts
* updating pricing
* maintaining consistency

---

### HotelAdmin

Controller layer that exposes admin operations to the application interface.

---

## Benefits

* Fast inventory lookup
* Centralized data source
* Simple and scalable architecture
* Clear separation between service and repository layers

---

## Limitations of Previous Approach

Traditional hotel systems used manual registers which caused:

* inconsistent counts
* overbooking
* delayed updates

This implementation removes those problems using centralized inventory storage.

---

## Outcome

This use case establishes the **foundation for the entire booking system**, enabling future features like:

* room search
* reservation management
* service attachments
* reporting
