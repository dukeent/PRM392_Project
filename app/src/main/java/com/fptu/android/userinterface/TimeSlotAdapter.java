package com.fptu.android.userinterface;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
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

public class TimeSlotAdapter extends RecyclerView.Adapter<TimeSlotAdapter.UserViewHolder>{
    private ArrayList<String> sectionList;
    Activity activity;
    int flag = -1;
    public TimeSlotAdapter(ArrayList<String> sectionList, Activity activity) {
        this.sectionList = sectionList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public TimeSlotAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slot,parent,false);
        return new TimeSlotAdapter.UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeSlotAdapter.UserViewHolder holder, int position) {
        String str = sectionList.get(position);
        if(str == null){
            return;
        }
        holder.textView.setText(str);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag +=1;
                if(flag % 2 == 0){
                    holder.textView.setBackground(ContextCompat.getDrawable(activity,R.drawable.rectangle_fill));
                    holder.textView.setTextColor(Color.WHITE);
                }
                else{
                    holder.textView.setBackground(ContextCompat.getDrawable(activity,R.drawable.rectangle_outline));
                    holder.textView.setTextColor(Color.BLACK);
                }

            }
        });

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

        TextView textView;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.time_slot);
        }
    }
}
