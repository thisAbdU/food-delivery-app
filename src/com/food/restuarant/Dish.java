package com.food.restuarant;

public class Dish {
    private final String name;
    private final double price;

    public Dish(String name, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return name + " - $" + price;
    }
}

