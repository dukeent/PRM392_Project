package com.fptu.android.userinterface;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookingHistoryActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager myLayoutManager;
    private List<Booking> bookingList;
    BookingHistoryAdapter adapter;
    private FirebaseUser user;
    private DatabaseReference bookingRef;
    private DatabaseReference userReference;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_history);
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            Toast.makeText(BookingHistoryActivity.this, "You haven't login yet. Please login!", Toast.LENGTH_LONG).show();
            userID = "";
            startActivity(new Intent(BookingHistoryActivity.this, Login.class));
            finish();
        } else {
            userID = user.getUid();
        }
        BindingView();
        BindingAction();
    }

    private void BindingView() {
        bookingList = new ArrayList<>();
        userReference = FirebaseDatabase.getInstance().getReference("User");
        GetBookingHistoryFromDB(userID);
    }

    private void BindingAction() {
        recyclerView = findViewById(R.id.rcv_bookingHist);
        myLayoutManager = new LinearLayoutManager(this);
        myLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(myLayoutManager);
        adapter = new BookingHistoryAdapter(bookingList, this);
        recyclerView.setAdapter(adapter);
    }

    private void GetBookingHistoryFromDB(String userID) {
        bookingRef = FirebaseDatabase.getInstance().getReference("Booking");
        bookingRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    Booking booking = ds.getValue(Booking.class);
                    if (booking.getUserID().equals(userID)) {
                        bookingList.add(booking);
                    }
                    adapter.notifyDataSetChanged();
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

}

