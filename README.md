# Use Case 3: Booking Request (First-Come-First-Served)

## Overview

This use case introduces a queue-based booking system to ensure fair allocation of rooms during high demand.

Instead of processing bookings immediately, requests are placed in a queue and processed sequentially.

---

## Key Concepts

* FIFO processing
* Fair booking allocation
* Request buffering
* Queue-based processing

---

## Data Structures Used

```
Queue<Reservation> (LinkedList)
```

This structure ensures **First-Come-First-Served booking order**.

---

## Actors

* Guest
* Booking Queue Service

---

## Functional Requirements

The system must:

1. Accept booking requests
2. Place requests in a queue
3. Process requests sequentially
4. Prevent race conditions

---

## Workflow

```
Guest submits request
      ↓
Reservation created
      ↓
Enqueue request
      ↓
Admin processes queue
      ↓
Booking confirmed
```

---

## Core Components

### Reservation

Represents a booking request.

Attributes:

* reservation ID
* guest email
* room type
* number of rooms

---

### BookingQueueService

Manages booking request queue.

Responsibilities:

* enqueue booking requests
* dequeue requests
* process bookings
* maintain request order

---

## Example Queue

```
Queue

[Alice → Single x2]
[Bob → Double x1]
[John → Single x1]
```

Processing:

```
Alice → processed
Bob   → processed
John  → processed
```

---

## Benefits

* Fair booking system
* Eliminates race conditions
* Handles high traffic scenarios
* Predictable processing order

---

## Limitations of Previous Approach

Direct parallel booking attempts could cause:

* inconsistent inventory
* double bookings
* unfair allocation

Queue-based booking prevents these issues.

---

## Outcome

This use case introduces the **core reservation mechanism** of the application.
