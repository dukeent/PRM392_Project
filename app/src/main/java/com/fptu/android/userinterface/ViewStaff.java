package com.fptu.android.userinterface;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewStaff extends AppCompatActivity {

    private Context context;
    private RecyclerView rcvUser;
    StaffAdapter mStaffAdapter;
    private List<Staff> staffList;
    private DatabaseReference databaseReferenceProduct;
    Staff staff;

    private void bindingView() {
        rcvUser = findViewById(R.id.rcv_users);
        rcvUser.setLayoutManager(new LinearLayoutManager(ViewStaff.this));
        //co dong ke de phan cach giua cac item
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvUser.addItemDecoration(dividerItemDecoration);

    }

    private void bindingAction() {
        getListUserFromRealTimeDatabase();
    }

    private void getListUserFromRealTimeDatabase() {


        databaseReferenceProduct = FirebaseDatabase.
                getInstance("https://userinterface2-default-rtdb.firebaseio.com")
                .getReference("/Staff/");
        //Product product = new Product(123, "hello");


        databaseReferenceProduct.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                staffList = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    //Log.d("aaa", "onDataChange: " + dataSnapshot.getValue());
                    Staff staff = dataSnapshot.getValue(Staff.class);
                    staffList.add(staff);
                }
                mStaffAdapter = new StaffAdapter(staffList);
                rcvUser.setAdapter(mStaffAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ViewStaff.this, "No result", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_staff);
        bindingView();
        bindingAction();
    }


}