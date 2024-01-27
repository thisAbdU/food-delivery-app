package com.food.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public Connection connect_to_database(String databaseName, String user, String password) {
        Connection connection;
        try {
            String jdbcURL = "jdbc:postgresql://localhost:5432/" + databaseName;
            connection = DriverManager.getConnection(jdbcURL, user, password);
            System.out.println("done with connection");
        } catch (SQLException e) {
            System.out.println("connection cannot be made");
            throw new RuntimeException(e);
        }
        return connection;
    }

}
