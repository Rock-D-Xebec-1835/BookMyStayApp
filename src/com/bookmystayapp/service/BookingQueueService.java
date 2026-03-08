package com.bookmystayapp.service;
import com.bookmystayapp.model.*;
import java.util.Queue;
import java.util.LinkedList;

public class BookingQueueService {

    private Queue<Reservation> bookingQueue;
    private InventoryService inventoryService;

    public BookingQueueService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
        this.bookingQueue = new LinkedList<>();
    }

    public void submitBookingRequest(Reservation reservation) {
        bookingQueue.offer(reservation);
        System.out.println("Booking request added to queue.");
    }

    public void processNextBooking() {

        if (bookingQueue.isEmpty()) {
            System.out.println("No booking requests in queue.");
            return;
        }

        Reservation reservation = bookingQueue.poll();

        try {

            inventoryService.decreaseRoomCount(
                reservation.getRoomType(),
                reservation.getNoOfRooms()
            );

            System.out.println("Booking confirmed for " + reservation.getGuestEmail());

        } catch (Exception e) {

            System.out.println("Booking failed → " + e.getMessage());
        }
    }
}