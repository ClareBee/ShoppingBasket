package com.example.clareblackburne.shoppingbasketcodetest;

import com.example.clareblackburne.shoppingbasketcodetest.Items.Item;

/**
 * Created by clareblackburne on 24/11/2017.
 */

public class Checkout {

    private int tillNumber;
    private Discount todaysDiscount;

    public Checkout(int tillNumber, Discount todaysDiscount){
        this.tillNumber = tillNumber;
        this.todaysDiscount = todaysDiscount;
    }

    public double finalPrice (Customer customer, ShoppingBasket shoppingbasket){

        double scannedPrice = this.applyDiscountIfBasketEligible(shoppingbasket);
        double finalPrice = scannedPrice;

        if(customer.hasLoyaltyCard()){
            finalPrice = 0.98 * scannedPrice;
        }
        else {
            return scannedPrice;
        }
        return finalPrice;
    }

    public void chargeCustomer(Customer customer, ShoppingBasket shoppingBasket) throws InsufficientAmountException {
        if (customer.getCash() > this.finalPrice(customer, shoppingBasket)) {
            customer.setCash(customer.getCash() - this.finalPrice(customer, shoppingBasket));
        } else {
            throw new InsufficientAmountException("The customer doesn't have enough cash.");
        }
    }

//this is a method which applies two-for-one on all items in the basket
    public double twoForOne(ShoppingBasket shoppingBasket){

        double discount = 0;
        double baseCost = shoppingBasket.calculateBaseCost();

        for(Item item: shoppingBasket.contents()){
            if(item.getQuantity() >= 2 && item.getQuantity() % 2 == 0 ){
                discount = ((item.getQuantity()/2) * item.getPrice());
                baseCost = baseCost - discount;
            }
            else if(item.getQuantity() >= 2 && item.getQuantity() % 2 ==1){
                discount = ((item.getQuantity() - 1)/2) * item.getPrice();
                 baseCost = baseCost - discount;
            }
            else{
                return baseCost;
            }
        }
        return baseCost;
    }


//this is an overloaded method which allows the two-for-one to be applied to one type of item only
    public double twoForOne(ShoppingBasket shoppingBasket, Offerable offerable){
        double discount = 0;
        double baseCost = shoppingBasket.calculateBaseCost();

        for(Item item : shoppingBasket.contents()){
            if(item.getClass() == offerable.getClass()){
                if(item.getQuantity() >= 2 && item.getQuantity() % 2 == 0 ){
                    discount = ((item.getQuantity()/2) * item.getPrice());
                    baseCost = baseCost - discount;
                }
                else if(item.getQuantity() >= 2 && item.getQuantity() % 2 ==1){
                    discount = ((item.getQuantity() - 1)/2) * item.getPrice();
                    baseCost = baseCost - discount;
                }
                else{
                    return baseCost;
                }
            }
            }return baseCost;
    }

    public double applyDiscountIfBasketEligible(ShoppingBasket shoppingBasket){

        double startPrice = this.twoForOne(shoppingBasket);
        double updatedPrice = startPrice;
        if(shoppingBasket.countContents() >= todaysDiscount.getEligibleSizeOfBasket()){
            updatedPrice = startPrice - ((todaysDiscount.getReduction()/100) * startPrice);
        }
        else {
            return startPrice;
        }
        return updatedPrice;
    }


}
