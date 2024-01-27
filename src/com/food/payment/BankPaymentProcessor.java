package com.food.payment;

public abstract class BankPaymentProcessor extends AccountPasswordMap implements PaymentProcessor {
    @Override
    public boolean bankProcessPayment(double amount, int accountNumber, String password) {
        if (accountPasswordMap.containsKey(accountNumber)) {
            String storedPassword = accountPasswordMap.get(accountNumber);

            if (storedPassword.equals(password)) {
                if (amount > AMOUNT) {
                    System.out.println("You have successfully ordered food!\nThanks for using our app!");
                    return true;
                } else {
                    System.out.println("Your balance is insufficient!");
                }
            } else {
                System.out.println("Invalid password!");
            }
        } else {
            System.out.println("Account number not found!");
        }


        return false;
    }
}

