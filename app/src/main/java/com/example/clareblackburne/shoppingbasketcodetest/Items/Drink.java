package com.example.clareblackburne.shoppingbasketcodetest.Items;

/**
 * Created by clareblackburne on 24/11/2017.
 */

public class Drink extends Item {

    private boolean alcoholic;
    public Drink(String name, double price, Integer quantity, boolean alcoholic){
        super(name, price, quantity);
        this.alcoholic = alcoholic;
    }

    public boolean isAlcoholic() {
        return alcoholic;
    }
}
