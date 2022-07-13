package com.fptu.android.userinterface;

public class User {
    private String userName;
    private String email, password,phone;

    public User() {

    }

    public User(String userName, String email, String password,String phone) {
        this.userName = userName;
        this.email = email;
        this.password= password;
        this.phone = phone;
    }

    public String getName() {
        return userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public void setPassword(String password) {
        this.password = password;
    }
}
