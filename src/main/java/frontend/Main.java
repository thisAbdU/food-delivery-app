package frontend;

import database.DatabaseConnection;
import database.RestaurantDatabase;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection connection = new DatabaseConnection();
        Connection databaseConnection = connection.connect_to_database("food_delivery_app", "postgres", "1234");

        RestaurantDatabase rest = new RestaurantDatabase();

        

    }

}
