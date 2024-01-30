package user;


public class DeliveryMan {
    private int deliveryManId;
    private String name;
    private String email;
    private String userName;
    private String password;
    private String phoneNumber;
    private String vehicleNumberPlate;
    private String status;
    
    public void setDeliveryManId(int deliveryManId) {
        this.deliveryManId = deliveryManId;
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
    public void setVehicleNumberPlate(String vehiclePlate) {
        this.vehicleNumberPlate = vehiclePlate;
    }
    

    // Getter methods
    public int getUserId() {return deliveryManId;}
    public String getName() {return name;}
    public String getEmail() {return email;}
    public String getUserName() {return userName;}
    public String getPassword() {return password;}
    public String getPhoneNumber() {return phoneNumber;}
    public String getDeliveryAddress() {return vehicleNumberPlate;}
    public void setStatus(String status) {
    }
}
