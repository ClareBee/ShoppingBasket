package com.example.clareblackburne.shoppingbasketcodetest.Items;

/**
 * Created by clareblackburne on 24/11/2017.
 */

public class Dairy extends Item {

    private Integer shelfLife;
    private boolean organic;

    public Dairy(String name, double price, Integer quantity, Integer shelfLife, boolean organicStatus){
        super(name, price, quantity);
        this.shelfLife = shelfLife;
        this.organic = organicStatus;
    }

    public Integer getShelfLife() {
        return shelfLife;
    }

    public boolean isOrganic() {
        return organic;
    }
}
