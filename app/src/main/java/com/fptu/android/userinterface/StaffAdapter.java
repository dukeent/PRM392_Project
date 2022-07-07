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

public class StaffAdapter extends RecyclerView.Adapter<StaffAdapter.UserViewHolder> {

    private List<Staff> mListStaff;
    private Context mContext;

    public StaffAdapter(List<Staff> mListStaff) {
        this.mListStaff = mListStaff;
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_staff, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Staff staff = mListStaff.get(position);
        if (staff == null) {
            return;
        }
        holder.tvName.setText("Name: " + staff.getName());
        holder.tvGender.setText("Gender:" + staff.getGender());
        holder.tvSpecialized.setText("Specialized: " + staff.getSpecialized());
        Glide.with(holder.imageProduct.getContext()).load((staff.getSurl())).into(holder.imageProduct);
    }

    @Override
    public int getItemCount() {
        if (mListStaff != null) {
            return mListStaff.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private TextView tvGender;
        private TextView tvSpecialized;
        private ImageView imageProduct;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvGender = itemView.findViewById(R.id.tv_gender);
            tvSpecialized = itemView.findViewById(R.id.tv_specialized);
            imageProduct = itemView.findViewById(R.id.imageProduct);
        }
    }
}

