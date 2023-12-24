package com.food.restuarant;

public class RestaurantApp {
    public static void main(String[] args) {
        // Create dishes
        Dish pasta = new Dish("Pasta", 10.99);
        Dish egg = new Dish("Egg", 5.99);
        Dish salad = new Dish("Salad", 7.99);

        // Create Hayat Er tib restaurant
        com.food.restaurant.Restaurant hayatErtib = new com.food.restaurant.Restaurant(1, "Hayat Ertib", "Cuisine1", "Location1");

        // Add dishes to the Hayat Er tib menu
        hayatErtib.addDish(pasta);
        hayatErtib.addDish(egg);
        hayatErtib.addDish(salad);

        // Display information for Hayat Er tib restaurant
        System.out.println(hayatErtib.generateRestaurantInfo());
        hayatErtib.displayMenu();
    }
}
