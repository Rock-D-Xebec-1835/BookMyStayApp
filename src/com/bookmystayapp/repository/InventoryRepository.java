package com.bookmystayapp.repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.Collection;

import com.bookmystayapp.exception.InventoryException;
import com.bookmystayapp.model.RoomType;

public class InventoryRepository {
	
	private HashMap<String, RoomType> roomInventory;
	private HashMap<String, Set<String>> assignedRooms;
	private Set<String> bookedRoomIds;
	
	public InventoryRepository() {
		this.roomInventory = new HashMap<String, RoomType>();
		this.assignedRooms = new HashMap<String, Set<String>>();
		this.bookedRoomIds = new HashSet<String>();
	}
	
	public void addRoomType(RoomType roomtype) throws InventoryException {
		if(roomtype == null) throw new InventoryException("Room type cannot be null");
		roomInventory.put(roomtype.getType(), roomtype);
		assignedRooms.put(roomtype.getType(), new HashSet<String>());
	}
	
	public RoomType getRoomType(String type) throws InventoryException{
		if(type == null || type.isBlank()) throw new InventoryException("type cannot be null");
		RoomType roomType = Optional.ofNullable(roomInventory.get(type)).orElseThrow(() -> new InventoryException("Room type not found" + type));
		return roomType;
	}
	
	public boolean containsRoomType(String roomtype) throws InventoryException{
		if(roomtype == null || roomtype.isBlank()) throw new InventoryException("Room type cannot be null");
		return roomInventory.containsKey(roomtype);
	}
	
	public void updateRoomType(RoomType roomType) throws InventoryException{
		if(roomType == null) throw new InventoryException("Roomtype cannot be null");
		String type = roomType.getType();
		if(!roomInventory.containsKey(type)) throw new InventoryException("Room type not found");
		roomInventory.put(type, roomType);
	}
	
	public void removeRoomType(String type) throws InventoryException{
		if(type == null || type.isBlank()) throw new InventoryException("Room type cannot be null");
		if(!roomInventory.containsKey(type)) throw new InventoryException("Room type not found");
		roomInventory.remove(type);
	}
	
	public void updateRoomCount(String type, int newCount) {
		if(type == null || type.isBlank()) throw new InventoryException("Room type cannot be null");
		RoomType roomType = roomInventory.get(type);
		if(roomType == null) throw new InventoryException("Room type not found");
		roomType.setAvailableRooms(newCount);
		}
	
	public void updateRoomPrice(String type, double price) {
		if(type == null || type.isBlank()) throw new InventoryException("Room type cannot be null");
		RoomType roomType = roomInventory.get(type);
		if(roomType == null) throw new InventoryException("Room type not found");
		roomType.setPrice(price);
	}
	
	public int getRoomAvailability(String type) {
		if(type == null || type.isBlank()) throw new InventoryException("Room type cannot be null");
		if(!containsRoomType(type)) throw new InventoryException("Room type not found");
		return roomInventory.get(type).getAvailableRooms();
	}
	
	public Collection<RoomType> getAllRoomInventory(){
		return roomInventory.values();
	}
	
	public String generateRoomId(String roomType, int number) {
		return roomType.substring(0,2).toUpperCase() + number;
	}
	
	public Set<String> getAssignedRooms(String type){
		if(type == null || type.isBlank()) throw new InventoryException("Room type cannot be null");
		if(!assignedRooms.containsKey(type)) throw new InventoryException("Room type not found");
		return assignedRooms.get(type);
	}
	
	public boolean isRoomBooked(String roomId) {
		return bookedRoomIds.contains(roomId);
	}
	
	public void addBookedRoom(String roomId) {
		if(roomId == null || roomId.isBlank()) throw new InventoryException("Room Id cannot be null");
		bookedRoomIds.add(roomId);
	}
	
}
