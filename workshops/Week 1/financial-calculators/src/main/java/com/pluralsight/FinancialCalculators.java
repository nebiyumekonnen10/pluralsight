package com.pluralsight;
import java.util.*;

public class FinancialCalculators {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("**************************************************");
        System.out.println("     WELCOME TO NEBIYU'S FINANCIAL CALCULATORS     ");
        System.out.println("**************************************************");
        System.out.println("Please select a calculator from the menu:");
        System.out.println("1 - Mortgage Calculator");
        System.out.println("2 - Future Value (CD) Calculator");
        System.out.println("3 - Present Value of an Annuity Calculator");
        System.out.print("\nEnter your choice (1, 2, or 3): ");
        int command = scanner.nextInt();

        if (command == 1) {
            mortgageCalculator(scanner);
        } else if (command == 2) {
            futureValueCalculator(scanner);
        } else if (command == 3) {
            annuityCalculator(scanner);
        } else {
            System.out.printf("%d -- Invalid option!", command);
        }
    }


    public static void  mortgageCalculator(Scanner scanner) {
        System.out.print("Enter the loan principal: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter the interest rate (e.g. 7.625): ");
        double annualRate = scanner.nextDouble();

        System.out.print("Enter the loan length in years: ");
        int years = scanner.nextInt();

        double r = annualRate / 100;

        double i = r / 12;

        int n = 12 * years;
        double onePlusI = 1 + i;
        double powerPart = Math.pow(onePlusI, n);
        double topPart = i * powerPart;
        double bottomPart = powerPart - 1;
        double monthlyPayment = principal * (topPart / bottomPart);

        double totalInterest = (monthlyPayment * n) - principal;

        System.out.printf("Monthly payment: $%.2f\n", monthlyPayment);
        System.out.printf("Total interest paid: $%.2f\n", totalInterest);
    }

    public static void futureValueCalculator(Scanner scanner) {
        System.out.print("Enter the deposit amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter the interest rate (e.g. 1.75): ");
        double annualRate = scanner.nextDouble();

        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();

        double r = annualRate / 100;

        int d = 365;
        int n = d * years;

        double insideParentheses = 1 + (r / d);
        double powerPart = Math.pow(insideParentheses, n);
        double futureValue = principal * powerPart;

        double totalInterest = futureValue - principal;

        System.out.printf("Ending balance: $%.2f\n", futureValue);
        System.out.printf("Total interest earned: $%.2f\n", totalInterest);

    }

    public static void annuityCalculator(Scanner scanner) {
        System.out.print("Enter the monthly payout: ");
        double monthlyPayout = scanner.nextDouble();

        System.out.print("Enter the expected interest rate (e.g. 2.5): ");
        double annualRate = scanner.nextDouble();

        System.out.print("Enter the number of years to pay out: ");
        int years = scanner.nextInt();

        double r = annualRate / 100;
        double i = r / 12;
        int n = years * 12;

        double onePlusI = 1 + i;
        double powerPart = Math.pow(onePlusI, -n);
        double topPart = 1 - powerPart;
        double presentValue = monthlyPayout * (topPart / i);

        System.out.printf("Present value needed today: $%.2f\n", presentValue);
    }
}
