package com.fptu.android.userinterface;

import java.io.Serializable;

public class Salon implements Serializable {

    private String salonID;
    private String salonAddress;

    public Salon() {
    }

    public Salon(String salonID, String salonAddress) {
        this.salonID = salonID;
        this.salonAddress = salonAddress;
    }

    public String getSalonID() {
        return salonID;
    }

    public void setSalonID(String salonID) {
        this.salonID = salonID;
    }

    public String getSalonAddress() {
        return salonAddress;
    }

    public void setSalonAddress(String salonAddress) {
        this.salonAddress = salonAddress;
    }
}
