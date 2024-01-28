package user;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JFrame {

    public WelcomePage() {
        // Set frame properties
        setTitle("Welcome to Campus Food Delivery. ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null); // Center the frame
        setResizable(false);
 
        add(new JLabel(new ImageIcon("static/welcomePageIcon.jpg")));

        JPanel mainPanel = new JPanel(new BorderLayout());
        setContentPane(mainPanel);

        // Create a welcome message label
        JLabel welcomeLabel = new JLabel("Welcome to My Project");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setForeground(Color.BLUE);

        // Create a description area
        JTextArea descriptionArea = new JTextArea(
                "This project aims to [provide a brief description of your project].\n"
                        + "It was developed by [Your Name] using [programming language/toolkit].\n"
                        + "Feel free to explore and click 'Next' to proceed to the login page."
        );
        descriptionArea.setEditable(false);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 18));
        descriptionArea.setForeground(Color.DARK_GRAY);

        // Create a panel for the description area
        JPanel descriptionPanel = new JPanel(new BorderLayout());
        descriptionPanel.add(descriptionArea, BorderLayout.CENTER);
        descriptionPanel.setBackground(Color.LIGHT_GRAY);

        // Create a Next button
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle button click (navigate to the login page)  
                LoginPage loginpage = new LoginPage();
                dispose(); // Close the welcome page 
            }
        });

        // Create a panel for the Next button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(nextButton);
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        // Add components to the main panel
        mainPanel.add(welcomeLabel, BorderLayout.NORTH);
        mainPanel.add(descriptionPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        
    }
}
