package com.food.frontend;

import com.food.database.DatabaseConnection;
import com.food.database.RestaurantDatabase;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection connection = new DatabaseConnection();
        Connection databaseConnection = connection.connect_to_database("food_delivery_app", "postgres", "1234");

        RestaurantDatabase rest = new RestaurantDatabase();

    }

}
