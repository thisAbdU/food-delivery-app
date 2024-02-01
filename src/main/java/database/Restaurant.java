package database;

public class Restaurant {
    private String restaurantName;
    private String restaurantImage;

    public Restaurant() {
    }

 
    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantImage() {
        return restaurantImage;
    }

    public void setRestaurantImage(String string) {
        this.restaurantImage = string;
    }
}
