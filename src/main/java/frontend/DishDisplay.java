package frontend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class DishItem {
    private String name;
    private String imagePath;
    private double price;

    public DishItem(String name, String imagePath, double price) {
        this.name = name;
        this.imagePath = imagePath;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public double getPrice() {
        return price;
    }

    public String getPriced(String currency) {
        return price + " " + currency;
    }
}

public class DishDisplay {
    
    public DishDisplay(String restourantName, DishItem[] dishItems) {
        if (restourantName.length() == 0) {
            System.out.println("Error, Empty Restourant Name");
        }

        if (dishItems.length != 8) System.out.println("One window shows 8 dishes,");


        Dishes dish = new Dishes(restourantName, dishItems);
    }
}

class Dishes extends JFrame implements ActionListener{
    JPanel nav,topLeftPanel,topCenter1Panel,topCenter2Panel,topRightPanel,bottomLeftPanel,bottomCenter1Panel,bottomCenter2Panel,bottomRightPanel,back;
    JButton topLeftButton,topCenter1Button,topCenter2Button,topRightButton,bottomLeftButton,bottomCenter1Button,bottomCenter2Button,bottomRightButton,backButton;
    JLabel  restourantName1,menus,
            topLeftImage,topCenter1Image, topCenter2Image,topRightImage,bottomLeftImage,bottomCenter1Image,bottomCenter2Image,bottomRightImage,
            topLefttext,topCenter1text,e,topCenter2text,topRighttext,bottomLefttext,bottomCenter1text,bottomCenter2text,bottomRighttext,
            topLeftPrice,topCenter1Price,topCenter2Price,topRightPrice,bottomLeftPrice,bottomCenter1Price,bottomCenter2Price,bottomRightPrice;
    
    JSpinner topLeftSpinner, topCenter1Spinner, topCenter2Spinner, topRightSpinner, bottomLeftSpinner, bottomCenter1Spinner, bottomCenter2Spinner, bottomRightSpinner;
    JScrollPane scrollPane;



    public Dishes(String restourantName, DishItem[] dishItems){
        this.setSize(1366,768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        //this.setMinimumSize(new Dimension(1024 , 600));
        

        ImageIcon topLeftIcon=new ImageIcon(dishItems[0].getImagePath());
        ImageIcon topCenter1Icon= new ImageIcon(dishItems[1].getImagePath());
        ImageIcon topCenter2Icon= new ImageIcon(dishItems[2].getImagePath());
        ImageIcon topRightIcon= new ImageIcon(dishItems[3].getImagePath());
        ImageIcon bottomLeftIcon= new ImageIcon(dishItems[4].getImagePath());
        ImageIcon bottomCenter1Icon= new ImageIcon(dishItems[5].getImagePath());
        ImageIcon bottomCenter2Icon= new ImageIcon(dishItems[6].getImagePath());
        ImageIcon bottomRightcon= new ImageIcon(dishItems[7].getImagePath());
        ImageIcon backArrowIcon=new ImageIcon("javaimages/backArrow.jpeg");
        
        


        nav=new JPanel();
        nav.setBackground(Color.RED);
        nav.setPreferredSize(new Dimension(100,100));
        

        restourantName1=new JLabel(restourantName);
        restourantName1.setForeground(Color.white);
        restourantName1.setFont(new Font("MV Boli",Font.BOLD,45));
        restourantName1.setBounds(430,5,1000,75);

        menus=new JLabel("Menu items");
        menus.setForeground(Color.white);
        menus.setFont(new Font("MV Boli",Font.BOLD,25));
        menus.setBounds(550,55,500,45);

        topLeftPanel = new JPanel();
        topLeftPanel.setLayout(null); 
        topLeftPanel.setBackground(Color.WHITE);
        topLeftPanel.setBounds(15, 105, 300, 275); 

        topCenter1Panel=new JPanel();
        topCenter1Panel.setLayout(null);
        topCenter1Panel.setBackground(Color.WHITE);
        topCenter1Panel.setBounds(355,105,300,275);

        topCenter2Panel=new JPanel();
        topCenter2Panel.setLayout(null);
        topCenter2Panel.setBackground(Color.WHITE);
        topCenter2Panel.setBounds(680,105,300,275);

        topRightPanel=new JPanel();
        topRightPanel.setLayout(null);
        topRightPanel.setBounds(1010,105,300,275);
        topRightPanel.setBackground(Color.WHITE);

        bottomLeftPanel=new JPanel();
        bottomLeftPanel.setBackground(Color.WHITE);
        bottomLeftPanel.setLayout(null);
        bottomLeftPanel.setBounds(15,400,300,275);

        bottomCenter1Panel=new JPanel();
        bottomCenter1Panel.setBackground(Color.WHITE);
        bottomCenter1Panel.setLayout(null);
        bottomCenter1Panel.setBounds(355,400,300,275);

        bottomCenter2Panel=new JPanel();
        bottomCenter2Panel.setBackground(Color.WHITE);
        bottomCenter2Panel.setLayout(null);
        bottomCenter2Panel.setBounds(680,400,300,275);

        bottomRightPanel = new JPanel();
        bottomRightPanel.setBackground(Color.WHITE);
        bottomRightPanel.setLayout(null);
        bottomRightPanel.setBounds(1010,400,300,275);

        back = new JPanel();
        back.setBackground(Color.GRAY);
        back.setLayout(null);
        back.setBounds(1360,3,5,400);

        topLeftImage = new JLabel();
        topLeftImage.setIcon(topLeftIcon);
        topLeftImage.setBounds(80,0,300,145);

        topCenter1Image=new JLabel();
        topCenter1Image.setIcon(topCenter1Icon);
        topCenter1Image.setBounds(80,0,300,145);

        topCenter2Image= new JLabel();
        topCenter2Image.setIcon(topCenter2Icon);
        topCenter2Image.setBounds(45,0,300,145);

        topRightImage=new JLabel();
        topRightImage.setIcon(topRightIcon);
        topRightImage.setBounds(45,0,300,145);

        bottomLeftImage= new JLabel();
        bottomLeftImage.setIcon(bottomLeftIcon);
        bottomLeftImage.setBounds(91,0,300,145);

        bottomCenter1Image= new JLabel();
        bottomCenter1Image.setIcon(bottomCenter1Icon);
        bottomCenter1Image.setBounds(107,0,300,145);

        bottomCenter2Image= new JLabel();
        bottomCenter2Image.setIcon(bottomCenter2Icon);
        bottomCenter2Image.setBounds(107,0,300,145);

        bottomRightImage= new JLabel();
        bottomRightImage.setIcon(bottomRightcon);
        bottomRightImage.setBounds(107,0,300,145);


        topLefttext=new JLabel(dishItems[0].getName());
        topLefttext.setForeground(Color.red);
        topLefttext.setBounds(110,145,400,30);
        topLefttext.setFont(new Font("sans serif",Font.BOLD, 12));

        topCenter1text= new JLabel(dishItems[1].getName());
        topCenter1text.setForeground(Color.red);
        topCenter1text.setBounds(110,145,400,30);
        topCenter1text.setFont(new Font("sans serif",Font.BOLD,12));

        topCenter2text= new JLabel(dishItems[2].getName());
        topCenter2text.setForeground(Color.red);
        topCenter2text.setBounds(110,145,400,30);
        topCenter2text.setFont(new Font("sans serif",Font.BOLD,12));

        topRighttext= new JLabel(dishItems[3].getName());
        topRighttext.setForeground(Color.red);
        topRighttext.setBounds(110,145,400,30);
        topRighttext.setFont(new Font("sans serif",Font.BOLD,12));

        bottomLefttext=new JLabel(dishItems[4].getName());
        bottomLefttext.setForeground(Color.red);
        bottomLefttext.setBounds(110,145,400,30);
        bottomLefttext.setFont(new Font("sans serif",Font.BOLD,12));

        bottomCenter1text= new JLabel(dishItems[5].getName());
        bottomCenter1text.setForeground(Color.red);
        bottomCenter1text.setBounds(110,145,400,30);
        bottomCenter1text.setFont(new Font("sans serif",Font.BOLD,12));

        bottomCenter2text=new JLabel(dishItems[6].getName());
        bottomCenter2text.setForeground(Color.red);
        bottomCenter2text.setBounds(110,145,400,30);
        bottomCenter2text.setFont(new Font("sans serif",Font.BOLD,12));

        bottomRighttext=new JLabel(dishItems[7].getName());
        bottomRighttext.setForeground(Color.red);
        bottomRighttext.setBounds(110,145,400,30);
        bottomRighttext.setFont(new Font("sans serif",Font.BOLD,12));


        topLeftPrice=new JLabel(dishItems[0].getPriced("Br."));
        topLeftPrice.setForeground(Color.red);
        topLeftPrice.setBounds(110,165,400,30);
        topLeftPrice.setFont(new Font("sans serif",Font.BOLD,12));
        
        topCenter1Price=new JLabel(dishItems[1].getPriced("Br."));
        topCenter1Price.setForeground(Color.red);
        topCenter1Price.setBounds(110,165,400,30);
        topCenter1Price.setFont(new Font("sans serif",Font.BOLD,12));

        topCenter2Price=new JLabel(dishItems[2].getPriced("Br."));
        topCenter2Price.setForeground(Color.red);
        topCenter2Price.setBounds(110,165,400,30);
        topCenter2Price.setFont(new Font("sans serif",Font.BOLD,12));

        topRightPrice=new JLabel(dishItems[3].getPriced("Br."));
        topRightPrice.setForeground(Color.red);
        topRightPrice.setBounds(110,165,400,30);
        topRightPrice.setFont(new Font("sans serif",Font.BOLD,12));

        bottomLeftPrice=new JLabel(dishItems[4].getPriced("Br."));
        bottomLeftPrice.setForeground(Color.red);
        bottomLeftPrice.setBounds(110,165,400,30);
        bottomLeftPrice.setFont(new Font("sans serif",Font.BOLD,12));

        bottomCenter1Price=new JLabel(dishItems[5].getPriced("Br."));
        bottomCenter1Price.setForeground(Color.red);
        bottomCenter1Price.setBounds(110,165,400,30);
        bottomCenter1Price.setFont(new Font("sans serif",Font.BOLD,12));

        bottomCenter2Price=new JLabel(dishItems[6].getPriced("Br."));
        bottomCenter2Price.setForeground(Color.red);
        bottomCenter2Price.setBounds(110,165,400,30);
        bottomCenter2Price.setFont(new Font("sans serif",Font.BOLD,12));

        bottomRightPrice=new JLabel(dishItems[7].getPriced("Br."));
        bottomRightPrice.setForeground(Color.red);
        bottomRightPrice.setBounds(110,165,400,30);
        bottomRightPrice.setFont(new Font("sans serif",Font.BOLD,12));

        
        topLeftSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        topLeftSpinner.setBounds(110, 195, 50, 30);

        topCenter1Spinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        topCenter1Spinner.setBounds(110, 195, 50, 30);

        topCenter2Spinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        topCenter2Spinner.setBounds(110, 195, 50, 30);

        topRightSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        topRightSpinner.setBounds(110, 195, 50, 30);

        bottomLeftSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        bottomLeftSpinner.setBounds(110, 195, 50, 30);

        bottomCenter1Spinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        bottomCenter1Spinner.setBounds(110, 195, 50, 30);

        bottomCenter2Spinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        bottomCenter2Spinner.setBounds(110, 195, 50, 30);

        bottomRightSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        bottomRightSpinner.setBounds(110, 195, 50, 30);


        

        topLeftButton= new JButton("+ Add");
        topLeftButton.setFocusable(false);
        topLeftButton.addActionListener(this);
        topLeftButton.setBackground(new Color(255,0,204));
        topLeftButton.setBounds(110,235,100,30);

        topCenter1Button= new JButton("+ Add");
        topCenter1Button.setFocusable(false);
        topCenter1Button.addActionListener(this);
        topCenter1Button.setBackground(new Color(255,0,204));
        topCenter1Button.setBounds(110,235,100,30);

        topCenter2Button= new JButton("+ Add");
        topCenter2Button.setFocusable(false);
        topCenter2Button.addActionListener(this);
        topCenter2Button.setBackground(new Color(255,0,204));
        topCenter2Button.setBounds(110,235,100,30);

        topRightButton= new JButton("+ Add");
        topRightButton.setFocusable(false);
        topRightButton.addActionListener(this);
        topRightButton.setBackground(new Color(255,0,204));
        topRightButton.setBounds(110,235,100,30);

        bottomLeftButton= new JButton("+ Add");
        bottomLeftButton.setFocusable(false);
        bottomLeftButton.addActionListener(this);
        bottomLeftButton.setBackground(new Color(255,0,204));
        bottomLeftButton.setBounds(110,235,100,30);

        bottomCenter1Button= new JButton("+ Add");
        bottomCenter1Button.setFocusable(false);
        bottomCenter1Button.addActionListener(this);
        bottomCenter1Button.setBackground(new Color(255,0,204));
        bottomCenter1Button.setBounds(110,235,100,30);

        bottomCenter2Button= new JButton("+ Add");
        bottomCenter2Button.setFocusable(false);
        bottomCenter2Button.addActionListener(this);
        bottomCenter2Button.setBackground(new Color(255,0,204));
        bottomCenter2Button.setBounds(110,235,100,30);

        bottomRightButton= new JButton("+ Add");
        bottomRightButton.setFocusable(false);
        bottomRightButton.addActionListener(this);
        bottomRightButton.setBackground(new Color(255,0,204));
        bottomRightButton.setBounds(110,235,100,30);

        backButton= new JButton();
        backButton.setIcon(backArrowIcon);
        backButton.addActionListener(this);
        backButton.setBounds(0,0,45,25);
        backButton.setFocusable(false);
        backButton.setBackground(Color.white);






        topLeftPanel.add(topLeftImage);
        topLeftPanel.add(topLefttext);
        topLeftPanel.add(topLeftPrice);
        topLeftPanel.add(topLeftSpinner);
        topLeftPanel.add(topLeftButton);

        topCenter1Panel.add(topCenter1Image);
        topCenter1Panel.add(topCenter1text);
        topCenter1Panel.add(topCenter1Price);
        topCenter1Panel.add(topCenter1Spinner);
        topCenter1Panel.add(topCenter1Button);

        topCenter2Panel.add(topCenter2Image);
        topCenter2Panel.add(topCenter2text);
        topCenter2Panel.add(topCenter2Price);
        topCenter2Panel.add(topCenter2Spinner);
        topCenter2Panel.add(topCenter2Button);

        topRightPanel.add(topRightImage);
        topRightPanel.add(topRighttext);
        topRightPanel.add(topRightPrice);
        topRightPanel.add(topRightSpinner);
        topRightPanel.add(topRightButton);

        
        bottomLeftPanel.add(bottomLeftImage);
        bottomLeftPanel.add(bottomLefttext);
        bottomLeftPanel.add(bottomLeftPrice);
        bottomLeftPanel.add(bottomLeftSpinner);
        bottomLeftPanel.add(bottomLeftButton);

        bottomCenter1Panel.add(bottomCenter1Image);
        bottomCenter1Panel.add(bottomCenter1text);
        bottomCenter1Panel.add(bottomCenter1Price);
        bottomCenter1Panel.add(bottomCenter1Spinner);
        bottomCenter1Panel.add(bottomCenter1Button);

        bottomCenter2Panel.add(bottomCenter2Image);
        bottomCenter2Panel.add(bottomCenter2text);
        bottomCenter2Panel.add(bottomCenter2Price);
        bottomCenter2Panel.add(bottomCenter2Spinner);
        bottomCenter2Panel.add(bottomCenter2Button);

        bottomRightPanel.add(bottomRightImage);
        bottomRightPanel.add(bottomRighttext);
        bottomRightPanel.add(bottomRightPrice);
        bottomRightPanel.add(bottomRightSpinner);
        bottomRightPanel.add(bottomRightButton);




        //scrollPane = new JScrollPane(nav, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //scrollPane.setPreferredSize(new Dimension(300, 200));







        this.add(nav,BorderLayout.NORTH);
        this.add(topLeftPanel);
        this.add(topCenter1Panel);
        this.add(topCenter2Panel);
        this.add(topRightPanel);
        this.add(bottomLeftPanel);
        this.add(bottomCenter1Panel);
        this.add(bottomCenter2Panel);
        this.add(bottomRightPanel);
        this.add(back);
        //this.add(scrollPane);

              
        nav.setLayout(null);
        nav.add(restourantName1);
        nav.add(menus);
        nav.add(backButton);
    
     this.setVisible(true);   
    }
     restaurantItem[] restaurantItems={
            new restaurantItem("Boss Burger", "javaimages/Boss Burger.png"),
            new restaurantItem("Mamas Kitchen", "javaimages/mamasKitchen.png"),
            new restaurantItem("Mimis Addis restaurant and Lounge", "javaimages/mimisLounge.png"),
            new restaurantItem("Parkdale", "javaimages/parkdale.png"),
            new restaurantItem("Ethio China Restaurant","javaimages/ethioChina.png"),
            new restaurantItem("Chanoly Smoothie","javaimages/chanoly.png"),
            new restaurantItem("Bella ciao Chicken","javaimages/bellaCiao.png"),
            new restaurantItem("Amrogn Chicken","javaimages/amrogn.png"),
            new restaurantItem("backArrowIcon", "javaimages/backArrow.png")
        };
    

   @Override
   public void actionPerformed(ActionEvent e){
    if(e.getSource()==backButton){
        //bossButton.setEnabled(false);
        new RestaurantDisplay(restaurantItems);
        this.dispose();
    }
    if(e.getSource()== topLeftButton){
        //bossButton.setEnabled(false);
        new checkout();
        this.dispose();
    }
    if(e.getSource()==  topCenter1Button){
        //bossButton.setEnabled(false);
        new checkout();
        this.dispose();
    }  if(e.getSource()== topCenter2Button){
        //bossButton.setEnabled(false);
        new checkout();
        this.dispose();
    }  if(e.getSource()==  bottomLeftButton){
        //bossButton.setEnabled(false);
        new checkout();
        this.dispose();
    }  if(e.getSource()== bottomCenter1Button){
        //bossButton.setEnabled(false);
        new checkout();
        this.dispose();
    }  if(e.getSource()==bottomCenter2Button){
        //bossButton.setEnabled(false);
        new checkout();
        this.dispose();
    }  if(e.getSource()==  bottomRightButton){
        //bossButton.setEnabled(false);
        new checkout();
        this.dispose();
    } if(e.getSource()== topRightButton){
        //bossButton.setEnabled(false);
        new checkout();
        this.dispose();
    }
    
    
   }
    


}

