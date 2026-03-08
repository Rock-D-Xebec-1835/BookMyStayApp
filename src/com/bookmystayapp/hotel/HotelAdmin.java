package com.bookmystayapp.hotel;
import com.bookmystayapp.service.*;
import com.bookmystayapp.model.*;
import java.util.Collection;

public class HotelAdmin {

    private InventoryService inventoryService;

    public HotelAdmin(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public void createRoomType(String name, double price, int count) {
        inventoryService.createRoomType(name, price, count);
    }

    public void updateRoomCount(String type, int newCount) {
        inventoryService.updateRoomCount(type, newCount);
    }

    public void updateRoomPrice(String type, double price) {
        inventoryService.updateRoomPrice(type, price);
    }

    public void deleteRoomType(String type) {
        inventoryService.deleteRoomType(type);
    }

    public Collection<RoomType> viewInventory() {
        return inventoryService.getAllRoomInventory();
    }
}
