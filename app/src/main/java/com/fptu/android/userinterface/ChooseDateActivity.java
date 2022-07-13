package com.fptu.android.userinterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ChooseDateActivity extends AppCompatActivity {

    private RecyclerView rcv_TimeSlot;
    private ArrayList<String> sectionList = new ArrayList<>();
    private TimeSlotAdapter timeSlotAdapter;
    private Context context;
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

        sectionList.add("7:00 AM - 8:00 AM");
        sectionList.add("8:00 AM - 9:00 AM");
        sectionList.add("9:00 AM - 10:00 AM");
        sectionList.add("10:00 AM - 11:00 AM");
        sectionList.add("11:00 AM - 12:00 AM");

        sectionList.add("13:00 AM - 14:00 AM");
        sectionList.add("14:00 AM - 15:00 AM");
        sectionList.add("15:00 AM - 16:00 AM");
        sectionList.add("16:00 AM - 17:00 AM");
        

        rcv_TimeSlot = findViewById(R.id.rcv_timeSlots);
        rcv_TimeSlot.setLayoutManager(new GridLayoutManager(ChooseDateActivity.this,3));
        timeSlotAdapter = new TimeSlotAdapter(sectionList, this);
        rcv_TimeSlot.setAdapter(timeSlotAdapter);



    }
}