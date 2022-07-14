package com.fptu.android.userinterface;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
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
import java.util.Calendar;

public class ChooseDateActivity extends AppCompatActivity {

    private RecyclerView rcv_TimeSlot;
    private ArrayList<String> sectionList = new ArrayList<>();
    private TimeSlotAdapter timeSlotAdapter;
    private Context context;
    private DatePickerDialog datePickerDialog;
    private Button dateBtn;
    private Button bookingBtn;
    private TextView dateView;
    private String bookingDate;
    private DatabaseReference bookingRef;
    private FirebaseUser user;
    private String salonAddress;
    private DatabaseReference userReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_date);
        BindingView();
        BindingAction();

    }

    private void ChooseDate() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        datePickerDialog = new DatePickerDialog(ChooseDateActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                bookingDate = MakeDateString(dayOfMonth, month, year);
                dateView.setText(bookingDate);
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    private String MakeDateString(int dayOfMonth, int month, int year) {
        return GetMonthFormat(month) + " " + dayOfMonth + " " + year;
    }

    private String GetMonthFormat(int month) {
        if (month == 1) {
            return "Jan";
        }
        if (month == 2) {
            return "Feb";
        }
        if (month == 3) {
            return "Mar";
        }
        if (month == 4) {
            return "Apr";
        }
        if (month == 5) {
            return "May";
        }
        if (month == 6) {
            return "Jun";
        }
        if (month == 7) {
            return "Jul";
        }
        if (month == 8) {
            return "Aug";
        }
        if (month == 9) {
            return "Sep";
        }
        if (month == 10) {
            return "Oct";
        }
        if (month == 11) {
            return "Nov";
        }
        if (month == 12) {
            return "Dec";
        }
        return "Month";
    }

    private void BindingView() {
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        } else {
            Salon salon = (Salon) bundle.get("Salon");
            TextView textView = findViewById(R.id.salonAddress);
            salonAddress  = salon.getSalonAddress();
            textView.setText("You are choosing: " + salon.getSalonAddress());
        }

        dateBtn = findViewById(R.id.chooseDateBtn);
        dateView = findViewById(R.id.date_Textview);
        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseDate();
            }
        });
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
        rcv_TimeSlot.setLayoutManager(new GridLayoutManager(ChooseDateActivity.this, 3));
        timeSlotAdapter = new TimeSlotAdapter(sectionList, this);
        rcv_TimeSlot.setAdapter(timeSlotAdapter);
        bookingRef = FirebaseDatabase.getInstance().getReference().child("Booking");
        bookingBtn = findViewById(R.id.bookNowBtn);

    }

    private void BindingAction() {
        bookingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertBookingData();
            }
        });
    }

    private void InsertBookingData() {
        userReference =  FirebaseDatabase.getInstance().getReference("User");
        user = FirebaseAuth.getInstance().getCurrentUser();
        String userId = user.getUid();
        String slot =  timeSlotAdapter.getItemSelected();
        String date = bookingDate;
        if (date == null || slot == null) {
            if(date == null){
                Toast.makeText(ChooseDateActivity.this, "Please Input date!", Toast.LENGTH_LONG).show();
            }
            if(slot == null){
                Toast.makeText(ChooseDateActivity.this, "Please select 1 Slot!", Toast.LENGTH_LONG).show();
            }
        } else {
            Booking booking = new Booking(salonAddress, date, slot, userId);
            bookingRef.push().setValue(booking);
            Toast.makeText(ChooseDateActivity.this, "Booking Success!", Toast.LENGTH_LONG).show();
        }
    }

}