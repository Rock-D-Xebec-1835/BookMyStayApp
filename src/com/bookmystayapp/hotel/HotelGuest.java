package com.bookmystayapp.hotel;

import java.util.Collection;
import java.util.List;

import com.bookmystayapp.exception.InventoryException;
import com.bookmystayapp.model.RoomType;
import com.bookmystayapp.service.InventoryService;

public class HotelGuest {
	private InventoryService inventoryService;
	
	public HotelGuest(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
	
	public List<RoomType> searchRooms() {
        return inventoryService.searchRooms();
    }
}
