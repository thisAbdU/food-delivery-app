package user;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.*;

import database.UserDatabase;


class userSignUp extends JPanel implements ActionListener{

    JLabel signUpLabel = new JLabel("Welcome to Sign Up Page");
    JTextField nameField = new JTextField();
    JTextField userNameField = new JTextField();
    JTextField emailField = new JTextField();
    JTextField phoneNumberField = new JTextField();
    JTextField deliveryAddressField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JPasswordField confirmPasswordField = new JPasswordField();

    JLabel titleLabel = new JLabel("Sign Up ");
    JLabel nameLabel = new JLabel("Name: ");
    JLabel emailLabel = new JLabel("Email: ");
    JLabel userNameLabel = new JLabel("User Name: ");
    JLabel phoneNumberLabel = new JLabel("Phone Number: ");
    JLabel deliveryAddressLabel = new JLabel("Delivery Address: ");
    JLabel userPasswordLabel = new JLabel("New Password:");
    JLabel confirmPasswordLabel = new JLabel("confirm Password: ");

    JButton signUpButton = new JButton("SignUp");
    JButton resetButton = new JButton("Reset");

    public userSignUp() {  
            
        titleLabel.setBounds(0, 0, 200, 35);
        titleLabel.setText("Sign Up");
        nameLabel.setBounds(50, 100, 200, 25);
        emailLabel.setBounds(50, 150, 200, 25);  
        userNameLabel.setBounds(50, 200, 200, 25);  
        phoneNumberLabel.setBounds(50, 250, 200, 25);  
        deliveryAddressLabel.setBounds(50, 300, 200, 25);  
        userPasswordLabel.setBounds(50, 350, 200, 25);  
        confirmPasswordLabel.setBounds(50, 400, 200, 25);  

        nameField.setBounds(125, 100, 200, 25); 
        emailField.setBounds(125, 150, 200, 25);
        userNameField.setBounds(150, 200, 200, 25);
        phoneNumberField.setBounds(175, 250, 200, 25);
        deliveryAddressField.setBounds(175, 300, 200, 25);
        userPasswordField.setBounds(175, 350, 200, 25);
        confirmPasswordField.setBounds(200, 400, 200, 25);
        
        this.add(titleLabel);
        this.add(nameLabel);
        this.add(nameField);
        this.add(emailLabel);
        this.add(userNameLabel);
        this.add(phoneNumberLabel);
        this.add(deliveryAddressLabel);
        this.add(userPasswordLabel);
        this.add(confirmPasswordLabel);

        this.add(nameField);
        this.add(emailField);
        this.add(userNameField);
        this.add(phoneNumberField);
        this.add(deliveryAddressField);
        this.add(userPasswordField);
        this.add(confirmPasswordField);
        
        this.add(signUpButton);
        this.add(resetButton);
        signUpButton.setBounds(100, 450, 100, 25);
        resetButton.setBounds(250, 450, 100, 25);

        this.setSize(1366, 738);
        this.setLayout(null);

        signUpButton.addActionListener(this);
        resetButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==resetButton){
            nameField.setText("");
            emailField.setText("");
            userNameField.setText("");
            phoneNumberField.setText("");
            deliveryAddressField.setText("");
            userPasswordField.setText("");
            confirmPasswordField.setText("");
        }
        if (e.getSource() == signUpButton) {
            UserDatabase newUser = new UserDatabase();
            Connection connectToDB = newUser.connect_to_database("food_delivery_app", "postgres", "1234");

            String name = nameField.getText();
            String userName = userNameField.getText();
            String email = emailField.getText();
            String phoneNumber = phoneNumberField.getText();
            String deliveryAddress = deliveryAddressField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            String confirmPassword = String.valueOf(confirmPasswordField.getPassword());
            String status = "user";
        
               
            if ((name.isEmpty() || userName.isEmpty() || email.isEmpty()
             || phoneNumber.isEmpty() || deliveryAddress.isEmpty() || 
             password.isEmpty() || confirmPassword.isEmpty())) {
                JOptionPane.showMessageDialog(null, "Please fill in all the fields.", "Incomplete Information", JOptionPane.WARNING_MESSAGE);
            }

            else if (!InputVerifier.isValidEmail(email)){
                JOptionPane.showMessageDialog(null, "Please enter valid email address.", "Invalid email address", JOptionPane.WARNING_MESSAGE);
            }else if (!InputVerifier.isValidPhoneNumber(phoneNumber)){
                JOptionPane.showMessageDialog(null, "Please enter valid phone number.", "Invalid phone number", JOptionPane.WARNING_MESSAGE);
            }else if (!InputVerifier.isValidPassword(password)){
                JOptionPane.showMessageDialog(null, "length of password must be at least 8", "Invalid password", JOptionPane.WARNING_MESSAGE);
            }
            
            else if (newUser.doesUserExist(connectToDB, "usersData", userName)){
                JOptionPane.showMessageDialog(null, "User Name Already Exist.", "user name exists", JOptionPane.ERROR_MESSAGE);
            } 
            
            else if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(null, "Passwords do not match.", "Password Mismatch", JOptionPane.ERROR_MESSAGE);
            } 
            
            else {
                // Passwords match, proceed to the next page
                titleLabel.setForeground(Color.green);
                JOptionPane.showMessageDialog(null, "Successfully Registered", "success!", JOptionPane.INFORMATION_MESSAGE);
                newUser.insert_user_data(connectToDB, "usersData", name, userName, email, phoneNumber, password, status);
                new LoginPage();   
               
            }              
       
    }


}}