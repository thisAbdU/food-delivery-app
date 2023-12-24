package package1;
import java.util.*;

public class SignUp {
    private HashMap<String, String> signUpInfo;
    private String name;
    private String userName;
    private String email;
    private String phoneNumber;
    private String deliveryAddress;
    private String password;
    private String confirmPassword;

    SignUp(HashMap<String, String> signUpInfoOriginal) {
        signUpInfo = signUpInfoOriginal;
        name = signUpInfo.get("name");
        userName = signUpInfo.get("userName");
        email = signUpInfo.get("email");
        phoneNumber = signUpInfo.get("phoneNumber");
        deliveryAddress = signUpInfo.get("deliveryAddress");
        password = signUpInfo.get("password");
        confirmPassword = signUpInfo.get("confirmPassword");
    }

    public boolean validateSignUp() {    
        return (name.isEmpty() || userName.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() ||
                deliveryAddress.isEmpty() || password.isEmpty() || confirmPassword.isEmpty());
    }
    public boolean checkPasswordMatch() {
        return password.equals(confirmPassword);
    }
    public void fetchData(){
        User newUser = new User();

        newUser.setUserId(DataBase2.getLength());
        newUser.setName(name);
        newUser.setUserName(userName);
        newUser.setEmail(email);
        newUser.setPhoneNumber(phoneNumber);
        newUser.setPassword(password);
        newUser.setDeliveryAddress(deliveryAddress);

        DataBase2.addUser(newUser);
    }
}
