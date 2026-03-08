package com.bookmystayapp.service;
import com.bookmystayapp.model.*;
import com.bookmystayapp.exception.*;
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
    private List<Reservation> bookingHistory;
    private int totalBookings;
    private int totalCancellations;
    private int totalRoomsBooked;

    public BookingQueueService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
        this.bookingQueue = new LinkedList<>();
        this.bookingHistory = new ArrayList<Reservation>();
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
        		bookingHistory.add(reservation);
        		totalBookings++;
        		totalRoomsBooked += reservation.getNoOfRooms();
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
    
    public List<Reservation> getReservationsByUser(String email) {
        List<Reservation> result = new ArrayList<>();
        for(Reservation r : bookingHistory) {
            if(r.getGuestEmail().equals(email)) {
                result.add(r);
            }
        }
        return result;
    }
    
    public List<Reservation> getBookingHistory() {
        return bookingHistory;
    }
    
    public void cancelReservation(String reservationId) {
        Reservation reservation = confirmedReservations.get(reservationId);
        if(reservation == null) throw new InventoryException("Reservation not found");
        inventoryService.increaseRoomCount(reservation.getRoomType(), reservation.getNoOfRooms());
        confirmedReservations.remove(reservationId);
        totalCancellations++;
        System.out.println("Reservation cancelled successfully.");
    }
    
    public void generateReport() {

        System.out.println("\n===== HOTEL BOOKING REPORT =====");

        if(bookingHistory.isEmpty()) {
            System.out.println("No bookings yet.");
            return;
        }

        System.out.println("\n--- Reservation Details ---");

        for(Reservation r : bookingHistory) {

            System.out.println(
                    r.getReservationId()
                    + " | "
                    + r.getGuestEmail()
                    + " | "
                    + r.getRoomType()
                    + " | Rooms: "
                    + r.getAssignedRooms()
            );
        }

        System.out.println("\n--- Summary ---");

        System.out.println("Total Reservations : " + bookingHistory.size());
        System.out.println("Total Bookings     : " + totalBookings);
        System.out.println("Total Cancellations: " + totalCancellations);
        System.out.println("Total Rooms Booked : " + totalRoomsBooked);
    }
    
}