package com.bookmystayapp.hotel;

import java.util.Collection;

import com.bookmystayapp.exception.InventoryException;
import com.bookmystayapp.model.RoomType;
import com.bookmystayapp.service.InventoryService;

public class HotelGuest {
	private InventoryService inventoryService;
	
	public HotelGuest(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
	
	public Collection<RoomType> viewInventory(){
		return inventoryService.getAllRoomInventory();
	}
}
