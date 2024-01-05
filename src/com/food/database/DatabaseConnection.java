package com.food.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static void main(String[] args) {

        Connection connection;

        {
            try {
                String password = "1234";
                String jdbcURL = "jdbc:postgresql://localhost:5432/food_delivery_app";
                String username = "postgres";
                connection = DriverManager.getConnection(jdbcURL, username, password);
                System.out.println("done with connection");
            } catch (SQLException e) {
                System.out.println("connection cannot be made");
                throw new RuntimeException(e);
            }
        }
    }
}
