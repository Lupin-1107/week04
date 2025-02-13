package com.tit.week04.Day2_Collections.BankingSystem;

import java.util.*;

class BankSystem {
    private Map<Integer, Integer> customerAccounts;  // HashMap for storing account balances
    private TreeMap<Integer, Integer> sortedCustomers; // TreeMap for sorting by balance
    private Queue<WithdrawalRequest> withdrawalQueue; // Queue to handle withdrawals

    // Inner class to store withdrawal requests
    private static class WithdrawalRequest {
        int accountNumber;
        int amount;

        WithdrawalRequest(int accountNumber, int amount) {
            this.accountNumber = accountNumber;
            this.amount = amount;
        }
    }

    // Constructor
    public BankSystem() {
        customerAccounts = new HashMap<>();
        withdrawalQueue = new LinkedList<>();

        // Custom comparator to sort TreeMap by balance
        Comparator<Integer> balanceComparator = (acc1, acc2) -> {
            int compare = customerAccounts.get(acc1).compareTo(customerAccounts.get(acc2));
            return (compare != 0) ? compare : acc1.compareTo(acc2); // Resolve tie by account number
        };

        sortedCustomers = new TreeMap<>(balanceComparator);
    }

    // Method to add a new account
    public void addAccount(int accountNumber, int balance) {
        customerAccounts.put(accountNumber, balance);
        sortedCustomers.put(accountNumber, balance);
    }

    // Method to deposit money
    public void deposit(int accountNumber, int amount) {
        if (customerAccounts.containsKey(accountNumber)) {
            int newBalance = customerAccounts.get(accountNumber) + amount;
            customerAccounts.put(accountNumber, newBalance);
            sortedCustomers.put(accountNumber, newBalance); // Update TreeMap
            System.out.println("Deposited ₹" + amount + " into Account " + accountNumber);
        } else {
            System.out.println("Account not found!");
        }
    }

    // Method to request a withdrawal with a specific amount
    public void requestWithdrawal(int accountNumber, int amount) {
        if (customerAccounts.containsKey(accountNumber)) {
            withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
            System.out.println("Withdrawal request of ₹" + amount + " added for Account " + accountNumber);
        } else {
            System.out.println("Account not found!");
        }
    }

    // Process withdrawal requests
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.poll(); // Get the first request
            int accountNumber = request.accountNumber;
            int amount = request.amount;

            if (customerAccounts.get(accountNumber) >= amount) {
                int newBalance = customerAccounts.get(accountNumber) - amount;
                customerAccounts.put(accountNumber, newBalance);
                sortedCustomers.put(accountNumber, newBalance);
                System.out.println("₹" + amount + " withdrawn from Account " + accountNumber);
            } else {
                System.out.println("Insufficient balance for Account " + accountNumber);
            }
        }
    }

    // Display accounts sorted by balance
    public void displaySortedAccounts() {
        System.out.println("Accounts sorted by balance: " + sortedCustomers);
    }
}

// Driver class
public class BankingSystem {
    public static void main(String[] args) {
        BankSystem bank = new BankSystem();

        // Adding customer accounts
        bank.addAccount(101, 5000);
        bank.addAccount(102, 3000);
        bank.addAccount(103, 7000);
        bank.addAccount(104, 2000);

        // Display sorted accounts
        bank.displaySortedAccounts();

        // Deposit money
        bank.deposit(102, 2000);

        // Request withdrawals with specific amounts
        bank.requestWithdrawal(101, 1000);
        bank.requestWithdrawal(104, 1500);
        bank.requestWithdrawal(103, 5000);

        // Process withdrawals
        bank.processWithdrawals();

        // Display updated sorted accounts
        bank.displaySortedAccounts();
    }
}
