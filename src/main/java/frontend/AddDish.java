package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

class AddDish extends Restaurants  {
    JPanel container;
    JLabel uploaddishLabel, dishName, price;
    JButton uploaddishButton, confirmDish;
    JTextField nameField, priceField;
   

    public AddDish() {
        super();
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());        

        container = new JPanel();
        container.setLayout(null);
        container.setBackground(Color.WHITE);
        container.setBounds(15, 105, 800, 600);

        dishName = new JLabel("Enter the Dish name");
        dishName.setForeground(Color.red);
        dishName.setBounds(15,130,200,30);
        dishName.setFont(new Font("sans serif",Font.BOLD,14));

        nameField = new JTextField();
        nameField.setBounds(200,130,170,30);

        price = new JLabel("Enter the price");
        price.setForeground(Color.red);
        price.setBounds(15,175,200,30);
        price.setFont(new Font("sans serif",Font.BOLD,14));

        priceField = new JTextField();
        priceField.setBounds(200,175,170,30);

        uploaddishLabel = new JLabel("Upload your logo:");
        uploaddishLabel.setBounds(15, 300, 150, 30);
        uploaddishLabel.setForeground(Color.red);
        uploaddishLabel.setFont(new Font("sans serif",Font.BOLD,14));

        uploaddishButton = new JButton("Upload");
        uploaddishButton.setFocusable(false);
        uploaddishButton.addActionListener(this);
        uploaddishButton.setBounds(170, 300, 100, 30);

        confirmDish = new JButton("Confirm");
        confirmDish.setFocusable(false);
        confirmDish.addActionListener(this);
        confirmDish.setBackground(new Color(255, 0, 204));
        confirmDish.setBounds(15, 430, 290, 35);

        container.add(uploaddishLabel);
        container.add(uploaddishButton);
        container.add(confirmDish);

        this.add(container);

        container.add(dishName);
        container.add(nameField);
        container.add(price);
        container.add(priceField);
        container.add(confirmDish);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == uploaddishButton) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                // Process the selected file
                System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            }
        } else if (e.getSource() == confirmDish) {
            // Handle confirm button action
            System.out.println("Confirm button clicked");
        }
    }

    public static void main(String[] args) {
        new AddDish();
    }
}
