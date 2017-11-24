package com.example.clareblackburne.shoppingbasketcodetest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by clareblackburne on 24/11/2017.
 */

public class TestItem {

    Dairy cheese;
    Drink cola;

    @Before
    public void before(){
        cheese = new Dairy("cheese", 4.50, 1, 21, true);
        cola = new Drink("Coke", 1.20, 3, false);
    }

    @Test
    public void testItemHasName(){
        assertEquals("cheese", cheese.getName());
    }

    @Test
    public void testItemHasQuantity(){
        assertEquals(1, cheese.getQuantity(), 0.1);
        assertEquals(3, cola.getQuantity(), 0.1);
    }
}
