package frontend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class checkout extends JFrame implements ActionListener{
    JPanel nav,container;
    JTextField promo,location,sub,discount,service,fee,amount;
    JButton enter,confirm;
    JLabel checkout,deliver,subTotal,discountText,charge,delivery,total;
    JSeparator separator;

    public checkout(){
        this.setSize(1366,768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        nav=new JPanel();
        nav.setBackground(Color.RED);
        nav.setPreferredSize(new Dimension(100,100));


        checkout=new JLabel("checkout");
        checkout.setForeground(Color.white);
        checkout.setFont(new Font("MV Boli",Font.BOLD,45));
        checkout.setBounds(430,5,1000,75);

        container= new JPanel();
        container.setLayout(null); 
        container.setBackground(Color.WHITE);
        container.setBounds(15, 105, 800, 600);

        promo=new JTextField("promo code");
        promo.setBounds(15,15,200,35);

        enter=new JButton("Enter");
        enter.setFocusable(false);
        enter.addActionListener(this);
        enter.setBackground(new Color(255,0,204));
        enter.setBounds(200,15,70,35);

        deliver=new JLabel("Deliver to:");
        deliver.setForeground(Color.red);
        deliver.setBounds(15,50,100,30);
        deliver.setFont(new Font("sans serif",Font.BOLD,12));

        location=new JTextField("current location");
        location.setBounds(15,80,200,35);

        subTotal=new JLabel("sub total");
        subTotal.setForeground(Color.red);
        subTotal.setBounds(15,130,150,30);
        subTotal.setFont(new Font("sans serif",Font.BOLD,14));

        sub=new JTextField();
        sub.setBounds(150,130,170,30);

        discountText=new JLabel("discount");
        discountText.setForeground(Color.red);
        discountText.setBounds(15,175,150,30);
        discountText.setFont(new Font("sans serif",Font.BOLD,14));

        discount=new JTextField();
        discount.setBounds(150,175,170,30);

        charge=new JLabel("service charge");
        charge.setForeground(Color.red);
        charge.setBounds(15,220,150,30);
        charge.setFont(new Font("sans serif",Font.BOLD,14));

        service=new JTextField();
        service.setBounds(150,220,170,30);

        delivery=new JLabel("Delivery fee");
        delivery.setForeground(Color.red);
        delivery.setBounds(15,265,150,30);
        delivery.setFont(new Font("sans serif",Font.BOLD,14));

        fee=new JTextField();
        fee.setBounds(150,265,170,30);
 
        separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setBounds(15, 310, 305, 2);
        separator.setForeground(Color.black);

        total=new JLabel("Total Amount");
        total.setForeground(Color.red);
        total.setBounds(30,327,160,30);
        total.setFont(new Font("sans serif",Font.BOLD,16));

        amount=new JTextField();
        amount.setBounds(160,327,170,30);

        confirm=new JButton("Confirm Order");
        confirm.setFocusable(false);
        confirm.addActionListener(this);
        confirm.setBackground(new Color(255,0,204));
        confirm.setBounds(15,430,290,35);



        container.add(promo);
        container.add(enter);
        container.add(deliver);
        container.add(location);
        container.add(subTotal);
        container.add(sub);
        container.add(discountText);
        container.add(discount);
        container.add(charge);
        container.add(service);
        container.add(delivery);
        container.add(fee);
        container.add(separator);
        container.add(total);
        container.add(amount);
        container.add(confirm);

        this.add(nav,BorderLayout.NORTH);
        this.add(container);

        nav.setLayout(null);
        nav.add(checkout);

    this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==confirm){
            new payment();
            this.dispose();

        }
    }

}
