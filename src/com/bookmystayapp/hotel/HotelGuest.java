package com.bookmystayapp.hotel;

import java.util.Collection;
import java.util.List;

import com.bookmystayapp.exception.*;
import com.bookmystayapp.model.*;
import com.bookmystayapp.service.*;

public class HotelGuest {
	private InventoryService inventoryService;
	private BookingQueueService bookingQueueService;
	
	public HotelGuest(InventoryService inventoryService, BookingQueueService bookingQueueService) {
		this.inventoryService = inventoryService;
		this.bookingQueueService = bookingQueueService;
	}
	
	public List<RoomType> searchRooms() {
        return inventoryService.searchRooms();
    }
	
	public void requestBooking(String email, String roomType, int quantity) {

	    Reservation reservation = new Reservation(email, roomType, quantity);

	    bookingQueueService.submitBookingRequest(reservation);
	}
}
