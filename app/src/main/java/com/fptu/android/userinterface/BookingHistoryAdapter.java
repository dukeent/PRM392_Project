package com.fptu.android.userinterface;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookingHistoryAdapter extends RecyclerView.Adapter<BookingHistoryAdapter.UserViewHolder>{
    private List<Booking> mBookingList;
    private Context mContext;

    public BookingHistoryAdapter(List<Booking> mBookingList, Context mContext) {
        this.mBookingList = mBookingList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public BookingHistoryAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_history_item, parent, false);
        return new BookingHistoryAdapter.UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingHistoryAdapter.UserViewHolder holder, int position) {
        Booking booking = mBookingList.get(position);
        String address = booking.getSalonAddress();
        String timeSlot = booking.getSlot();
        String date = booking.getDate();
        holder.setData(address,timeSlot,date);
    }

    @Override
    public int getItemCount() {
        if(mBookingList.size() != 0){
            return mBookingList.size();
        }
        return -1;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private ImageView salonAvatar;
        private TextView salonAddress;
        private TextView timeSlot2;
        private TextView dateTime;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            salonAvatar = itemView.findViewById(R.id.myAvatar);
            salonAddress = itemView.findViewById(R.id.salonAddressHist);
            timeSlot2 = itemView.findViewById(R.id.bookingTimeHist);
            dateTime = itemView.findViewById(R.id.bookingDateHist);
        }

        public void setData( String address, String timeSlot, String date) {
            salonAvatar.setImageResource(R.drawable.salon);
            salonAddress.setText("Address: " + address);
            dateTime.setText("Date: " + date);
            timeSlot2.setText("Time: " + timeSlot);
        }
    }
}
