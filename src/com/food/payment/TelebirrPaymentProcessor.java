package com.food.payment;

public abstract class TelebirrPaymentProcessor implements PaymentProcessor {
    static final int AMOUNT = 1000;
    @Override
    public boolean telebirrProcessPayment(double amount){
        if(amount > AMOUNT){
            System.out.println("Your have ordered a food successfully!\n Thanks for using our service!");
            return true;
        }else {
            System.out.println("Your balance is insufficient!");
        }
        return false;
    }
}
