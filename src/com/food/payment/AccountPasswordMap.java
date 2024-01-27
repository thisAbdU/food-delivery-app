package com.food.payment;

import java.util.HashMap;
import java.util.Map;

public class AccountPasswordMap {
    Map<Long, String> accountPasswordMap;

    static final int AMOUNT = 1000;
    final long accountNumberOne = 100001122;
    final long accountNumberTwo = 100011122;
    final long accountNumberThree = 100001222;
    final long accountNumberFour = 100031122;
    final long accountNumberFive = 100041122;
    final long accountNumberSix = 100007122;

    public AccountPasswordMap() {
        accountPasswordMap = new HashMap<>();
        initializeAccountPasswordMap();
    }

    private void initializeAccountPasswordMap() {
        accountPasswordMap.put(accountNumberOne, "J2sP9kR8");
        accountPasswordMap.put(accountNumberTwo, "yH6nX0zL");
        accountPasswordMap.put(accountNumberThree, "gA4bF1cN");
        accountPasswordMap.put(accountNumberFour, "vD9oQ5tW");
        accountPasswordMap.put(accountNumberFive, "mZ7rE3pK");
        accountPasswordMap.put(accountNumberSix, "aB8cD5eF");
    }


}

