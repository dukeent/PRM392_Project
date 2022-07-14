package com.fptu.android.userinterface;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private LinearLayout booking, signin, lucky, staff, history, rating;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        booking = findViewById(R.id.bookingBtn1);


        signin = findViewById(R.id.Loginbtn1);
        lucky = findViewById(R.id.luckybtn1);
        staff = findViewById(R.id.viewstaffbtn1);
        history = findViewById(R.id.historybtn1);
        rating = findViewById(R.id.ratingbtn1);
        user = FirebaseAuth.getInstance().getCurrentUser();
//        if (user != null) {
//            Toast.makeText(MainActivity.this, "you have alredy Login ", Toast.LENGTH_LONG).show();
//            startActivity(new Intent(MainActivity.this, UserProfile.class));
//        }


        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BookingActivity.class));
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, Login.class));
            }
        });

        lucky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, WheelSpin.class));
            }
        });
        staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ViewStaff.class));
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BookingHistoryActivity.class));
            }
        });
        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent( MainActivity.this, ViewStaff.class)); ratting của hải
            }
        });


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.item5:
                startActivity(new Intent(this, UserProfile.class));
                return true;
            case R.id.item4:
                startActivity(new Intent(this, BookingActivity.class));
                return true;
            case R.id.item3:
                startActivity(new Intent(this, ViewStaff.class));
                return true;
            case R.id.item2:
                startActivity(new Intent(this, ViewProduct.class));
                return true;
            case R.id.item1:
                //startActivity(new Intent(this, BookingHistoryActivity.class));
                return true;
        }


        return false;
    }
}