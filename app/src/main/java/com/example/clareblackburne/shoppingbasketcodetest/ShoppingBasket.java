package com.example.clareblackburne.shoppingbasketcodetest;

import com.example.clareblackburne.shoppingbasketcodetest.Items.Item;

import java.util.ArrayList;

/**
 * Created by clareblackburne on 24/11/2017.
 */

public class ShoppingBasket {

    ArrayList<Item> contents;

    public ShoppingBasket(){
        this.contents = new ArrayList<Item>();
    }


    public void addItem(Item item){

        if(contents.contains(item)){
            item.setQuantity(item.getQuantity() + 1);
        }
        else{
            contents.add(item);}
    }

    public void removeItem(Item item){
        if(item.getQuantity() > 1){
            item.setQuantity(item.getQuantity() -1);
        }
        else{
        contents.remove(item);}
    }

    public void empty(){
        contents.clear();
    }

    public int countContents(){
        int totalNum = 0;
        for(Item item : contents){
            totalNum += item.getQuantity();
        }
        return totalNum;
    }

    public boolean checkForItem(Item item){
        return contents.contains(item);
    }

    public ArrayList<Item> contents(){
        return contents;
    }



    public double calculateBaseCost(){
        double total = 0;
        for(Item item : contents){
            total += (item.getPrice() * item.getQuantity());
        }
        return total;
    }


}
