package com.bookmystayapp.main;

import java.util.Collection;
import java.util.Scanner;

import com.bookmystayapp.exception.AuthException;
import com.bookmystayapp.exception.InventoryException;
import com.bookmystayapp.hotel.HotelGuest;
import com.bookmystayapp.hotel.HotelAdmin;
import com.bookmystayapp.model.Role;
import com.bookmystayapp.model.RoomType;
import com.bookmystayapp.model.User;
import com.bookmystayapp.repository.InventoryRepository;
import com.bookmystayapp.repository.UserRepository;
import com.bookmystayapp.service.AuthService;
import com.bookmystayapp.service.InventoryService;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Initialize repositories
        UserRepository userRepository = new UserRepository();
        InventoryRepository inventoryRepository = new InventoryRepository();

        // Initialize services
        AuthService authService = new AuthService(userRepository);
        InventoryService inventoryService = new InventoryService(inventoryRepository);

        // Controllers
        HotelAdmin adminController = new HotelAdmin(inventoryService);
        HotelGuest guestController = new HotelGuest(inventoryService);

        while (true) {

            System.out.println("\n===== BookMyStay =====");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            try {

                switch (choice) {

                    case 1 -> login(authService, adminController, guestController);

                    case 2 -> register(authService);

                    case 3 -> {
                        System.out.println("Exiting application...");
                        return;
                    }

                    default -> System.out.println("Invalid choice");
                }

            } catch (AuthException | InventoryException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void login(AuthService authService, HotelAdmin admin, HotelGuest guest) {

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = authService.login(email, password);

        if (user.getRole() == Role.ADMIN) {
            adminMenu(admin);
        } else {
            guestMenu(guest);
        }
    }

    private static void register(AuthService authService) {

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        authService.registerUser(email, password, Role.GUEST);

        System.out.println("Registration successful.");
    }

    private static void adminMenu(HotelAdmin admin) {

        while (true) {

            System.out.println("\n===== Admin Menu =====");
            System.out.println("1. Create Room Type");
            System.out.println("2. Update Room Count");
            System.out.println("3. Update Room Price");
            System.out.println("4. Delete Room Type");
            System.out.println("5. View Inventory");
            System.out.println("6. Logout");

            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            try {

                switch (choice) {

                    case 1 -> {

                        System.out.print("Enter room type: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter price: ");
                        double price = Double.parseDouble(scanner.nextLine());

                        System.out.print("Enter room count: ");
                        int count = Integer.parseInt(scanner.nextLine());

                        admin.createRoomType(name, price, count);
                        System.out.println("Room type created.");
                    }

                    case 2 -> {

                        System.out.print("Enter room type: ");
                        String type = scanner.nextLine();

                        System.out.print("Enter new count: ");
                        int count = Integer.parseInt(scanner.nextLine());

                        admin.updateRoomCount(type, count);
                        System.out.println("Room count updated.");
                    }

                    case 3 -> {

                        System.out.print("Enter room type: ");
                        String type = scanner.nextLine();

                        System.out.print("Enter new price: ");
                        double price = Double.parseDouble(scanner.nextLine());

                        admin.updateRoomPrice(type, price);
                        System.out.println("Price updated.");
                    }

                    case 4 -> {

                        System.out.print("Enter room type to delete: ");
                        String type = scanner.nextLine();

                        admin.deleteRoomType(type);
                        System.out.println("Room type deleted.");
                    }

                    case 5 -> viewInventory(admin.viewInventory());

                    case 6 -> {
                        System.out.println("Logged out.");
                        return;
                    }

                    default -> System.out.println("Invalid choice");
                }

            } catch (InventoryException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void guestMenu(HotelGuest guest) {

        while (true) {

            System.out.println("\n===== Guest Menu =====");
            System.out.println("1. Search for Rooms");
            System.out.println("2. Logout");

            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1 -> viewInventory(guest.searchRooms());

                case 2 -> {
                    System.out.println("Logged out.");
                    return;
                }

                default -> System.out.println("Invalid choice");
            }
        }
    }

    private static void viewInventory(Collection<RoomType> rooms) {

        if (rooms.isEmpty()) {
            System.out.println("No rooms available.");
            return;
        }

        System.out.println("\n===== Room Inventory =====");

        for (RoomType room : rooms) {
            System.out.println(room);
        }
    }
}