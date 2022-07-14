package com.fptu.android.userinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

public class Rate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        RateDialog rateDialog = new RateDialog(Rate.this);
        rateDialog.getWindow().setBackgroundDrawable(new ColorDrawable(getColor(R.color.white)));
        rateDialog.setCancelable(false);
        rateDialog.show();
        //rateDialog.dismiss();
    }
}