package frontend;

import javax.imageio.ImageIO;
import javax.swing.*;

import database.DatabaseConnection;
import database.DishDatabase;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;


public class AddNewDish extends JFrame implements ActionListener {
    JPanel nav, container;
    JLabel uploadDishLabel,foodDeliveryApp;
    JButton uploadDishButton, confirm;
    JTextField nameField, LocationField;
    JLabel dishName,Location;
    public File selectedFile = null;


    public AddNewDish() {
        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());


        foodDeliveryApp=new JLabel("Campus Food delivery app");
        foodDeliveryApp.setForeground(Color.white);
        foodDeliveryApp.setFont(new Font("MV Boli",Font.BOLD,45));
        foodDeliveryApp.setBounds(430,5,1000,75);

        nav = new JPanel();
        nav.setBackground(Color.RED);
        nav.setPreferredSize(new Dimension(100, 100));

        nav.add(foodDeliveryApp);

        container = new JPanel();
        container.setLayout(null);
        container.setBackground(Color.WHITE);
        container.setBounds(15, 105, 800, 600);

        dishName=new JLabel("Enter the dish name");
        dishName.setForeground(Color.red);
        dishName.setBounds(15,130,200,30);
        dishName.setFont(new Font("sans serif",Font.BOLD,14));

        nameField=new JTextField();
        nameField.setBounds(280,130,170,30);

        uploadDishLabel = new JLabel("Upload your logo:");
        uploadDishLabel.setBounds(15, 200, 150, 30);
        uploadDishLabel.setForeground(Color.red);
        uploadDishLabel.setFont(new Font("sans serif",Font.BOLD,14));

        uploadDishButton = new JButton("Upload");
        uploadDishButton.setFocusable(false);
        uploadDishButton.addActionListener(this);
        uploadDishButton.setBounds(170, 200, 100, 30);

        confirm = new JButton("Confirm");
        confirm.setFocusable(false);
        confirm.addActionListener(this);
        confirm.setBackground(new Color(255, 0, 204));
        confirm.setBounds(15, 330, 290, 35);

        container.add(uploadDishLabel);
        container.add(uploadDishButton);
        container.add(confirm);

        this.add(nav, BorderLayout.NORTH);
        this.add(container);


        container.add( dishName);
        container.add(nameField);
        container.add( confirm);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        DishDatabase DishDB = new DishDatabase();
        Connection conn = databaseConnection.connect_to_database("food_delivery_app", "postgres", "1234");

        if(e.getSource() == uploadDishButton) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(AddNewDish.this);

            if (result == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
                
                JOptionPane.showMessageDialog(this, "Image uploaded: ", "Image uploaded", JOptionPane.INFORMATION_MESSAGE);

            }
        } else if (e.getSource() == confirm) {
            if (nameField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in the Dish Name.", "Incomplete Information", JOptionPane.WARNING_MESSAGE);
            } else if (selectedFile != null) {
                try {
                    Image image = ImageIO.read(selectedFile);
            
                    File storageDirectory = new File("src/main/resources/images");
                    if (!storageDirectory.exists()) {
                        storageDirectory.mkdirs();
                    }
            
                    File outputFile = new File(storageDirectory, selectedFile.getName());
                    ImageIO.write((BufferedImage) image, "png", outputFile);

                    DishDB.insert_dish_row(conn, );(conn, "Dish", nameField.getText(), "/images/"+selectedFile.getName());
                    this.dispose();
                    
                } catch (Exception ex) {
                    System.out.println("unable to upload image ");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Please upload the image.", "Incomplete Information", JOptionPane.WARNING_MESSAGE);

            }
        }
    }

    public static void main(String[] args) {
        new AddNewDish();
    }
}