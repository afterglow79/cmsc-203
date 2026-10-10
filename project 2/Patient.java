// Written by Kelvin Zimmerman on 9 Oct. 2026 for CMSC 203
// this class represents a patient with personal and contact information, including emergency contact details.
// It provides methods to build full names, addresses, and emergency contact summaries, as well as validation for phone numbers and address updates.


public class Patient {
    private String firstName;
    private String middleName;
    private String lastName;
    private String emergencyContact;
    private String emergencyContactPhone;
    private String address;
    private String zipCode;
    private String city;
    private String state;
    private String phoneNumber;

    public Patient() {}

    public Patient(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
    public Patient(String firstName, String middleName, String lastName, String address, String zipCode, String city, String state, String phoneNumber, String emergencyContact, String emergencyContactPhone) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.emergencyContact = emergencyContact;
        this.emergencyContactPhone = emergencyContactPhone;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }

    public String buildFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    public String buildAddress() {
        return address + " " + city + " " + state + " " + zipCode;
    }

    public String buildEmergencyContact() {
        return emergencyContact + " " + emergencyContactPhone;
    }

    public String toString(){
        String name = buildFullName();
        String address = buildAddress();
        String emergency = buildEmergencyContact();
        String out = "Patient Name: " + name + "\nAddress: " + address + "\nPhone Number: " + phoneNumber + "\nEmergency Contact: " + emergency;
        return out;
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        // Check if the phone number is 12 chars long, only digits, with dashes at positions 3 and 7
        if (phoneNumber.length() != 12) {
            return false;
        }
        if (phoneNumber.charAt(3) != '-' || phoneNumber.charAt(7) != '-') {
            return false;
        }
        for (int i = 0; i < phoneNumber.length(); i++) {
            char c = phoneNumber.charAt(i);
            if (i == 3 || i == 7) {
                continue; // dash positions already verified above
            }
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidEmergencyPhoneNumber(String emergencyContactPhone){
        return isValidPhoneNumber(emergencyContactPhone);
    }

    public boolean hasSameCityState(String city, String state){
        return this.city.equalsIgnoreCase(city) && this.state.equalsIgnoreCase(state);
    }

    public String getLastFirstMiddle(){
        return lastName + ", " + firstName + " " + middleName;
    }

    public void updateAddress(String street, String city, String state, String zip){
        this.address = street;
        this.zipCode = zip;
        this.city = city;
        this.state = state;
    }

    public String getContactSummary(){
        return "Patient: " + buildFullName() + "\nPhone: " + phoneNumber + "\nEmergency Contact: " + buildEmergencyContact();
    }
}