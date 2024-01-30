package user;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.*;

import database.UserDatabase;


class deliveryManSignUp extends JPanel implements ActionListener, ItemListener{

    public boolean checked = false;

    JLabel signUpLabel = new JLabel("Welcome to Sign Up Page");
    JTextField nameField = new JTextField();
    JTextField userNameField = new JTextField();
    JTextField emailField = new JTextField();
    JTextField phoneNumberField = new JTextField();
    JTextField vehicleNumberPlateField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JPasswordField confirmPasswordField = new JPasswordField();

    JCheckBox ageCB = new JCheckBox("I confirm that my age is greater than 18.");
    JCheckBox vehicleCB = new JCheckBox("I confirm that i have delivery vehicle (that is bycycle, or motor bike or car)");
    JCheckBox schoolCB = new JCheckBox("I confirm that I have a high school diploma. ");
    
    JLabel titleLabel = new JLabel("Sign Up ");
    JLabel nameLabel = new JLabel("Name: ");
    JLabel emailLabel = new JLabel("Email: ");
    JLabel userNameLabel = new JLabel("User Name: ");
    JLabel phoneNumberLabel = new JLabel("Phone Number: ");
    JLabel vehicleNumberPlate = new JLabel("your Vehicle number plate: ");
    JLabel userPasswordLabel = new JLabel("New Password:");
    JLabel confirmPasswordLabel = new JLabel("confirm Password: ");

    JButton signUpButton = new JButton("SignUp");
    JButton resetButton = new JButton("Reset");

    public deliveryManSignUp() {  
            
        titleLabel.setBounds(0, 0, 200, 35);
        titleLabel.setText("Sign Up");
        nameLabel.setBounds(50, 100, 200, 25);
        emailLabel.setBounds(50, 150, 200, 25);  // Adjusted Y-coordinate
        userNameLabel.setBounds(50, 200, 200, 25);  // Adjusted Y-coordinate
        phoneNumberLabel.setBounds(50, 250, 200, 25);  // Adjusted Y-coordinate
        vehicleNumberPlate.setBounds(50, 300, 200, 25);  // Adjusted Y-coordinate
        userPasswordLabel.setBounds(50, 350, 200, 25);  // Adjusted Y-coordinate
        confirmPasswordLabel.setBounds(50, 400, 200, 25);  // Adjusted Y-coordinate

        nameField.setBounds(125, 100, 200, 25); 
        emailField.setBounds(125, 150, 200, 25);
        userNameField.setBounds(150, 200, 200, 25);
        phoneNumberField.setBounds(175, 250, 200, 25);
        vehicleNumberPlateField.setBounds(250, 300, 200, 25);
        userPasswordField.setBounds(175, 350, 200, 25);
        confirmPasswordField.setBounds(200, 400, 200, 25);

        ageCB.setBounds(125, 450, 200, 25);
        ageCB.addItemListener(this);
        vehicleCB.setBounds(125, 475, 200, 25);
        vehicleCB.addItemListener(this);
        schoolCB.setBounds(125, 500, 200, 25);
        schoolCB.addItemListener(this);
        

        this.add(titleLabel);
        this.add(nameLabel);
        this.add(nameField);
        this.add(emailLabel);
        this.add(userNameLabel);
        this.add(phoneNumberLabel);
        this.add(vehicleNumberPlate);
        this.add(userPasswordLabel);
        this.add(confirmPasswordLabel);

        this.add(ageCB);
        this.add(vehicleCB);
        this.add(schoolCB);

        this.add(nameField);
        this.add(emailField);
        this.add(userNameField);
        this.add(phoneNumberField);
        this.add(vehicleNumberPlateField);
        this.add(userPasswordField);
        this.add(confirmPasswordField);
        
        this.add(signUpButton);
        this.add(resetButton);
        signUpButton.setBounds(100, 550, 100, 25);
        resetButton.setBounds(250, 550, 100, 25);

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
            vehicleNumberPlateField.setText("");
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
            String deliveryAddress = vehicleNumberPlateField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            String confirmPassword = String.valueOf(confirmPasswordField.getPassword());
            String status = "deliveryMan";
        // Retrieve the entered values from text fields
        
        
            // Validate if all fields are filled
            if ((name.isEmpty() || userName.isEmpty() || email.isEmpty()
             || phoneNumber.isEmpty() || deliveryAddress.isEmpty() || 
             password.isEmpty() || confirmPassword.isEmpty())) {

                JOptionPane.showMessageDialog(null, "Please fill in all the fields.", "Incomplete Information", JOptionPane.WARNING_MESSAGE);
            
            }else if (newUser.doesUserExist(connectToDB, "usersData", userName)){
                JOptionPane.showMessageDialog(null, "User Name Already Exist.", "user name exists", JOptionPane.ERROR_MESSAGE);
            }else if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(null, "Passwords do not match.", "Password Mismatch", JOptionPane.ERROR_MESSAGE);
            } else {
                titleLabel.setForeground(Color.green);
                JOptionPane.showMessageDialog(null, "Successfully Registered", "success!", JOptionPane.INFORMATION_MESSAGE);
                newUser.insert_user_data(newUser.connect_to_database("food_delivery_app", "postgres", "1234"), "usersData", name, userName, email, phoneNumber, password, status);
                
                new LoginPage();
            }
        }     
    }

    public void itemStateChanged(ItemEvent ie) {
        JCheckBox ageCB = (JCheckBox)ie.getItem();
        JCheckBox vehicleCB = (JCheckBox)ie.getItem();
        JCheckBox shooleCB = (JCheckBox)ie.getItem();
        if(ageCB.isSelected() & vehicleCB.isSelected() & shooleCB.isSelected()){
            checked = true;
        }

    }
}
