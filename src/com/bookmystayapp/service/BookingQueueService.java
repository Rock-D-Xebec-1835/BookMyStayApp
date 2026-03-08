package com.bookmystayapp.service;
import com.bookmystayapp.model.*;
import java.util.Set;
import java.util.Queue;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class BookingQueueService {

    private Queue<Reservation> bookingQueue;
    private InventoryService inventoryService;
    private Map<String, Reservation> confirmedReservations = new HashMap<>();

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

        try{
        	Set<String> allocated =
        	    inventoryService.allocateRooms(
        	        reservation.getRoomType(),
        		    reservation.getNoOfRooms()
        		);
        	reservation.setAssignedRooms(allocated);

        		System.out.println(
        		    "Booking confirmed for "
        		    + reservation.getGuestEmail()
        		    + " Rooms: "
        		    + allocated
        		);
        		confirmedReservations.put(reservation.getReservationId(), reservation);
        } catch (Exception e) {

            System.out.println("Booking failed → " + e.getMessage());
        }
    }
    
    public Queue<Reservation> getPendingRequests(){
    	return bookingQueue;
    }
    
    public int getPendingRequestCount() {
    	return bookingQueue.size();
    }
    
    public Collection<Reservation> getReservationsByUser(String email) {

        List<Reservation> results = new ArrayList<>();

        for(Reservation r : confirmedReservations.values()) {
            if(r.getGuestEmail().equals(email)) {
                results.add(r);
            }
        }

        return results;
    }
}