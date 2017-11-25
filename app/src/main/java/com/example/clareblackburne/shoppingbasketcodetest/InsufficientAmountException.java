package com.example.clareblackburne.shoppingbasketcodetest;

/**
 * Created by clareblackburne on 25/11/2017.
 */

public class InsufficientAmountException extends Exception {

    public InsufficientAmountException() {
        super();
    }

    public InsufficientAmountException(String message) {
        super(message);
    }
}
