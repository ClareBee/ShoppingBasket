package com.example.clareblackburne.shoppingbasketcodetest;

/**
 * Created by clareblackburne on 24/11/2017.
 */

public class Discount {

    private int eligibleSizeOfBasket;
    private double reduction;


    public Discount(int eligibleSizeOfBasket, double percentageReduction){
        this.eligibleSizeOfBasket = eligibleSizeOfBasket;
        this.reduction = percentageReduction;
    }


    public int getEligibleSizeOfBasket() {
        return eligibleSizeOfBasket;
    }

    public double getReduction() {
        return reduction;
    }


}
