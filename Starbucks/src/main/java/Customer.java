package main.java;

public class Customer {
    private String membershipId;
    private CoffeePreference coffeePreference;
    private int coffeeCount;

    public Customer(String membershipId, CoffeePreference coffeePreference) {
        this.membershipId = membershipId;
        this.coffeePreference = coffeePreference;
        this.coffeeCount = 0;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public CoffeePreference getCoffeePreference() {
        return coffeePreference;
    }

    public int getCoffeeCount() {
        return coffeeCount;
    }

    public void purchaseCoffees(int numberOfCoffees) {
        for (int i = 0; i < numberOfCoffees; i++) {
            purchaseCoffee();
        }
    }

    public void purchaseCoffee() {
        coffeeCount++;
        if (coffeeCount >= 3) {
            generateCoupon();
            coffeeCount = 0;
        }
    }

    private void generateCoupon() {
        System.out.println("Coupon generated for " + membershipId + ": Get one coffee free!");
    }
}
