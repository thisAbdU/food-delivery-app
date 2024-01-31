package frontend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class restaurantItem{
    private String name;
    private String imagepath;
    public restaurantItem( String name,String imagepath){
        this.name=name;
        this.imagepath=imagepath;
    }
    public String getName(){
        return this.name;
    }
    public String getImagePath(){
        return this.imagepath;
    }
}
public class RestaurantDisplay{
    public RestaurantDisplay(restaurantItem[] restaurantsList){
        Restaurants restaurant=new Restaurants(restaurantsList);

    }
    
}
class Restaurants extends JFrame implements ActionListener{
    JPanel nav,bossPanel,mamasPanel,mimisPanel,parkdalePanel,chinaPanel,chanolyPanel,bellaciaoPanel,amrognPanel,back;
    JButton bossButton,mamasButton,mimisButton,parkdaleButton,chinaButton,chanolyButton,bellaciaoButton,amrognButton,backButton;
    JLabel  foodDeliveryApp,restuarnts,
            bossburImage,mamasImage, mimisImage,chinaImage,parkdaleImage,chanolyImage,amrognImage,bellaciaoImage,
            mimistext,parkdaletext,e,chinatext,chanolytext,bellaciaotext,amrogntext,bosstext,mamastext;
    JScrollPane scrollPane;
    ImageIcon backArrowIcon=new ImageIcon("javaimages/backArrow.jpeg");
        

    public Restaurants(){

        this.setSize(1366,768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());


        nav=new JPanel();
        nav.setBackground(Color.RED);
        nav.setPreferredSize(new Dimension(100,100));

        foodDeliveryApp=new JLabel("Campus Food delivery app");
        foodDeliveryApp.setForeground(Color.white);
        foodDeliveryApp.setFont(new Font("MV Boli",Font.BOLD,45));
        foodDeliveryApp.setBounds(430,5,1000,75);

        
        backButton= new JButton();
        backButton.setIcon(backArrowIcon);
        backButton.addActionListener(this);
        backButton.setBounds(0,0,50,30);
        backButton.setFocusable(false);
        backButton.setBackground(Color.white);

        this.add(nav,BorderLayout.NORTH);
        nav.setLayout(null);
        nav.add(foodDeliveryApp);
        nav.add(backButton);
        this.setVisible(true);  





    }


