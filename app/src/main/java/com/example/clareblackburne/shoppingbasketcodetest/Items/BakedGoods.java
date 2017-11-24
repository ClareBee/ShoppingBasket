package com.example.clareblackburne.shoppingbasketcodetest.Items;

/**
 * Created by clareblackburne on 24/11/2017.
 */

public class BakedGoods extends Item {

    private Integer shelfLife;
    private boolean glutenFree;

    public BakedGoods(String name, double price, Integer quantity, Integer shelfLife, boolean glutenFree){
        super(name, price, quantity);
        this.shelfLife = shelfLife;
        this.glutenFree = glutenFree;
    }

    public Integer getShelfLife() {
        return shelfLife;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }
}
