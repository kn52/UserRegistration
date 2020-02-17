package validation;

public class UserRegistration {
    private String NAME_REGEX="^[A-Z]{1}[a-z]{2,}$";
    private String EMAIL_REGEX="^\\w{3,}([-._+]\\w+)?@\\w+.[a-z]{2,4}([.][a-z]{2,4})?$";

    public static void main(String[] args) {
        System.out.println("Welcome to user registration problem");
    }
    public boolean validateFirstName(String fname) { return fname.matches(NAME_REGEX); }

    public boolean validateLastName(String lname) { return lname.matches(NAME_REGEX); }

    public Boolean validateEmail(String email) { return email.matches (EMAIL_REGEX); }
}