    public Restaurants(restaurantItem[]restaurantsList){
        this.setSize(1366,768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        //this.setMinimumSize(new Dimension(1024 , 600));


        

        ImageIcon bossBurIcon=new ImageIcon(restaurantsList[0].getImagePath());
        ImageIcon mamasIcon= new ImageIcon(restaurantsList[1].getImagePath());
        ImageIcon mimisIcon= new ImageIcon(restaurantsList[2].getImagePath());
        ImageIcon parkdaleIcon= new ImageIcon(restaurantsList[3].getImagePath());
        ImageIcon chinaIcon= new ImageIcon(restaurantsList[4].getImagePath());
        ImageIcon chanolyIcon= new ImageIcon(restaurantsList[5].getImagePath());
        ImageIcon bellaciaoIcon= new ImageIcon(restaurantsList[6].getImagePath());
        ImageIcon amrognIcon= new ImageIcon(restaurantsList[7].getImagePath());
        
        


        nav=new JPanel();
        nav.setBackground(Color.RED);
        nav.setPreferredSize(new Dimension(100,100));

        back=new JPanel();
        back.setBackground(Color.white);
        back.setLayout(null);
        back.setPreferredSize(new Dimension(1366,638));


        scrollPane= new JScrollPane();
        //JScrollPane scrollPane = new JScrollPane(restaurantsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        

        foodDeliveryApp=new JLabel("Campus Food delivery app");
        foodDeliveryApp.setForeground(Color.white);
        foodDeliveryApp.setFont(new Font("MV Boli",Font.BOLD,45));
        foodDeliveryApp.setBounds(430,5,1000,75);




        bossPanel = new JPanel();
        bossPanel.setLayout(null); 
        bossPanel.setBackground(Color.WHITE);
        bossPanel.setBounds(15, 10, 300, 275); 

        mamasPanel=new JPanel();
        mamasPanel.setLayout(null);
        mamasPanel.setBackground(Color.WHITE);
        mamasPanel.setBounds(355,10,300,275);

        mimisPanel=new JPanel();
        mimisPanel.setLayout(null);
        mimisPanel.setBackground(Color.WHITE);
        mimisPanel.setBounds(680,10,300,275);

        parkdalePanel=new JPanel();
        parkdalePanel.setLayout(null);
        parkdalePanel.setBounds(1010,10,300,275);
        parkdalePanel.setBackground(Color.WHITE);

        chinaPanel=new JPanel();
        chinaPanel.setBackground(Color.WHITE);
        chinaPanel.setLayout(null);
        chinaPanel.setBounds(15,300,300,275);

        chanolyPanel=new JPanel();
        chanolyPanel.setBackground(Color.WHITE);
        chanolyPanel.setLayout(null);
        chanolyPanel.setBounds(355,300,300,275);

        bellaciaoPanel=new JPanel();
        bellaciaoPanel.setBackground(Color.WHITE);
        bellaciaoPanel.setLayout(null);
        bellaciaoPanel.setBounds(680,300,300,275);

        amrognPanel=new JPanel();
        amrognPanel.setBackground(Color.WHITE);
        amrognPanel.setLayout(null);
        amrognPanel.setBounds(1010,300,300,275);

        


        

        bossburImage= new JLabel();
        bossburImage.setIcon(bossBurIcon);
        bossburImage.setBounds(30,0,300,200);

        mamasImage=new JLabel();
        mamasImage.setIcon(mamasIcon);
        mamasImage.setBounds(25,0,300,200);

        mimisImage= new JLabel();
        mimisImage.setIcon(mimisIcon);
        mimisImage.setBounds(65,0,300,200);

        parkdaleImage=new JLabel();
        parkdaleImage.setIcon(parkdaleIcon);
        parkdaleImage.setBounds(25,0,300,200);

        chinaImage= new JLabel();
        chinaImage.setIcon(chinaIcon);
        chinaImage.setBounds(30,0,300,200);

        chanolyImage= new JLabel();
        chanolyImage.setIcon(chanolyIcon);
        chanolyImage.setBounds(30,0,300,200);

        bellaciaoImage= new JLabel();
        bellaciaoImage.setIcon(bellaciaoIcon);
        bellaciaoImage.setBounds(30,0,300,200);

        amrognImage= new JLabel();
        amrognImage.setIcon(amrognIcon);
        amrognImage.setBounds(30,0,300,200);




        bosstext=new JLabel(restaurantsList[0].getName());
        bosstext.setForeground(Color.red);
        bosstext.setBounds(50,180,400,30);
        bosstext.setFont(new Font("sans serif",Font.BOLD,25));

        mamastext= new JLabel(restaurantsList[1].getName());
        mamastext.setForeground(Color.red);
        mamastext.setBounds(50,180,400,30);
        mamastext.setFont(new Font("sans serif",Font.BOLD,25));

        mimistext= new JLabel(restaurantsList[2].getName());
        mimistext.setForeground(Color.red);
        mimistext.setBounds(7,180,400,30);
        mimistext.setFont(new Font("sans serif",Font.BOLD,17));

        parkdaletext= new JLabel(restaurantsList[3].getName());
        parkdaletext.setForeground(Color.red);
        parkdaletext.setBounds(60,180,400,30);
        parkdaletext.setFont(new Font("sans serif",Font.BOLD,17));

        chinatext=new JLabel(restaurantsList[4].getName());
        chinatext.setForeground(Color.red);
        chinatext.setBounds(50,180,400,30);
        chinatext.setFont(new Font("sans serif",Font.BOLD,22));

        chanolytext= new JLabel(restaurantsList[5].getName());
        chanolytext.setForeground(Color.red);
        chanolytext.setBounds(50,180,400,30);
        chanolytext.setFont(new Font("sans serif",Font.BOLD,25));

        bellaciaotext=new JLabel(restaurantsList[6].getName());
        bellaciaotext.setForeground(Color.red);
        bellaciaotext.setBounds(50,180,400,30);
        bellaciaotext.setFont(new Font("sans serif",Font.BOLD,25));

        amrogntext=new JLabel(restaurantsList[7].getName());
        amrogntext.setForeground(Color.red);
        amrogntext.setBounds(50,180,400,30);
        amrogntext.setFont(new Font("sans serif",Font.BOLD,25));




        bossButton= new JButton("menu");
        bossButton.setFocusable(false);
        bossButton.addActionListener(this);
        bossButton.setBackground(new Color(255,0,204));
        bossButton.setBounds(70,225,100,30);

        mamasButton= new JButton("menu");
        mamasButton.setFocusable(false);
        mamasButton.setBackground(new Color(255,0,204));
        mamasButton.setBounds(40,225,100,30);

        mimisButton= new JButton("menu");
        mimisButton.setFocusable(false);
        mimisButton.setBackground(new Color(255,0,204));
        mimisButton.setBounds(90,225,100,30);

        parkdaleButton= new JButton("menu");
        parkdaleButton.setFocusable(false);
        parkdaleButton.setBackground(new Color(255,0,204));
        parkdaleButton.setBounds(60,225,100,30);

        chinaButton= new JButton("menu");
        chinaButton.setFocusable(false);
        chinaButton.setBackground(new Color(255,0,204));
        chinaButton.setBounds(70,225,100,30);

        chanolyButton= new JButton("menu");
        chanolyButton.setFocusable(false);
        chanolyButton.setBackground(new Color(255,0,204));
        chanolyButton.setBounds(70,225,100,30);

        bellaciaoButton= new JButton("menu");
        bellaciaoButton.setFocusable(false);
        bellaciaoButton.setBackground(new Color(255,0,204));
        bellaciaoButton.setBounds(70,225,100,30);

        amrognButton= new JButton("menu");
        amrognButton.setFocusable(false);
        amrognButton.addActionListener(this);
        amrognButton.setBackground(new Color(255,0,204));
        amrognButton.setBounds(70,225,100,30);


        backButton= new JButton();
        backButton.setIcon(backArrowIcon);
        backButton.addActionListener(this);
        backButton.setBounds(0,0,50,30);
        backButton.setFocusable(false);
        backButton.setBackground(Color.white);

        bossPanel.add(bossburImage);
        bossPanel.add(bosstext);
        bossPanel.add(bossButton);

        mamasPanel.add(mamasImage);
        mamasPanel.add(mamastext);
        mamasPanel.add(mamasButton);

        mimisPanel.add(mimisImage);
        mimisPanel.add(mimistext);
        mimisPanel.add(mimisButton);

        parkdalePanel.add(parkdaleImage);
        parkdalePanel.add(parkdaletext);
        parkdalePanel.add(parkdaleButton);

        
        chinaPanel.add(chinaImage);
        chinaPanel.add(chinatext);
        chinaPanel.add(chinaButton);

        chanolyPanel.add(chanolyImage);
        chanolyPanel.add(chanolytext);
        chanolyPanel.add(chanolyButton);

        bellaciaoPanel.add(bellaciaoImage);
        bellaciaoPanel.add(bellaciaotext);
        bellaciaoPanel.add(bellaciaoButton);

        amrognPanel.add(amrognImage);
        amrognPanel.add(amrogntext);
        amrognPanel.add(amrognButton);



        this.add(nav,BorderLayout.NORTH);
        back.add(bossPanel);
        back.add(mamasPanel);
        back.add(mimisPanel);
        back.add(parkdalePanel);
        back.add(chinaPanel);
        back.add(chanolyPanel);
        back.add(bellaciaoPanel);
        back.add(amrognPanel);
        back.add(scrollPane);
        scrollPane=new JScrollPane(back);
        this.add(scrollPane,BorderLayout.CENTER);

              
        nav.setLayout(null);
        nav.add(foodDeliveryApp);
        nav.add(backButton);
             
    
     this.setVisible(true);   
    }
    String restourantName = "Amrogn Chicken";
        DishItem[] dishItems = {
            new DishItem("Special Shawarma", "Images/special shawarma (1).jpg", 420.00),
            new DishItem("Chicken Shawarma", "Images/chicken shawarma.jpg", 325.00),
            new DishItem("Chicken Kabsa", "Images/chicken kabsa (1).jpg", 600.00),
            new DishItem("Fried Chicken", "Images/fried chicken (1).jpg", 590.00),
            new DishItem("Roasted Chicken", "Images/roasted chicken.jpg", 770.00),
            new DishItem("Chicken Wings", "Images/chicken wings (1).jpg", 470.00),
            new DishItem("Chicken Burger", "Images/chicken burger (1).jpg", 430.00),
            new DishItem("Chicken Mofu", "Images/chicken motu (1).jpg", 1530.00)
    };

   @Override
   public void actionPerformed(ActionEvent e){
    if(e.getSource()==amrognButton){
        new DishDisplay(restourantName, dishItems);
        this.dispose();
    }
   
    


}
}