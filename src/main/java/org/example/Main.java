package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menu: let the user pick which calculator they want to run!
        System.out.println("Welcome to my financial calculators!");
        System.out.println("Choose a calculator:");
        System.out.println("1. Mortgage calculator");
        System.out.println("2. CD future value calculator");
        System.out.println("3. Annuity calculator");
        System.out.println("Enter 1, 2, or 3:");

        int calculatorChoice = scanner.nextInt();

        if (calculatorChoice == 1) {
            // This is my mortgage calculator: monthly payment and total interest
            System.out.println("Enter your loan amount:");
            double principal = scanner.nextDouble();
            System.out.println("Enter the annual interest rate as a percent (for example 7.625):");
            double annualInterestRate = scanner.nextDouble();
            System.out.println("Enter your loan length in years:");
            int loanYears = scanner.nextInt();
            // Convert the percent to a monthly decimal rate
            double monthlyRate = annualInterestRate / 12 / 100;
            int numberOfPayments = loanYears * 12;
            double rateFactor = Math.pow(1 + monthlyRate, numberOfPayments);
            double monthlyPayment = (principal * monthlyRate * rateFactor) / (rateFactor - 1);
            double totalInterest = (monthlyPayment * numberOfPayments) - principal;
            System.out.printf("Monthly payment: $%,.2f%n", monthlyPayment);
            System.out.printf("Total interest paid: $%,.2f%n", totalInterest);

        } else if (calculatorChoice == 2) {
            // CD calculator: future value with daily compounding
            System.out.println("Enter the initial deposit:");
                double principal = scanner.nextDouble();
            System.out.println("Enter the annual interest rate as a percent (for example 1.75):");
            double annualInterestRate = scanner.nextDouble();
            System.out.println("Enter the number of years:");
            int years = scanner.nextInt();

            // Convert the percent to a decimal then to a daily rate
            double dailyRate = annualInterestRate / 100 / 365;
            // FV = P * (1 + r/d)^(d * t)
            double growthFactor = Math.pow(1 + dailyRate, 365 * years);
            double futureValue = principal * growthFactor;
            double interestEarned = futureValue - principal;

            System.out.printf("Future value: $%,.2f%n", futureValue);
            System.out.printf("Total interest earned: $%,.2f%n", interestEarned);

        } else if (calculatorChoice == 3) {
            // Annuity calculator: present value of an ordinary annuity
            System.out.println("Enter the monthly payout amount:");
            double monthlyPayout = scanner.nextDouble();
            System.out.println("Enter the annual interest rate as a percent (for example 2.5):");
            double annualInterestRate = scanner.nextDouble();
            System.out.println("Enter the number of years for the payout:");
            int payoutYears = scanner.nextInt();
            double monthlyRate = annualInterestRate / 12 / 100;
            int numberOfPayments = payoutYears * 12;
            // PV = payout * (1 - (1 + i)^-n) / i
            double discountFactor = Math.pow(1 + monthlyRate, -numberOfPayments);
            double presentValue = monthlyPayout * ((1 - discountFactor) / monthlyRate);
            System.out.printf("The present value of the annuity: $%,.2f%n", presentValue);

        } else {
            System.out.println("There's only 3 calculators. Please run the program again and enter 1, 2, or 3 to use any of those 3.");
        }

        scanner.close();
    }
}