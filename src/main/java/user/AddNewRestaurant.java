package user;

import javax.swing.*;

import database.DatabaseConnection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.imageio.ImageIO;

public class AddNewRestaurant extends JFrame {
    private JTextField filePathField;
    JPanel nav, container;
    JLabel uploadrestaurantLabel,foodDeliveryApp;
    JButton uploadrrestaurantButton, confirm;
    JTextField nameField, LocationField;
    JLabel restaurantName,Location;

    public AddNewRestaurant() {
        
        super("Add New Restaurant");

        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection conn = databaseConnection.connect_to_database("food_delivery_app", "postgres", "1234");

        filePathField = new JTextField();

        JButton chooseFileButton = new JButton("Choose Image");

        chooseFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(AddNewRestaurant.this);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String filePath = selectedFile.getAbsolutePath();
                    filePathField.setText(filePath);

                    // Handle the image file (e.g., read and display, or upload to a server)
                    handleImageFile(selectedFile, conn);
                }
            }
        });

        setLayout(new FlowLayout());
        add(chooseFileButton);
        add(filePathField);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 100);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void handleImageFile1(File file) {
        try {
            // Read the image
            Image image = ImageIO.read(file);
    
            // Choose a directory for storing images
            File storageDirectory = new File("src/main/resources");
            if (!storageDirectory.exists()) {
                storageDirectory.mkdirs();
            }
    
            // Save the image file to the chosen directory
            File outputFile = new File(storageDirectory, file.getName());
            ImageIO.write((BufferedImage) image, "png", outputFile);
    
            JOptionPane.showMessageDialog(this, "Image saved: " + outputFile.getAbsolutePath(), "Image Saved", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleImageFile(File file, Connection conn) {
    try {
        // Read the image
        BufferedImage image = ImageIO.read(file);

        // Convert image to byte array
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        byte[] imageData = baos.toByteArray();

        // Save the byte array to the database (this is a simplified example)
        // Assume you have a database connection (conn) and a prepared statement (stmt)
        String sql = "INSERT INTO images (filename, image_data) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, file.getName());
            stmt.setBytes(2, imageData);
            stmt.executeUpdate();
        }

        JOptionPane.showMessageDialog(this, "Image saved to database", "Image Saved", JOptionPane.INFORMATION_MESSAGE);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AddNewRestaurant();
            }
        });
    }
}
