package com.bookmystayapp.model;

public class Reservation {
	private String guestEmail;
	private String roomType;
	private int noOfRooms;

	public Reservation(String guestEmail, String roomType, int noOfRooms) {
		this.guestEmail = guestEmail;
		this.roomType = roomType;
		this.noOfRooms = noOfRooms;
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
	
	@Override
	public String toString() {
		return "Reservation Request -> Guest: " + guestEmail + 
				", Room: " + roomType + ", Quantity: " + noOfRooms;
	}
}
