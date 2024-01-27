package com.food.frontend;

import javax.swing.*;
import java.awt.*;

public class FrontPage extends JFrame {
    FrontPage() {
        this.setTitle("Campus Delivery");
        this.setResizable(false);
        this.setSize(1366, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.white);
        this.setVisible(true);

        ImageIcon logo = new ImageIcon("logo-black.png");
        this.setIconImage(logo.getImage());
    }
}
