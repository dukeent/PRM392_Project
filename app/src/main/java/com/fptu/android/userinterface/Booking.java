package com.fptu.android.userinterface;

public class Booking {
    private String salonAddress;
    private String date;
    private String slot;
    private String userID;

    public Booking(String salonAddress, String date, String slot, String userID) {
        this.salonAddress = salonAddress;
        this.date = date;
        this.slot = slot;
        this.userID = userID;
    }

    public Booking() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getSalonAddress() {
        return salonAddress;
    }

    public void setSalonAddress(String salonAddress) {
        this.salonAddress = salonAddress;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }
}
