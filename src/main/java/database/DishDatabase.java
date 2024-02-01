package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DishDatabase extends DatabaseConnection {
    public void insert_dish_row(Connection connection, String table_name, String dish_name, String dish_price, int dish_restaurant_id) {
        PreparedStatement preparedStatement = null;

        try {
            String query = String.format("INSERT INTO %s (dish_name, dish_price, dish_restaurant_id) VALUES (?, ?, ?);", table_name);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, dish_name);
            preparedStatement.setString(2, dish_price);
            preparedStatement.setInt(3, dish_restaurant_id);

            preparedStatement.executeUpdate();
            System.out.println("Dish inserted successfully");
        } catch (SQLException e) {
            System.out.println("Error inserting dish");
            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public int getDishPrice(Connection connection, String table_name, int dish_id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String query = String.format("SELECT dish_price FROM %s WHERE dish_id = ?;", table_name);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, dish_id);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("dish_price");
            } else {
                return -1;
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving dish price");
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
                System.out.println("Error closing resources");
            }
        }
    }

    public ArrayList<Dish> getAlldishes(Connection connection, String table_name) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String query = String.format("SELECT * FROM %s;", table_name);
            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            ArrayList<Dish> dishes = new ArrayList<>();

            while (resultSet.next()) {
                Dish dish = new Dish();
                dish.setDishName(resultSet.getString("dish_name"));
                
                dish.setDishImage(resultSet.getString("dish_image"));

                dishes.add(dish);
            }

            return dishes;
        } catch (SQLException e) {
            System.out.println("Error retrieving dishes");

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
