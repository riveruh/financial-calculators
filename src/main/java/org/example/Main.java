package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to my financial calculators!");
        System.out.println("Choose a calculator:");
        System.out.println("1. Mortgage calculator");
        System.out.println("2. CD future value calculator");
        System.out.println("3. Annuity calculator");
        System.out.println("Enter 1, 2, or 3:");

        int calculatorChoice = scanner.nextInt();
        if (calculatorChoice == 1) {
            System.out.println("Enter your loan amount:");
            double principal = scanner.nextDouble();
            System.out.println("Enter the annual interest rate:");
            double annualInterestRate = scanner.nextDouble();
            System.out.println("Enter your loan length in years:");
            int loanYears = scanner.nextInt();
            double monthlyRate = annualInterestRate / 12 / 100;
            int numberOfPayments = loanYears * 12;
            double rateFactor = Math.pow(1 + monthlyRate, numberOfPayments);
            double monthlyPayment = (principal * monthlyRate * rateFactor) / (rateFactor - 1);
            double totalInterest = (monthlyPayment * numberOfPayments) - principal;
            System.out.println("Monthly payment: $" + monthlyPayment);
            System.out.println("Total interest paid: $" + totalInterest);

        } else if (calculatorChoice == 2) {
            System.out.println("Enter the initial deposit:");
                double principal = scanner.nextDouble();
            System.out.println("Enter the annual interest rate:");
            double annualInterestRate = scanner.nextDouble();
            System.out.println("Enter the number of years:");
            int years = scanner.nextInt();
            double dailyRate = annualInterestRate / 365;
            double growthFactor = Math.pow(1 + dailyRate, 365 * years);
            double futureValue = principal * growthFactor;
            double interestEarned = futureValue - principal;

            System.out.println("Future value: $" + futureValue);
            System.out.println("Total interest earned: $" + interestEarned);

        } else if (calculatorChoice == 3) {
            System.out.println("Enter the monthly payout amount:");
            double monthlyPayout = scanner.nextDouble();
            System.out.println("Enter the annual interest rate:");
            double annualInterestRate = scanner.nextDouble();
            System.out.println("Enter the number of years for the payout:");
            int payoutYears = scanner.nextInt();
            double monthlyRate = annualInterestRate / 12 / 100;
            int numberOfPayments = payoutYears * 12;
            double discountFactor = Math.pow(1 + monthlyRate, -numberOfPayments);
            double presentValue = monthlyPayout * ((1 - discountFactor) / monthlyRate);
            System.out.println("Present value of the annuity: $" + presentValue);
        }
            }
        }