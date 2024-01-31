package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

class AddRestaurant extends Restaurants {
    JPanel container;
    JLabel uploadrestaurantLabel, restaurantName, Location;
    JButton uploadrrestaurantButton, confirm;
    JTextField nameField, LocationField;

    public AddRestaurant() {
        super();

        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        container = new JPanel();
        container.setLayout(null);
        container.setBackground(Color.WHITE);
        container.setBounds(15, 105, 800, 600);

        restaurantName = new JLabel("Enter the restaurant name");
        restaurantName.setForeground(Color.red);
        restaurantName.setBounds(15, 130, 200, 30);
        restaurantName.setFont(new Font("sans serif", Font.BOLD, 14));

        nameField = new JTextField();
        nameField.setBounds(200, 130, 170, 30);

        Location = new JLabel("Enter the Location");
        Location.setForeground(Color.red);
        Location.setBounds(15, 175, 200, 30);
        Location.setFont(new Font("sans serif", Font.BOLD, 14));

        LocationField = new JTextField();
        LocationField.setBounds(200, 175, 170, 30);

        uploadrestaurantLabel = new JLabel("Upload your logo:");
        uploadrestaurantLabel.setBounds(15, 300, 150, 30);
        uploadrestaurantLabel.setForeground(Color.red);
        uploadrestaurantLabel.setFont(new Font("sans serif", Font.BOLD, 14));

        uploadrrestaurantButton = new JButton("Upload");
        uploadrrestaurantButton.setFocusable(false);
        uploadrrestaurantButton.addActionListener(this);
        uploadrrestaurantButton.setBounds(170, 300, 100, 30);

        confirm = new JButton("Confirm");
        confirm.setFocusable(false);
        confirm.addActionListener(this);
        confirm.setBackground(new Color(255, 0, 204));
        confirm.setBounds(15, 430, 290, 35);

        container.add(uploadrestaurantLabel);
        container.add(uploadrrestaurantButton);
        container.add(confirm);

        this.add(container);

        container.add(restaurantName);
        container.add(nameField);
        container.add(Location);
        container.add(LocationField);
        container.add(confirm);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == uploadrrestaurantButton) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                // Process the selected file
                System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            }
        } else if (e.getSource() == confirm) {
            // Handle confirm button action
            System.out.println("Confirm button clicked");
        }
    }

    public static void main(String[] args) {
        new AddRestaurant();
    }
}
