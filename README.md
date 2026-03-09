# Use Case 5: Add-On Service Selection

## Overview

This use case allows guests to enhance reservations with optional services such as breakfast, spa access, and airport pickup.

---

## Key Concepts

* One-to-many mapping
* Service composition
* Flexible service attachment

---

## Data Structures Used

```
Map<String, List<Service>>
```

Structure:

```
ReservationID → Services
```

Example:

```
RES1 → [Breakfast, Spa]
RES2 → [Airport Pickup]
```

---

## Actors

* Guest
* Service Management Module

---

## Functional Requirements

The system must:

1. Allow multiple services per reservation
2. Attach services to reservation IDs
3. Calculate additional service cost

---

## Workflow

```
Guest selects service
      ↓
Service added to list
      ↓
Mapped to reservation ID
```

---

## Benefits

* Flexible service attachment
* Clean mapping structure
* Easy future service expansion

---

## Outcome

Bookings now support **value-added services** beyond basic room allocation.
