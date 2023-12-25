package com.food.payment;

public interface PaymentProcessor {
    boolean telebirrProcessPayment(double amount);

    boolean bankProcessPayment(double amount, int accountNumber, String password);
}
