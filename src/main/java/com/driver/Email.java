package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){

        if (oldPassword.equals(this.password) && newPassword.length() >= 8) {
            boolean hasUpperCase = false;
            boolean hasLowercase = false;
            boolean hasDigit = false;
            boolean hasSpecialChar = false;

            checkConditions(newPassword, hasUpperCase, hasLowercase, hasDigit, hasSpecialChar);

            if (hasDigit && hasLowercase && hasUpperCase && hasSpecialChar) {
                this.password =newPassword;
            }
        }
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    }

    public void checkConditions(String password, boolean hasUpperCase, boolean hasLowercase, boolean hasDigit, boolean hasSpecialChar) {
        for (int index = 0; index < password.length(); index++) {
            char ch = password.charAt(index);

            if (Character.isUpperCase(ch)) hasUpperCase = true;
            if (Character.isLowerCase(ch)) hasLowercase = true;
            if (Character.isDigit(ch)) hasDigit = true;
            if (!Character.isLetterOrDigit(ch)) hasSpecialChar = true;
        }
    }
}
