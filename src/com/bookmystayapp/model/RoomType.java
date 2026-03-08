package com.bookmystayapp.model;

public class RoomType {
	private final String type;
	private double price;
	private int availableRooms;
	
	public RoomType(String type, double price, int availableRooms) {
		this.type = type;
		this.price = price;
		this.availableRooms = availableRooms;
	}

	public String getType() {
		return type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailableRooms() {
		return availableRooms;
	}

	public void setAvailableRooms(int availableRooms) {
		this.availableRooms = availableRooms;
	}
	
	@Override
	public String toString() {
	    return String.format(
	        "Room Type: %-10s | Price: %-8.2f | Available: %d",
	        type,
	        price,
	        availableRooms
	    );
	}

}
