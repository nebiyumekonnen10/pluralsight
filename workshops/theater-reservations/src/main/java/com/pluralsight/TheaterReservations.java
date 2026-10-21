package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TheaterReservations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your name: ");
        String fullName = scanner.nextLine().trim();


        System.out.print("What date will you be coming (MM/dd/yyyy): ");
        String dateInput = scanner.nextLine().trim();


        System.out.print("How many tickets would you like? ");
        int numberOfTickets = scanner.nextInt();


        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate showDate = LocalDate.parse(dateInput, inputFormatter);


        String[] nameParts = fullName.split(" ");
        String firstName = "";
        String lastName = "";

        if (nameParts.length == 1) {
            firstName = nameParts[0];
            lastName = "";
        } else {
            firstName = nameParts[0];
            lastName = nameParts[nameParts.length - 1];
        }


        String ticketWord = (numberOfTickets == 1) ? "ticket" : "tickets";

        System.out.println(numberOfTickets + " " + ticketWord + " reserved for " + showDate + " under " + lastName + ", " + firstName);

        scanner.close();
    }
}