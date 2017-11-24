package com.example.clareblackburne.shoppingbasketcodetest.Items;

/**
 * Created by clareblackburne on 24/11/2017.
 */

public class FreshProduce extends Item {

    private Integer shelfLife;
    private boolean organic;

    public FreshProduce(String name, double price, Integer quantity, Integer shelfLife, boolean organic){
        super(name, price, quantity);
        this.shelfLife = shelfLife;
        this.organic = organic;
    }

    public Integer getShelfLife() {
        return shelfLife;
    }

    public boolean isOrganic() {
        return organic;
    }
}
