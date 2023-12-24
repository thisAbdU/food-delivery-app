package com.food.restaurant;

import com.food.restuarant.Dish;

import java.util.ArrayList;
import java.util.Collections;  // Import the Collections class
import java.util.List;

public class Restaurant {
    private final int restaurantId;
    private final String name;
    private final String cuisine;
    private final String location;
    private final List<Dish> menu;

    public Restaurant(int restaurantId, String name, String cuisine, String location) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.cuisine = cuisine;
        this.location = location;
        this.menu = new ArrayList<>();
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public String getName() {
        return name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public String getLocation() {
        return location;
    }

    public List<Dish> getMenu() {
        return Collections.unmodifiableList(menu);
    }

    public void addDish(Dish dish) {
        menu.add(dish);
    }

    public void displayMenu() {
        System.out.println("Menu for " + name + " (Cuisine: " + cuisine + "):");
        if (menu.isEmpty()) {
            System.out.println("No dishes available.");
        } else {
            for (Dish dish : menu) {
                System.out.println(dish);
            }
        }
    }

    public String generateRestaurantInfo() {
        return "Restaurant ID: " + restaurantId +
                "\nName: " + name +
                "\nCuisine: " + cuisine +
                "\nLocation: " + location;
    }
}
