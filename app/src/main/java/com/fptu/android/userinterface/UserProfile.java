package com.fptu.android.userinterface;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserProfile extends AppCompatActivity {
    private FirebaseUser user;
    private DatabaseReference reference;



    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        user= FirebaseAuth.getInstance().getCurrentUser();
        userId=user.getUid();
        reference= FirebaseDatabase.getInstance().getReference("User");

        final TextView tvgreeting = findViewById(R.id.tvGreeding);
        final TextView tvusername = findViewById(R.id.name);
        final TextView tvemail = findViewById(R.id.userEmail);
        final TextView tvphone=findViewById(R.id.tvphone);



        reference.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
              User userProfile=snapshot.getValue(User.class);

                if(userProfile != null){

                    String fullName= snapshot.child("name").getValue().toString();
                    String email = user.getEmail();
                    String phone = snapshot.child("phone").getValue().toString();

                    tvgreeting.setText("welcome to your Profile " );

                    tvusername.setText("Name: "+fullName);
                    tvemail.setText(""+email);
                    tvphone.setText(""+phone);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UserProfile.this, "somthing went wrong :( ", Toast.LENGTH_LONG).show();
            }
        });

    }
}