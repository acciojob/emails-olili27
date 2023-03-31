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

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){

       if (oldPassword.equals(this.password)) {
           if (isValid(newPassword)) {
               this.password = newPassword;
           }
       }
    }

    public boolean isValid(String newPassword) {

        boolean hasUpperCase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        if (newPassword.length() < 8) return false;

        for (int index = 0; index < newPassword.length(); index++) {
            char ch = newPassword.charAt(index);

            if (Character.isUpperCase(ch)) hasUpperCase = true;
            if (Character.isLowerCase(ch)) hasLowercase = true;
            if (Character.isDigit(ch)) hasDigit = true;
            if (!Character.isLetterOrDigit(ch)) hasSpecialChar = true;
        }

        return hasDigit && hasSpecialChar && hasLowercase && hasUpperCase;
    }
}
