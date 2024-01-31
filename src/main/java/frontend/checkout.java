package frontend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class checkout extends Restaurants {
    JTextField promo, location, sub, discount, service, fee, amount;
    JButton enter, confirm;
    JLabel checkout, deliver, subTotal, discountText, charge, delivery, total;

    public checkout() {
        super();

        this.setSize(1366, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JPanel container = new JPanel();
        container.setLayout(null); // Use null layout
        container.setBackground(Color.WHITE);

        // Checkout Label
        checkout = new JLabel("Checkout");
        checkout.setForeground(Color.WHITE);
        checkout.setFont(new Font("MV Boli", Font.BOLD, 45));
        checkout.setBounds(300, 10, 300, 50);
        container.add(checkout);

        // Promo code field and Enter button
        promo = new JTextField("promo code");
        promo.setBounds(100, 180, 200, 30);
        container.add(promo);

        enter = new JButton("Enter");
        enter.setBounds(310, 180, 70, 30);
        container.add(enter);

        // Deliver to field
        deliver = new JLabel("Deliver to:");
        deliver.setForeground(Color.RED);
        deliver.setBounds(100, 230, 100, 30);
        container.add(deliver);

        location = new JTextField("current location");
        location.setBounds(100, 260, 200, 30);
        container.add(location);

        // Subtotal field
        subTotal = new JLabel("Subtotal");
        subTotal.setForeground(Color.RED);
        subTotal.setBounds(100, 310, 100, 30);
        container.add(subTotal);

        sub = new JTextField();
        sub.setBounds(100, 340, 200, 30);
        container.add(sub);

        // Discount field
        discountText = new JLabel("Discount");
        discountText.setForeground(Color.RED);
        discountText.setBounds(100, 390, 100, 30);
        container.add(discountText);

        discount = new JTextField();
        discount.setBounds(100, 420, 200, 30);
        container.add(discount);

        // Service charge field
        charge = new JLabel("Service charge");
        charge.setForeground(Color.RED);
        charge.setBounds(100, 470, 150, 30);
        container.add(charge);

        service = new JTextField();
        service.setBounds(100, 500, 200, 30);
        container.add(service);

        // Confirm Order button
        confirm = new JButton("Confirm Order");
        confirm.setBounds(100, 550, 200, 35);
        container.add(confirm);

        this.add(container);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirm) {
            // Handle confirm button action
            System.out.println("Confirm button clicked");
        }
    }
}
