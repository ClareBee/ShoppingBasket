package com.example.clareblackburne.shoppingbasketcodetest.Items;

import com.example.clareblackburne.shoppingbasketcodetest.Offerable;

/**
 * Created by clareblackburne on 24/11/2017.
 */

public abstract class Item implements Offerable {

    private String name;
    private double price;
    private Integer quantity;


    public Item(String name, double price, Integer quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }
}
