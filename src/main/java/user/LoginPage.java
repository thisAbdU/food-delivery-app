package user;

import javax.swing.*;

import database.UserDatabase;
import frontend.SampleReastaurantDashboard;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class LoginPage extends JFrame implements ActionListener {

    Container container = getContentPane();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JLabel label0 = new JLabel();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton signUpButton = new JButton("Sign Up");
    JCheckBox showPassword = new JCheckBox("Show Password");
    ImageIcon image = new ImageIcon("bg-login.png");


    public LoginPage() {

        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

        panel1.setBackground(Color.red);
        label0.setText("Campus Delivery");
        label0.setHorizontalTextPosition(JLabel.CENTER);
        label0.setVerticalTextPosition(JLabel.CENTER);
        label0.setForeground(new Color(0x121223));
        label0.setFont(new Font("MV Boli", Font.PLAIN,20));
        label0.setVerticalAlignment(JLabel.CENTER);
        label0.setHorizontalAlignment(JLabel.CENTER);
        label0.setBounds(75,10,300,300); // x,y,width, height


        this.setTitle("Login Form");
        this.setSize(1366, 738);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(false);
        this.setVisible(true);

    }

    public void setLayoutManager() {
        container.setLayout(new GridLayout());
        panel1.setLayout(null);
        panel2.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        signUpButton.setBounds(200, 300, 100, 30);

    }

    public void addComponentsToContainer() {
        container.add(panel1);
        container.add(panel2);
        panel1.add(label0);
        panel2.add(userLabel);
        panel2.add(passwordLabel);
        panel2.add(userTextField);
        panel2.add(passwordField);
        panel2.add(showPassword);
        panel2.add(loginButton);
        panel2.add(signUpButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        signUpButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==loginButton){
            String userName = userTextField.getText();
            String password = String.valueOf(passwordField.getPassword());

            UserDatabase user = new UserDatabase();
            Connection connectToDB = user.connect_to_database("food_delivery_app", "postgres", "1234");

            if (user.doesUserExist(connectToDB, "usersData", userName)){
                // we have found the user

                if (user.doesPasswordMatch(connectToDB, "usersData", userName, password)){
                     //then we will check for password match

                    if (user.isDeliveryGuy(connectToDB, "usersData", userName)){
                        new DeliveryManPage();
                    }else{
                        if (userName == "admin"){
                            String tag = "admin";
                        }else{
                            String tag = "non-admin";
                        }
                        SampleReastaurantDashboard.main(null);
                       
                    }
                    JOptionPane.showMessageDialog(null, "Welcome to Campus Delivery", "success!", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();    
                    
                }
                else{
                    JOptionPane.showMessageDialog(null, "Wrong password", "Password Mismatch", JOptionPane.ERROR_MESSAGE);
                    
                }
            }else{
                JOptionPane.showMessageDialog(null, "user not found", "user not found", JOptionPane.ERROR_MESSAGE);
                    
            }
        }
        if (e.getSource()==signUpButton){
            new signUpPage();
            this.dispose();
        }
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }


        }

}
}
