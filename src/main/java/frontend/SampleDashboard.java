package frontend;

public class SampleDashboard {
    public static void main(String[] args) {
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

    new DishDisplay(restourantName, dishItems);
    }
}
