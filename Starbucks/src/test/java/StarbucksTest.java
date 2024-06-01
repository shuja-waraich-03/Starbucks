package test.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.CoffeePreference;
import main.java.Starbucks;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class StarbucksTest {
    private Starbucks starbucks;

    @BeforeEach
    public void setUp() {
        starbucks = new Starbucks();
        starbucks.addCustomer("123", CoffeePreference.LATTE);
        starbucks.addCustomer("456", CoffeePreference.ESPRESSO);
    }

    @Test
    public void testAddCustomer() {
        starbucks.addCustomer("789", CoffeePreference.CAPPUCCINO);
        assertDoesNotThrow(() -> starbucks.getCustomer("789"));
    }

    @Test
    public void testSwipeCardAndGenerateCoupon() {
        assertDoesNotThrow(() -> {
            starbucks.swipeCard("123", 3);
        });
        assertEquals(0, starbucks.getCustomer("123").getCoffeeCount());
    }


    @Test
    public void testSwipeCardForMultipleCustomers() {
        starbucks.addCustomer("789", CoffeePreference.CAPPUCCINO);
        assertDoesNotThrow(() -> {
            starbucks.swipeCard("123", 1);
            starbucks.swipeCard("456", 1);
            starbucks.swipeCard("789", 1);
        });
        assertEquals(1, starbucks.getCustomer("123").getCoffeeCount());
        assertEquals(1, starbucks.getCustomer("456").getCoffeeCount());
        assertEquals(1, starbucks.getCustomer("789").getCoffeeCount());
    }


    @Test
    public void testMultipleCoffeesPurchase() {
        assertDoesNotThrow(() -> {
            starbucks.swipeCard("123", 5); // Should generate one coupon and have 2 coffees left
        });
        assertEquals(2, starbucks.getCustomer("123").getCoffeeCount());
    }
}


