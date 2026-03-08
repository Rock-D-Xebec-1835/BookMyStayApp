package com.bookmystayapp.hotel;

import java.util.Collection;
import java.util.List;

import com.bookmystayapp.exception.*;
import com.bookmystayapp.model.*;
import com.bookmystayapp.service.*;

public class HotelGuest {
	private InventoryService inventoryService;
	private BookingQueueService bookingQueueService;
	private ServiceManagementService serviceManagementService;
	
	public HotelGuest(InventoryService inventoryService, BookingQueueService bookingQueueService, ServiceManagementService serviceManagementService) {
		this.inventoryService = inventoryService;
		this.bookingQueueService = bookingQueueService;
		this.serviceManagementService = serviceManagementService;
	}
	
	public List<RoomType> searchRooms() {
        return inventoryService.searchRooms();
    }
	
	public void requestBooking(String email, String roomType, int quantity) {
	    String reservationId = "RES" + System.currentTimeMillis();
	    Reservation reservation = new Reservation(reservationId, email, roomType, quantity);
	    bookingQueueService.submitBookingRequest(reservation);
	    System.out.println("Booking request submitted. Reservation ID: " + reservationId);
	}
	
	public void addService(String reservationId, Service service) {
	    serviceManagementService.addServiceToReservation(reservationId, service);
	}
	
	public Collection<Reservation> viewMyReservations(String email) {
	    return bookingQueueService.getReservationsByUser(email);
	}
	
	public List<Service> getServices(String reservationId) {
	    return serviceManagementService.getServicesForReservation(reservationId);
	}
}
