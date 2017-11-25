package com.example.clareblackburne.shoppingbasketcodetest;

import com.example.clareblackburne.shoppingbasketcodetest.Items.BakedGoods;
import com.example.clareblackburne.shoppingbasketcodetest.Items.CleaningProduct;
import com.example.clareblackburne.shoppingbasketcodetest.Items.Dairy;
import com.example.clareblackburne.shoppingbasketcodetest.Items.Drink;
import com.example.clareblackburne.shoppingbasketcodetest.Items.FreshProduce;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by clareblackburne on 24/11/2017.
 */

public class TestCheckout {

    private Checkout checkout1;
    private BakedGoods bread;
    private Dairy milk;
    private Dairy eggs;
    private FreshProduce cauliflower;
    private ShoppingBasket shoppingBasket;
    private Customer customer1;
    private Customer customer2;
    private Discount discount;
    private CleaningProduct bleach;

    @Before
    public void before(){
        discount = new Discount(20, 10);
        checkout1 = new Checkout(1, discount);
        bread = new BakedGoods("bread", 5.50, 3, 14, false);
        milk = new Dairy("milk", 1.20, 2, 10, true);
        eggs = new Dairy("eggs", 2.00, 6, 14, false);
        cauliflower = new FreshProduce("cauliflower", 1.00, 1, 10, true);
        bleach = new CleaningProduct("bleach", 2.00, 5);
        shoppingBasket = new ShoppingBasket();
        customer1 = new Customer("Bob", 300, true);
        customer2 = new Customer("Sheila", 200, false);
    }

    @Test
    public void testTwoForOneWithEvenNum(){
        shoppingBasket.addItem(milk);
        assertEquals(1.20, checkout1.twoForOne(shoppingBasket), 0.1);
    }

    @Test
    public void testTwoForOneWhenOnlyOne(){
        shoppingBasket.addItem(cauliflower);
        assertEquals(1, checkout1.twoForOne(shoppingBasket), 0.1);
    }

    @Test
    public void testTwoForOneWithEvenNum2(){
        shoppingBasket.addItem(eggs);
        assertEquals(6, checkout1.twoForOne(shoppingBasket), 0.1);
    }
    @Test
    public void testTwoForOneWithOddNum(){
        shoppingBasket.addItem(bread);
        assertEquals(11, checkout1.twoForOne(shoppingBasket), 0.1);
    }

    @Test
    public void testTwoForOneOnOneType(){
        shoppingBasket.addItem(bread);
        shoppingBasket.addItem(eggs);
        assertEquals(23, checkout1.twoForOne(shoppingBasket, bread), 0.1);
    }
    @Test
    public void testTwoForOneWithMultipleItems(){
        shoppingBasket.addItem(bread);
        shoppingBasket.addItem(eggs);
        assertEquals(17, checkout1.twoForOne(shoppingBasket), 0.1);
    }

    @Test
    public void testApplyDiscountWhenLessThan20(){
        shoppingBasket.addItem(bread);
        double result = checkout1.applyDiscountIfBasketEligible(shoppingBasket);
        assertEquals(11, result, 0.1);
    }

    @Test
    public void testApplyDiscountWhenMoreThan20(){
        Drink wine = new Drink("bottle of wine", 3.00, 22, true);
        shoppingBasket.addItem(wine);
        double result = checkout1.applyDiscountIfBasketEligible(shoppingBasket);
        assertEquals(29.7, result, 0.1);
    }

    @Test
    public void testApplyDiscountWhenZero(){
        double result = checkout1.applyDiscountIfBasketEligible(shoppingBasket);
        assertEquals(0, result, 0.1);
    }

    @Test
    public void testLoyaltyCardWhenEligible(){
        shoppingBasket.addItem(bread);
        double result = checkout1.finalPrice(customer1, shoppingBasket);
        assertEquals(10.78, result, 0.1);
    }

    @Test
    public void testLoyaltyCardWhenNotEligible(){
        shoppingBasket.addItem(bread);
        double result = checkout1.finalPrice(customer2, shoppingBasket);
        assertEquals(11, result, 0.1);
    }

    @Test
    public void testChargeIneligibleCustomer(){
        shoppingBasket.addItem(bread);
        checkout1.chargeCustomer(customer2, shoppingBasket);
        assertEquals(189, customer2.getCash(), 0.1);
    }

    @Test
    public void testChargeEligibleCustomer(){
        shoppingBasket.addItem(bread);
        checkout1.chargeCustomer(customer1, shoppingBasket);
        assertEquals(289.22, customer1.getCash(), 0.1);
    }

    @Test
    public void testAllCriteriaApply(){
        Drink beer = new Drink("Beer", 1, 22, true);
        shoppingBasket.addItem(beer);
        double result = checkout1.finalPrice(customer1, shoppingBasket);
        assertEquals(9.70, result, 0.1);
    }

    @Test
    public void testNoCriteriaApply(){
        Drink orange = new Drink("orange juice", 3.50, 1, false);
        shoppingBasket.addItem(orange);
        double result = checkout1.finalPrice(customer2, shoppingBasket);
        assertEquals(3.50, result, 0.1);
    }



}
