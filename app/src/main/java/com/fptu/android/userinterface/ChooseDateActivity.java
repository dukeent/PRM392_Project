package com.fptu.android.userinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ChooseDateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_date);
        BindingView();
    }
    private void BindingView(){
        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
        else {
            Salon salon = (Salon) bundle.get("Salon");
            TextView textView = findViewById(R.id.salonAddress);
            textView.setText("You are choosing: " + salon.getSalonAddress());
        }
    }
}