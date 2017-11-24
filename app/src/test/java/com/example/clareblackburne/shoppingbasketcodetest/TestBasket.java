package com.example.clareblackburne.shoppingbasketcodetest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by clareblackburne on 24/11/2017.
 */

public class TestBasket {

    private Dairy milk;
    private BakedGoods bread;
    private CleaningProduct bleach;
    private ShoppingBasket shoppingBasket;

    @Before
    public void before(){
        milk = new Dairy("cream", 4.50, 1, 10, true);
        bread = new BakedGoods("bread", 3.00, 1, 7, false);
        bleach = new CleaningProduct("bleach", 2.00, 2);
        shoppingBasket = new ShoppingBasket();
    }



    @Test
    public void testCanAddItem(){
        shoppingBasket.addItem(milk);
        assertFalse(shoppingBasket.contents.isEmpty());
    }


    @Test
    public void testCanCountContents(){
        shoppingBasket.addItem(milk);
        shoppingBasket.addItem(bread);
        assertEquals(2, shoppingBasket.countContents());
    }

    @Test
    public void testCanAddItemTwice(){
        shoppingBasket.addItem(milk);
        shoppingBasket.addItem(milk);
        assertEquals(2, shoppingBasket.countContents());
    }

    @Test
    public void testCanRemoveItem(){
        shoppingBasket.addItem(milk);
        shoppingBasket.removeItem(milk);
        assertEquals(0, shoppingBasket.countContents());
    }

    @Test
    public void testCanRemoveOneOfSpecificItem(){
        shoppingBasket.addItem(milk);
        shoppingBasket.addItem(bread);
        shoppingBasket.removeItem(milk);
        assertFalse(shoppingBasket.checkForItem(milk));
        assertTrue(shoppingBasket.checkForItem(bread));
    }

    @Test
    public void testCanRemoveOneOfMultipleQuantity(){
        shoppingBasket.addItem(bleach);
        shoppingBasket.removeItem(bleach);
        assertEquals(1, shoppingBasket.countContents());
    }


    @Test
    public void testCanEmptyBasket(){
        shoppingBasket.addItem(milk);
        shoppingBasket.addItem(bread);
        shoppingBasket.empty();
        assertEquals(0, shoppingBasket.countContents());
    }

    @Test
    public void testCanCalcBaseCost(){
        shoppingBasket.addItem(milk);
        shoppingBasket.addItem(bread);
        assertEquals(7.50, shoppingBasket.calculateBaseCost(), 0.1);
    }

    @Test
    public void testCanCalcBaseCostWhenQuantityIncreases(){
        shoppingBasket.addItem(bleach);
        assertEquals(4.0, shoppingBasket.calculateBaseCost(), 0.1);
    }

    @Test
    public void testCalCostWhenBasketEmpty(){
        assertEquals(0, shoppingBasket.calculateBaseCost(), 0.1);
    }


}
