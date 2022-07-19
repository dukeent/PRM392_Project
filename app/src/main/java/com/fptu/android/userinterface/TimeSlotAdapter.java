package com.fptu.android.userinterface;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeSlotAdapter extends RecyclerView.Adapter<TimeSlotAdapter.UserViewHolder> {
    private ArrayList<String> sectionList;
    private Context mContext;
    private Activity activity;
    int selectedPosition = -1;

    public TimeSlotAdapter(ArrayList<String> sectionList, Activity activity) {
        this.sectionList = sectionList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public TimeSlotAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slot, parent, false);
        return new TimeSlotAdapter.UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeSlotAdapter.UserViewHolder holder, int position) {
        holder.setItem(sectionList.get(position));
    }
    public String getItemSelected(){
        if(selectedPosition != -1){
            return sectionList.get(selectedPosition);
        }
        return "null";
    }

    @Override
    public int getItemCount() {
        return sectionList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            textView = itemView.findViewById(R.id.time_slot);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedPosition = getBindingAdapterPosition();
                    notifyDataSetChanged();
                }
            });
        }

        private void setItem(String item) {
            if (selectedPosition == getBindingAdapterPosition()) {
                textView.setBackground(ContextCompat.getDrawable(activity, R.drawable.rectangle_fill));
                textView.setTextColor(Color.WHITE);
            } else {
                textView.setBackground(ContextCompat.getDrawable(activity, R.drawable.rectangle_outline));
                textView.setTextColor(Color.BLACK);
            }
            textView.setText(item);
        }


    }
}
