package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Starbucks {
    private Map<String, Customer> customerDatabase;

    public Starbucks() {
        customerDatabase = new HashMap<>();
    }

    public void addCustomer(String membershipId, CoffeePreference coffeePreference) {
        customerDatabase.put(membershipId, new Customer(membershipId, coffeePreference));
    }

    public void swipeCard(String membershipId, int numberOfCoffees) throws NoSuchElementException {
        if (customerDatabase.containsKey(membershipId)) {
            Customer customer = customerDatabase.get(membershipId);
            System.out.println("Welcome back! Your preferred coffee is: " + customer.getCoffeePreference());
            customer.purchaseCoffees(numberOfCoffees);
        } else {
            throw new NoSuchElementException("Customer with ID " + membershipId + " not found.");
        }
    }

    public String getCustomerInfo(String membershipId) throws NoSuchElementException {
        if (customerDatabase.containsKey(membershipId)) {
            Customer customer = customerDatabase.get(membershipId);
            return "Customer ID: " + customer.getMembershipId() +
                   "\nPreferred Coffee: " + customer.getCoffeePreference() +
                   "\nCoffees Purchased: " + customer.getCoffeeCount();
        } else {
            throw new NoSuchElementException("Customer with ID " + membershipId + " not found.");
        }
    }

    public Customer getCustomer(String membershipId) throws NoSuchElementException {
        if (customerDatabase.containsKey(membershipId)) {
            return customerDatabase.get(membershipId);
        } else {
            throw new NoSuchElementException("Customer with ID " + membershipId + " not found.");
        }
    }
}

