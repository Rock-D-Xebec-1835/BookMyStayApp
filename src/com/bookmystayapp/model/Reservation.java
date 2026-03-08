package com.bookmystayapp.model;

import java.util.HashSet;
import java.util.Set;

public class Reservation {
	private String reservationId;
	private String guestEmail;
	private String roomType;
	private int noOfRooms;
	
	private Set<String> assignedRooms;

	public Reservation(String reservationId, String guestEmail, String roomType, int noOfRooms) {
		this.reservationId = reservationId;
		this.guestEmail = guestEmail;
		this.roomType = roomType;
		this.noOfRooms = noOfRooms;
		this.assignedRooms = new HashSet<String>();
	}
	
	public String getReservationId() {
		return this.reservationId;
	}

	public String getGuestEmail() {
		return guestEmail;
	}

	public String getRoomType() {
		return roomType;
	}

	public int getNoOfRooms() {
		return noOfRooms;
	}
	
	public Set<String> getAssignedRooms() {
	    return assignedRooms;
	}
	
	public void setAssignedRooms(Set<String> rooms) {
	    this.assignedRooms = rooms;
	}
	
	@Override
	public String toString() {
		return "Reservation Request -> Guest: " + guestEmail + 
				", Room: " + roomType + ", Quantity: " + noOfRooms;
	}
}
