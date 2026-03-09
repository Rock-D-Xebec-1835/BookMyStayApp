# Use Case 6: Booking History & Reporting

## Overview

This use case introduces booking history storage and reporting capabilities for administrative oversight and auditing.

---

## Key Concepts

* Historical data tracking
* Audit support
* Report generation

---

## Data Structures Used

```
List<Reservation>
```

This list stores confirmed reservations in chronological order.

---

## Actors

* Admin
* Reporting Service

---

## Functional Requirements

The system must:

1. Store confirmed reservations
2. Maintain booking history
3. Support reservation cancellation
4. Generate booking reports

---

## Workflow

```
Booking confirmed
      ↓
Reservation stored
      ↓
Added to booking history
      ↓
Reports generated when needed
```

---

## Benefits

* Reliable audit trail
* Improved operational visibility
* Easier customer support

---

## Outcome

The system now maintains a **complete history of hotel bookings**.
