package user;


import javax.swing.*;
import java.awt.*;

public class DeliveryManPage extends JFrame {

    public DeliveryManPage() {
        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1366, 728);
        setLocationRelativeTo(null); // Center the frame
        setResizable(false);
 

        JPanel mainPanel = new JPanel(new BorderLayout());
        setContentPane(mainPanel);

        // Create a welcome message label
        JLabel welcomeLabel = new JLabel("Delivery man task tracker page");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setForeground(Color.BLUE);

        // Create a description area
        JTextArea descriptionArea = new JTextArea(
                "this is the delivery mans single page.\n"
                        + "It containes a list of delivery tasks of the delivery man."
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
    
    

        // Create a panel for the Next button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        // Add components to the main panel
        mainPanel.add(welcomeLabel, BorderLayout.NORTH);
        mainPanel.add(descriptionPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }


}
