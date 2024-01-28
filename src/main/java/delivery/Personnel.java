package delivery;

import java.util.Date;

public class Personnel {
    private String fullName;
    private final String phoneNumber;
    private final String email;
    private final String identificationNumber;
    private final String vehicleType;

    // Constructors

    public Personnel(String fullName, Date dateOfBirth, String phoneNumber, String email,
                             String identificationNumber, String address, String city, String state,
                             String zipCode, String emergencyContact, String driverLicenseNumber,
                             Date driverLicenseExpiry, String vehicleType, String vehicleRegistration,
                             String workingHours, String daysAvailable, String preferredShifts,
                             String previousExperience, boolean backgroundCheckPassed) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.identificationNumber = identificationNumber;
        this.vehicleType = vehicleType;
    }

    // Getter and Setter methods for each attribute

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }



    @Override
    public String toString() {
        return "DeliveryPersonnel{" +
                "fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", identificationNumber='" + identificationNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                '}';
    }
}

