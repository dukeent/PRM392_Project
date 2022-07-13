package com.fptu.android.userinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private Button logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< Updated upstream
        logOut = findViewById(R.id.btnlogout);

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this, Login.class));
                Toast.makeText(MainActivity.this, "logout success", Toast.LENGTH_LONG).show();
            }
        });
=======
//        logOut = findViewById(R.id.btnlogout);
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
//        logOut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, Login.class));
//
//            }
//        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.item5:
                startActivity(new Intent(this, UserProfile.class));
                return true ;
            case R.id.item4:
                startActivity(new Intent(this, WheelSpin.class));
                return true ;
            case R.id.item3:
                startActivity(new Intent(this, ViewStaff.class));
                return true ;
            case R.id.item2:
                startActivity(new Intent(this, ViewProduct.class));
                return true ;
            case R.id.item1:
                Toast.makeText(MainActivity.this, "1", Toast.LENGTH_LONG).show();
                return true ;
        }


        return false;
>>>>>>> Stashed changes
    }
}