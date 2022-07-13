package com.fptu.android.userinterface;

public class Booking {
    private String salonAddress;
    private String date;
    private String slot;

    public Booking() {
    }

    public Booking(String salonAddress, String date, String slot) {
        this.salonAddress = salonAddress;
        this.date = date;
        this.slot = slot;
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
