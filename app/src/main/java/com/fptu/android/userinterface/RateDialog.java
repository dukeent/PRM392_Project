package com.fptu.android.userinterface;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

public class RateDialog extends Dialog {

    public RateDialog(@NonNull Context context) {
        super(context);
    }

    AppCompatButton rateNowBtn;
    AppCompatButton lateBtn;
    RatingBar ratingBar;
    ImageView ratingImg;


    private float userRate = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_rate);

        rateNowBtn = findViewById(R.id.rateNowBtn);
        lateBtn = findViewById(R.id.laterBtn);
        ratingBar = findViewById(R.id.ratingBar);
        ratingImg = findViewById(R.id.ratingImg);

        rateNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //RateDialog.d
            }
        });

        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            if (rating <= 1) {
                ratingImg.setImageResource(R.drawable.star1);
            } else if (rating <= 2) {
                ratingImg.setImageResource(R.drawable.star2);
            } else if (rating <= 3) {
                ratingImg.setImageResource(R.drawable.star3);
            } else if (rating <= 4) {
                ratingImg.setImageResource(R.drawable.star4);
            } else if (rating <=5) {
                ratingImg.setImageResource(R.drawable.star5);
            }
            animateImage(ratingImg);
            userRate = rating;
        });
    }
    private void animateImage(ImageView ratingImg) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1f, 0, 1f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(200);
        ratingImg.startAnimation(scaleAnimation);
    }
}

