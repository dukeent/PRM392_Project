package com.fptu.android.userinterface;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class HairAdapter extends RecyclerView.Adapter<HairAdapter.UserViewHolder>{

    private List<Hair> mListHair;
    private Context mContext;

    public HairAdapter(List<Hair> mListHair) {
        this.mListHair = mListHair;
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_hair,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Hair hair = mListHair.get(position);
        if(hair == null){
            return;
        }
        holder.tvID.setText("ID: " + hair.getId());
        holder.tvName.setText("Name:" + hair.getName());
        holder.tvPrice.setText("Price: " + hair.getPrice());
        Glide.with(holder.imageHair.getContext()).load((hair.getSurl())).into(holder.imageHair);
    }

    @Override
    public int getItemCount() {
        if(mListHair != null){
            return mListHair.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

        private TextView tvID;
        private TextView tvName;
        private TextView tvPrice;
        private ImageView imageHair;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvID = itemView.findViewById(R.id.tv_id);
            tvName = itemView.findViewById(R.id.tv_name);
            tvPrice = itemView.findViewById(R.id.tv_price);
            imageHair = itemView.findViewById(R.id.imageHair);
        }
    }
}

