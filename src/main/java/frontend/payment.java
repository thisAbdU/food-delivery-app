package frontend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
class payment extends JFrame implements ActionListener {
    JPanel nav,container;
    JTextField number;
    JButton payment;
    JRadioButton cbe,teleBirr;
    JLabel paymentText;
    

    public payment(){
        this.setSize(1366,768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
    
        
        nav=new JPanel();
        nav.setBackground(Color.RED);
        nav.setPreferredSize(new Dimension(100,100));

        paymentText=new JLabel("Payment");
        paymentText.setForeground(Color.white);
        paymentText.setFont(new Font("MV Boli",Font.BOLD,45));
        paymentText.setBounds(430,5,1000,75);

        container=new JPanel();
        container.setLayout(null); 
        container.setBackground(Color.WHITE);
        container.setBounds(15, 105, 800, 600);

        
        cbe = new JRadioButton("CBE Bank Transfer");
        cbe.setBounds(15,15,200,30);
        cbe.setForeground(Color.red);


        teleBirr = new JRadioButton("TeleBirr");
        teleBirr.setBounds(15,75,200,30);
        teleBirr.setForeground(Color.red);

        // Add radio buttons to a ButtonGroup so that only one can be selected at a time
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(cbe);
        buttonGroup.add(teleBirr);

        
        number=new JTextField("Acc no. or Phone no.");
        number.setBounds(15,135,200,35);

        payment=new JButton("Finish Payment");
        payment.setFocusable(false);
        payment.addActionListener(this);
        payment.setBackground(new Color(255,0,204));
        payment.setBounds(15,200,290,35);

        container.add(cbe);
        container.add(teleBirr);
        container.add(number);
        container.add(payment);

        this.add(nav,BorderLayout.NORTH);
        this.add(container);

        nav.setLayout(null);
        nav.add(paymentText);


    this.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
