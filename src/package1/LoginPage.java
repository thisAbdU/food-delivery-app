package package1;
import java.util.HashMap;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class LoginPage implements ActionListener{

	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
    JButton signUpButton = new JButton("SignUp");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("userID:");
	JLabel userPasswordLabel = new JLabel("password:");
	JLabel messageLabel = new JLabel("This is a test");

    HashMap<String, String> loginInfo = new HashMap<String, String>();
    static IDandPassword newid = new IDandPassword();
    public LoginPage(HashMap<String,String> loginInfoOriginal) {
        loginInfo = loginInfoOriginal;
        
        userIDLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,125,75,75);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null, Font.ITALIC,25));

        userIDField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);

        loginButton.setBounds(125,200,100,25);
        loginButton.addActionListener(this);

        resetButton.setBounds(125,200,100,25);
        resetButton.addActionListener(this);

        signUpButton.setBounds(225,200,100,25);
        signUpButton.addActionListener(this);

        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(signUpButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==resetButton){
            userIDField.setText("");
            userPasswordField.setText("");
        }
        if (e.getSource()==signUpButton){
            SignUpPage signup = new SignUpPage();
        }
        if (e.getSource()==loginButton){
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if (loginInfo.containsKey(userID)){
                if (loginInfo.get(userID).equals(password)){
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login Successful");
                    Welcome welcomePage = new Welcome(userID);
                }
                else{
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("wrong password");
                    
                }
            }else{
                messageLabel.setForeground(Color.red);
                messageLabel.setText("username not found ");
                    
            }
        }

        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

   

}
