package package1;

import java.util.ArrayList;

public class User {
    private int userId;
    private String name;
    private String email;
    private String userName;
    private String password;
    private String phoneNumber;
    private String deliveryAddress;

    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    // Getter methods
    public int getUserId() {return userId;}
    public String getName() {return name;}
    public String getEmail() {return email;}
    public String getUserName() {return userName;}
    public String getPassword() {return password;}
    public String getPhoneNumber() {return phoneNumber;}
    public String getDeliveryAddress() {return deliveryAddress;}
}
