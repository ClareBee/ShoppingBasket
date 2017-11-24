package com.example.clareblackburne.shoppingbasketcodetest;

/**
 * Created by clareblackburne on 24/11/2017.
 */

public class Customer {

    private String name;
    private double cash;
    private boolean hasLoyaltyCard;

    public Customer(String name, double cash, boolean hasLoyaltyCard){
        this.name = name;
        this.cash = cash;
        this.hasLoyaltyCard = hasLoyaltyCard;
    }

    public String getName() {
        return name;
    }

    public double getCash() {
        return cash;
    }

    public boolean hasLoyaltyCard() {
        return hasLoyaltyCard;
    }

    public void getsLoyaltyCard(){
        this.hasLoyaltyCard = true;
    }

    public void setCash(double newTotal){
        this.cash = newTotal;
    }

}
