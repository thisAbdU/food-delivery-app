package database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDatabase extends DatabaseConnection {

    public void insert_restaurant(Connection connection, String table_name, String restaurant_name, String imagePath) {
        PreparedStatement preparedStatement = null;

        try {
            connection.setAutoCommit(false);

            String query = String.format("INSERT INTO %s (restaurant_name, restaurant_image) VALUES (?, ?);", table_name);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, restaurant_name);
            preparedStatement.setString(2, imagePath);

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

    public Restaurant retrieveRestaurantByName(Connection connection, String table_name, String restaurant_name) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String query = String.format("SELECT * FROM %s WHERE restaurant_name = ?;", table_name);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, restaurant_name);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Restaurant restaurant = new Restaurant();
                restaurant.setRestaurantName(resultSet.getString("restaurant_name"));
                restaurant.setRestaurantImage(resultSet.getString("restaurant_image"));

                return restaurant;
            } else {
                System.out.println("Restaurant "+restaurant_name+" not found! ");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving Restaurant");

            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing resources.");
            }
        }
    }

    public ArrayList<Restaurant> getAllRestaurants(Connection connection, String table_name) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String query = String.format("SELECT * FROM %s;", table_name);
            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            ArrayList<Restaurant> restaurants = new ArrayList<>();

            while (resultSet.next()) {
                Restaurant restaurant = new Restaurant();
                restaurant.setRestaurantName(resultSet.getString("restaurant_name"));
                
                restaurant.setRestaurantImage(resultSet.getString("restaurant_image"));

                restaurants.add(restaurant);
            }

            return restaurants;
        } catch (SQLException e) {
            System.out.println("Error retrieving Restaurants");

            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing resources.");
            }
        }
    }
}
