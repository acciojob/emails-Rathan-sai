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
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(this.password.equals(oldPassword)){
            if(newPassword.length()>=8 && containsCap(newPassword) && containsSmall(newPassword) && containsNum(newPassword) && containsChar(newPassword)){
                System.out.println("password changed.");
            }else{
                System.out.println("Create As per the requirements.");
            }
        }else{
            System.out.println("enter oldPassword correctly.");
        }
    }
    public boolean containsCap(String s){
        for(int i=0;i<s.length();i++){
            int n = (int) s.charAt(i);
            if(n >= 65 && n <= 90)
                return true;
        }
        return false;
    }
    public boolean containsSmall(String s){
        for(int i=0;i<s.length();i++){
            int n = (int) s.charAt(i);
            if(n >= 97 && n <= 122)
                return true;
        }
        return false;
    }
    public boolean containsNum(String s){
        for(int i=0;i<s.length();i++){
            int n = (int) s.charAt(i);
            if(n >= 48 && n <= 57)
                return true;
        }
        return false;
    }
    public boolean containsChar(String s){
        for(int i=0;i<s.length();i++) {
            int n = (int) s.charAt(i);
            if((n >= 33 && n <= 47) || (n >= 58 && n <= 64) || (n >= 91 && n <= 96) || (n >= 123 && n <= 236))
                return true;
        }
        return false;
    }
}
