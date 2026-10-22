package com.pluralsight;

import java.util.Scanner;

public class VehicleInventoryApplication {

    private static Vehicle[] vehicles = new Vehicle[20];
    private static int vehicleCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        addVehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        addVehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        addVehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        addVehicle(101124, "Honda Civic", "White", 70000, 7500);
        addVehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        addVehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);

        int command = 0;


        while (command != 6) {
            System.out.println("\nWhat do you want to do?");
            System.out.println(" 1 - List all vehicles");
            System.out.println(" 2 - Search by make/model");
            System.out.println(" 3 - Search by price range");
            System.out.println(" 4 - Search by color");
            System.out.println(" 5 - Add a vehicle");
            System.out.println(" 6 - Quit");
            System.out.print("Enter your command: ");

            command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1:
                    listAllVehicles();
                    break;
                case 2:
                    findVehiclesByMakeModel();
                    break;
                case 3:
                    findVehiclesByPriceRange();
                    break;
                case 4:
                    findVehiclesByColor();
                    break;
                case 5:
                    promptAddVehicle();
                    break;
                case 6:
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid command. Please enter a number between 1 and 6.");
            }
        }
    }


    public static void addVehicle(long id, String makeModel, String color, int odometer, double price) {
        if (vehicleCount < vehicles.length) {
            vehicles[vehicleCount] = new Vehicle(id, makeModel, color, odometer, price);
            vehicleCount++;
        }
    }


    public static void listAllVehicles() {
        System.out.println("\n--- All Vehicles in Inventory ---");
        for (int i = 0; i < vehicleCount; i++) {
            printVehicle(vehicles[i]);
        }
    }


    public static void findVehiclesByMakeModel() {
        System.out.print("Enter make/model to search for (e.g., Ford Explorer): ");
        String searchMake = scanner.nextLine().toLowerCase();

        System.out.println("\n--- Search Results ---");
        boolean found = false;
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicles[i].getMakeModel().toLowerCase().contains(searchMake)) {
                printVehicle(vehicles[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles found matching that make/model.");
        }
    }


    public static void findVehiclesByPriceRange() {
        System.out.print("Enter minimum price: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double maxPrice = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("\n--- Vehicles in Price Range ---");
        boolean found = false;
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicles[i].getPrice() >= minPrice && vehicles[i].getPrice() <= maxPrice) {
                printVehicle(vehicles[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles found in that price range.");
        }
    }


    public static void findVehiclesByColor() {
        System.out.print("Enter color to search for: ");
        String searchColor = scanner.nextLine().toLowerCase();

        System.out.println("\n--- Vehicles with Color: " + searchColor + " ---");
        boolean found = false;
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicles[i].getColor().toLowerCase().equals(searchColor)) {
                printVehicle(vehicles[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles found with that color.");
        }
    }


    public static void promptAddVehicle() {
        if (vehicleCount >= vehicles.length) {
            System.out.println("Inventory is full! Cannot add more vehicles.");
            return;
        }

        System.out.print("Enter vehicle ID: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter make/model: ");
        String makeModel = scanner.nextLine();

        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        System.out.print("Enter odometer reading: ");
        int odometer = scanner.nextInt();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        addVehicle(id, makeModel, color, odometer, price);
        System.out.println("Vehicle successfully added to inventory!");
    }


    public static void printVehicle(Vehicle v) {
        System.out.printf("ID: %d | %s | Color: %s | Odometer: %d mi | Price: $%.2f%n",
                v.getVehicleId(), v.getMakeModel(), v.getColor(), v.getOdometerReading(), v.getPrice());
    }
}