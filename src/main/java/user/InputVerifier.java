package user;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputVerifier {

    public static boolean isValidEmail(String email) {
        // Use a simple regex for email validation
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static boolean isValidPassword(String password) {
        // Use a simple regex for email validation
        return password.length() >= 8;
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Use a regular expression for phone number validation
        // This example allows numbers with optional spaces, dashes, and parentheses
        // Example valid formats: (123) 456-7890, 123-456-7890, 1234567890, 123 456 7890
        String phoneRegex = "^(\\(?\\d{3}\\)?[-.\\s]?\\d{3}[-.\\s]?\\d{4})$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
