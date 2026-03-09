# Use Case 4: Reservation Confirmation & Room Allocation

## Overview

This use case assigns unique room identifiers to confirmed reservations and ensures that no room can be allocated more than once.

---

## Key Concepts

* Unique identifier enforcement
* Duplicate prevention
* Atomic allocation
* Room identity tracking

---

## Data Structures Used

```
Set<String> bookedRoomIds
HashMap<String, Set<String>> assignedRooms
```

Structure:

```
RoomType → Assigned Room IDs
```

Example:

```
Single → {SI1, SI2}
Double → {DO1}
```

---

## Actors

* Booking Service
* Inventory Service

---

## Functional Requirements

The system must:

1. Assign unique room IDs
2. Prevent reuse of room IDs
3. Track assigned rooms per reservation
4. Update inventory immediately

---

## Workflow

```
Dequeue reservation
      ↓
Allocate room IDs
      ↓
Store in HashSet
      ↓
Update inventory
```

---

## Benefits

* Prevents double booking
* Maintains strong data integrity
* Enables accurate reservation tracking

---

## Outcome

The system now guarantees **conflict-free room allocation**.
