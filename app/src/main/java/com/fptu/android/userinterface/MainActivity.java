package com.fptu.android.userinterface;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private Button logOut;
    private ImageView booking;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logOut = findViewById(R.id.btnlogout);
        booking = findViewById(R.id.bookingBtn);
        bottomNavigationView = findViewById(R.id.bottomNavigation) ;
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        // secssion
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        if (user != null) {
//            // User is signed in
                // nếu user đã login thì cho phép mua hàng
//        } else {
//            // No user is signed in
            // nếu user chưa login thì chuyển về trang login
//        }
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();

                startActivity(new Intent(MainActivity.this, Login.class));
                Toast.makeText(MainActivity.this, "logout success", Toast.LENGTH_LONG).show();
            }
        });

        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( MainActivity.this, BookingActivity.class));
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.item5:
                startActivity(new Intent(this, UserProfile.class));
                return true ;
            case R.id.item4:
                Toast.makeText(MainActivity.this, "item4", Toast.LENGTH_LONG).show();
                return true ;
            case R.id.item3:
                Toast.makeText(MainActivity.this, "3", Toast.LENGTH_LONG).show();
                return true ;
            case R.id.item2:
                Toast.makeText(MainActivity.this, "2", Toast.LENGTH_LONG).show();
                return true ;
            case R.id.item1:
                Toast.makeText(MainActivity.this, "1", Toast.LENGTH_LONG).show();
                return true ;
        }


        return false;
    }
}