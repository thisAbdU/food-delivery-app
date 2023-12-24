package package1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.*;

public class SignUpPage implements ActionListener{

	JFrame frame = new JFrame();
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

	SignUpPage(){
		
		titleLabel.setBounds(0, 0, 200, 35);
        titleLabel.setFont(new Font(null, Font.PLAIN, 25));
        titleLabel.setText("Sign Up");
        nameLabel.setBounds(50, 100, 200, 25);
        emailLabel.setBounds(50, 150, 200, 25);  // Adjusted Y-coordinate
        userNameLabel.setBounds(50, 200, 200, 25);  // Adjusted Y-coordinate
        phoneNumberLabel.setBounds(50, 250, 200, 25);  // Adjusted Y-coordinate
        deliveryAddressLabel.setBounds(50, 300, 200, 25);  // Adjusted Y-coordinate
        userPasswordLabel.setBounds(50, 350, 200, 25);  // Adjusted Y-coordinate
        confirmPasswordLabel.setBounds(50, 400, 200, 25);  // Adjusted Y-coordinate

        nameField.setBounds(125, 100, 200, 25); 
        emailField.setBounds(125, 150, 200, 25);
        userNameField.setBounds(150, 200, 200, 25);
        phoneNumberField.setBounds(175, 250, 200, 25);
        deliveryAddressField.setBounds(175, 300, 200, 25);
        userPasswordField.setBounds(175, 350, 200, 25);
        confirmPasswordField.setBounds(200, 400, 200, 25);

		frame.add(titleLabel);
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(emailLabel);
        frame.add(userNameLabel);
        frame.add(phoneNumberLabel);
        frame.add(deliveryAddressLabel);
        frame.add(userPasswordLabel);
        frame.add(confirmPasswordLabel);

        frame.add(nameField);
        frame.add(emailField);
        frame.add(userNameField);
        frame.add(phoneNumberField);
        frame.add(deliveryAddressField);
        frame.add(userPasswordField);
        frame.add(confirmPasswordField);
        
        frame.add(signUpButton);
        frame.add(resetButton);
        signUpButton.setBounds(100, 450, 100, 25);
        resetButton.setBounds(250, 450, 100, 25);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setLayout(null);
		frame.setVisible(true);

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
        // Retrieve the entered values from text fields
            HashMap<String, String> signUpData = new HashMap<String, String>() {{
                put("name", nameField.getText());
                put("userName", userNameField.getText());
                put("email", emailField.getText());
                put("phoneNumber", phoneNumberField.getText());
                put("deliveryAddress", deliveryAddressField.getText());
                put("password", String.valueOf(userPasswordField.getPassword()));
                put("confirmPassword", String.valueOf(confirmPasswordField.getPassword()));
            }};

            SignUp signup = new SignUp(signUpData);
        
            // Validate if all fields are filled
            if (signup.validateSignUp()) {
                JOptionPane.showMessageDialog(null, "Please fill in all the fields.", "Incomplete Information", JOptionPane.WARNING_MESSAGE);
            } else if (signup.checkPasswordMatch()) {
                // Passwords match, proceed to the next page
                titleLabel.setForeground(Color.green);
                JOptionPane.showMessageDialog(null, "Successfully Registered", "success!", JOptionPane.INFORMATION_MESSAGE);
                signup.fetchData();
                Welcome welcomePage = new Welcome(signUpData.get("name"));
            } else {
                JOptionPane.showMessageDialog(null, "Passwords do not match.", "Password Mismatch", JOptionPane.ERROR_MESSAGE);
            }
            
    }
    }
}