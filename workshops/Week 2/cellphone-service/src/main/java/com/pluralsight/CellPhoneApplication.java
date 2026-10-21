package com.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // =====================================================================
        // EXERCISE 1: Page 41
        // =====================================================================
        System.out.println("=== EXERCISE 1 ===");
        CellPhone cellPhone1 = new CellPhone();

        System.out.print("What is the serial number? ");
        int serialNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.print("What model is the phone? ");
        String model = scanner.nextLine();

        System.out.print("Who is the carrier? ");
        String carrier = scanner.nextLine();

        System.out.print("What is the phone number? ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Who is the owner of the phone? ");
        String owner = scanner.nextLine();

        cellPhone1.setSerialNumber(serialNumber);
        cellPhone1.setModel(model);
        cellPhone1.setCarrier(carrier);
        cellPhone1.setPhoneNumber(phoneNumber);
        cellPhone1.setOwner(owner);


        // =====================================================================
        // EXERCISE 2: Page 48
        // =====================================================================
        System.out.println("\n=== EXERCISE 2 ===");
        CellPhone cellPhone2 = new CellPhone();
        cellPhone2.setSerialNumber(2597154);
        cellPhone2.setModel("iPhone 15 Pro Max");
        cellPhone2.setCarrier("Verizon");
        cellPhone2.setPhoneNumber("888-555-1234");
        cellPhone2.setOwner("Sandra");


        display(cellPhone1);
        display(cellPhone2);


        System.out.println("\n-- Dialing Tests (Exercise 2) --");
        cellPhone1.dial(cellPhone2.getPhoneNumber());
        cellPhone2.dial(cellPhone1.getPhoneNumber());


        // =====================================================================
        // EXERCISE 3: Page 56
        // =====================================================================
        System.out.println("\n=== EXERCISE 3 ===");

        CellPhone cellPhone3 = new CellPhone(3984712, "Galaxy S24", "T-Mobile", "555-987-6543", "Marcus");


        display(cellPhone3);


        System.out.println("\n-- Dialing Tests (Exercise 3) --");
        cellPhone3.dial(cellPhone1.getPhoneNumber());
        cellPhone3.dial(cellPhone2);

        scanner.close();
    }


    public static void display(CellPhone phone) {
        System.out.println("\n--- Cell Phone Details ---");
        System.out.println("Owner        : " + phone.getOwner());
        System.out.println("Serial Number: " + phone.getSerialNumber());
        System.out.println("Model        : " + phone.getModel());
        System.out.println("Carrier      : " + phone.getCarrier());
        System.out.println("Phone Number : " + phone.getPhoneNumber());
    }
}