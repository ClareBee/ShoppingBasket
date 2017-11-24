package com.example.clareblackburne.shoppingbasketcodetest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by clareblackburne on 24/11/2017.
 */

public class TestCustomer {

    private Customer customer;

    @Before
    public void before(){
        customer = new Customer("Mr Smith", 100.00, false);
    }

    @Test
    public void testCustomerHasName(){
        assertEquals("Mr Smith", customer.getName());
    }

    @Test
    public void testCustomerHasCash(){
        assertEquals(100.00, customer.getCash(), 0.1);
    }

    @Test
    public void testCustomerHasLoyaltyCard(){
        assertFalse(customer.hasLoyaltyCard());
    }

    @Test
    public void testCustomerCanGetLoyaltyCard(){
        customer.getsLoyaltyCard();
        assertTrue(customer.hasLoyaltyCard());
    }
}
