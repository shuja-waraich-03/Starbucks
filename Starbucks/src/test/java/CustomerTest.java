package test.java;

import org.junit.jupiter.api.Test;
import main.java.CoffeePreference;
import main.java.Customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    @Test
    public void testCoffeeCountIncrements() {
        Customer customer = new Customer("123", CoffeePreference.LATTE);
        customer.purchaseCoffee();
        assertEquals(1, customer.getCoffeeCount());
    }

    @Test
    public void testCouponGenerationAndReset() {
        Customer customer = new Customer("123", CoffeePreference.LATTE);
        customer.purchaseCoffee();
        customer.purchaseCoffee();
        customer.purchaseCoffee();
        assertEquals(0, customer.getCoffeeCount());
    }

    @Test
    public void testGetCoffeePreference() {
        Customer customer = new Customer("123", CoffeePreference.LATTE);
        assertEquals(CoffeePreference.LATTE, customer.getCoffeePreference());
    }
}