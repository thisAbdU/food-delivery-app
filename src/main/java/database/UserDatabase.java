package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;



public class UserDatabase extends DatabaseConnection {

    public void insert_user_data(Connection connection,
                                 String table_name,
                                 String name,
                                 String username,
                                 String email,
                                 String phone_number,
                                 String plain_password,
                                 String status) {
                                    

        PreparedStatement preparedStatement = null;
        try {
            // Hash the password using BCrypt
            String hashed_password = BCrypt.hashpw(plain_password, BCrypt.gensalt());

            String query = String.format("INSERT INTO %s (name, username, email, phone_number, hashed_password, status) VALUES (?, ?, ?, ?, ?, ?);", table_name);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, phone_number);
            preparedStatement.setString(5, hashed_password);
            preparedStatement.setString(6, status);

            preparedStatement.executeUpdate();
            System.out.println("User registered successfully");
        } catch (SQLException e) {
            System.out.println("Error registering user");
            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing PreparedStatement");
            }
        }
    }
    public boolean doesUserExist(Connection connection,
                                 String table_name,
                                 String username) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String query = String.format("SELECT * FROM %s WHERE username = ?;", table_name);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            System.out.println("Error checking if user exists");
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

    public boolean doesPasswordMatch(Connection connection,
                                 String table_name,
                                 String username,
                                 String password) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String query = String.format("SELECT * FROM %s WHERE username = ?;", table_name);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String truePassword = resultSet.getString("hashed_password");
                return BCrypt.checkpw(password, truePassword);
                
            }else{
                return false;
            }
            

        } catch (SQLException e) {
            System.out.println("Error checking for password match");
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

    public boolean isDeliveryGuy(Connection connection, String table_name, String userName) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String query = String.format("SELECT * FROM %s WHERE status = ?;", table_name);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userName);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("status").equals("deliveryMan");
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error checking user status");
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

