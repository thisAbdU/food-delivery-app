package restuarant;

public class SampleReastaurantDashboard {
    public static void main(String[] args) {
        restaurantItem[] restaurantItems={
            new restaurantItem("Boss Burger", "/images/Boss Burger.png"),
            new restaurantItem("Mamas Kitchen", "/images/mamasKitchen.png"),
            new restaurantItem("Mimis Addis restaurant and Lounge", "/images/mimisLounge.png"),
            new restaurantItem("Parkdale", "/images/parkdale.png"),
            new restaurantItem("Ethio China Restaurant","/images/ethioChina.png"),
            new restaurantItem("Chanoly Smoothie","/images/chanoly.png"),
            new restaurantItem("Bella ciao Chicken","/images/bellaCiao.png"),
            new restaurantItem("Amrogn Chicken","/images/amrogn.png"),
            //ew restaurantItem("backArrowIcon", "javaimages/backArrow.png")
        };
        new RestaurantDisplay(restaurantItems);
    }
    
}
