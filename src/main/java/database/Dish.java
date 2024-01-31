package database;

public class Dish {
    private String DishName;
    private String DishImage;

    public Dish() {
    }

 
    public String getDishName() {
        return DishName;
    }

    public void setDishName(String DishName) {
        this.DishName = DishName;
    }

    public String getDishImage() {
        return DishImage;
    }

    public void setDishImage(String string) {
        this.DishImage = string;
    }
}
