package com.food.database;

import java.sql.*;

public class PaymentDatabase extends DatabaseConnection{

    public void insert_payment_row(Connection connection, String table_name, long account_number, long amount, long tele_brirr_number){
        Statement statement;
        try{
            String query = String.format("insert into %s (account_number, amount, tele_birr_number) values (%d, %d, %d);",
                    table_name,
                    account_number,
                    amount,
                    tele_brirr_number);

            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public int getAmount(Connection connection, String table_name, long account_number) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String query = String.format("SELECT amount FROM %s WHERE account_number = ?;", table_name);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, account_number);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("amount");
            } else {
                return -1;
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving amount");
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

}


