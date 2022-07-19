package com.fptu.android.userinterface;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BookingActivity extends AppCompatActivity {
    private Context context;
    private RecyclerView rcvSalon;
    private BookingAdapter mBookingAdapter;
    private List<Salon> salonList;
    private DatabaseReference databaseReferenceProduct;
    private Salon salon;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        BindingView();
        BindingAction();
    }

    private void BindingView() {
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            Toast.makeText(BookingActivity.this, "You haven't login yet. Please login!", Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(), Login.class));
            finish();
        } else {
            rcvSalon = findViewById(R.id.rcv_Salon);
            rcvSalon.setLayoutManager(new LinearLayoutManager(BookingActivity.this));
            databaseReferenceProduct = FirebaseDatabase.
                    getInstance("https://userinterface2-default-rtdb.firebaseio.com")
                    .getReference("/Salon/");
            databaseReferenceProduct.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    salonList = new ArrayList<>();
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        Salon salon = dataSnapshot.getValue(Salon.class);
                        salonList.add(salon);
                    }
                    mBookingAdapter = new BookingAdapter(salonList);
                    rcvSalon.setAdapter(mBookingAdapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(BookingActivity.this, "No result", Toast.LENGTH_LONG).show();
                }
            });
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            rcvSalon.setLayoutManager(linearLayoutManager);
        }
    }

    private void BindingAction() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.booking_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type here to search a Friend");
        return super.onCreateOptionsMenu(menu);
    }


}