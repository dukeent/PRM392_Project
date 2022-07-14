package com.fptu.android.userinterface;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.UserViewHolder> {
    private List<Salon> mSalonList;
    private Context mContext;

    public BookingAdapter(List<Salon> salonList) {
        this.mSalonList = salonList;
    }

    @NonNull
    @Override
    public BookingAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_item, parent, false);
        return new BookingAdapter.UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingAdapter.UserViewHolder holder, int position) {
        Salon salon = mSalonList.get(position);
        if (salon == null) {
            return;
        }
        holder.salonAddress.setText("Our address: " + salon.getSalonAddress());
        holder.bookingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClickGoToChooseDate(salon);
            }
        });
    }

    private void ClickGoToChooseDate(Salon salon) {
        Intent intent = new Intent(mContext, ChooseDateActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Salon", salon);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if (mSalonList != null) {
            return mSalonList.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView salonAddress;
        private Button bookingBtn;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            salonAddress = itemView.findViewById(R.id.salonAddress);
            bookingBtn = itemView.findViewById(R.id.bookNowBtn);
        }
    }
}
