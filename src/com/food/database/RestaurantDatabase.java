package com.food.database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RestaurantDatabase extends DatabaseConnection {

    public void insert_restaurant(Connection connection, String table_name, String restaurant_name, InputStream restaurant_image) {
        PreparedStatement preparedStatement = null;

        try {
            connection.setAutoCommit(false);

            String query = String.format("INSERT INTO %s (restaurant_name, restaurant_image) VALUES (?, ?);", table_name);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, restaurant_name);
            preparedStatement.setBlob(2, restaurant_image);

            preparedStatement.executeUpdate();

            connection.commit();

            System.out.println("Restaurant added successfully");
        } catch (SQLException e) {
            System.out.println("Error adding Restaurant");

            try {
                connection.rollback();
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }

            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                connection.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Error closing resources or setting auto-commit.");
            }
        }
    }
}
