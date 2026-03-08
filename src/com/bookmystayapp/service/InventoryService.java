package com.bookmystayapp.service;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import com.bookmystayapp.exception.InventoryException;
import com.bookmystayapp.model.RoomType;
import com.bookmystayapp.repository.InventoryRepository;

public class InventoryService {
	private InventoryRepository inventoryRepository;
	public InventoryService(InventoryRepository inventoryRepository) {
		this.inventoryRepository = inventoryRepository;
	}
	
	public void createRoomType(String type, double price, int count) throws InventoryException{
		if(type == null || type.isBlank()) throw new InventoryException("Roomtype cannot be null");
		if(count < 0) throw new InventoryException("Room count cannot be negative");
		if(price < 0) throw new InventoryException("Price cannot be negative");
		
		if(inventoryRepository.containsRoomType(type)) throw new InventoryException("Room type already exists: " + type);
		RoomType roomType = new RoomType(type, price, count);
		inventoryRepository.addRoomType(roomType);
	}
	
	public void updateRoomCount(String type, int newCount) {
		if(type == null || type.isBlank()) throw new InventoryException("Roomtype cannot be null");
		if(newCount < 0) throw new InventoryException("Room count cannot be negative");
		if(!inventoryRepository.containsRoomType(type)) throw new InventoryException("Room type not found: " + type);
		inventoryRepository.updateRoomCount(type, newCount);
	}
	
	public void increaseRoomCount(String type, int rooms) {
		if(type == null || type.isBlank()) throw new InventoryException("Roomtype cannot be null");
		if(rooms < 0) throw new InventoryException("Room count cannot be negative");
		if(!inventoryRepository.containsRoomType(type)) throw new InventoryException("Room type not found: " + type);
		int existing = inventoryRepository.getRoomType(type).getAvailableRooms();
		inventoryRepository.updateRoomCount(type, existing + rooms);
	}
	
	public void decreaseRoomCount(String type, int rooms) {
		if(type == null || type.isBlank()) throw new InventoryException("Roomtype cannot be null");
		if(rooms < 0) throw new InventoryException("Room count cannot be negative");
		if(!inventoryRepository.containsRoomType(type)) throw new InventoryException("Room type not found" + type);
		int existing = inventoryRepository.getRoomType(type).getAvailableRooms();
		if(existing - rooms < 0) throw new InventoryException("Room count cannot be negative");
		inventoryRepository.updateRoomCount(type, existing - rooms);
	}
	
	public void updateRoomPrice(String type, double price) {
		if(type == null || type.isBlank()) throw new InventoryException("Roomtype cannot be null");
		if(price < 0) throw new InventoryException("Room price cannot be null");
		inventoryRepository.updateRoomPrice(type, price);
	}
	
	public void deleteRoomType(String type) {
		if(type == null || type.isBlank()) throw new InventoryException("Room type cannot be null");
		inventoryRepository.removeRoomType(type);
	}
	
	public int getRoomAvailability(String type) {
		if(type == null || type.isBlank()) throw new InventoryException("Roomtype cannot be null");
		return inventoryRepository.getRoomAvailability(type);
	}
	
	public Collection<RoomType> getAllRoomInventory(){
		return inventoryRepository.getAllRoomInventory();
	}
	
	public List<RoomType> searchRooms() {

	    Collection<RoomType> rooms = inventoryRepository.getAllRoomInventory();

	    List<RoomType> availableRooms = new ArrayList<>();

	    for(RoomType room : rooms) {
	        if(room.getAvailableRooms() > 0) {
	            availableRooms.add(room);
	        }
	    }

	    return availableRooms;
	}
}
