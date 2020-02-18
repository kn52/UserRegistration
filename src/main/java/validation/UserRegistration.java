package validation;

public class UserRegistration {
    private String NAME_REGEX="^[A-Z]{1}[a-z]{2,}$";
    private String EMAIL_REGEX="^\\w{3,}([-._+]\\w+)?@\\w+.[a-z]{2,4}([.][a-z]{2,4})?$";
    private String PHONE_NUMBER_REGEX="^\\d{2,3}\\s?\\d{10}$";

    public static void main(String[] args) {
        System.out.println("Welcome to user registration problem");
    }
    public boolean validateFirstName(String fname) { return fname.matches(NAME_REGEX); }

    public boolean validateLastName(String lname) { return lname.matches(NAME_REGEX); }

    public boolean validateEmail(String email) { return email.matches (EMAIL_REGEX); }

    public boolean validatePhoneNumber(String pnumber){ return pnumber.matches(PHONE_NUMBER_REGEX) ;  }

    public boolean validatePassword(String password){
        if (password.length()>=8)
            return true;
        else
            return false;
    }
}
