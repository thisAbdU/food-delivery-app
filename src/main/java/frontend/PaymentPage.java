package frontend;

import javax.swing.*;
import java.awt.*;

public class PaymentPage extends FrontPage {

    PaymentPage() {

        JLabel label = new JLabel();
        label.setText("Deliver To:");
        label.setBounds(800, 246, 81, 19);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("MV Boli", Font.PLAIN, 20));

        this.getContentPane().setBackground(new Color(0xD9D9D9));
        this.add(label);
    }






}
