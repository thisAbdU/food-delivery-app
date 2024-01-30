package user;


import javax.swing.*;

public class signUpPage extends JFrame {
    public static void main(String[] args) {
        new signUpPage();
    }
    JTabbedPane tab = new JTabbedPane();
    
    signUpPage() {
        setSize(1366,738);
        setTitle("Login Form");
        tab.addTab("SignUp as a User", new userSignUp());
        tab.addTab("SignUp as a Delivery-man", new deliveryManSignUp());
        add(tab);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}