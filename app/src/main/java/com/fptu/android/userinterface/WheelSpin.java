package com.fptu.android.userinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class WheelSpin extends AppCompatActivity {
    ImageView spinBtn;
    ImageView spinWheel;
    TextView tvView;

    String[] sectors = {"Drinks", "Free hairStyling", "-10%", "Sorry", "-30%"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel_spin);

        spinBtn = findViewById(R.id.imgSpinBtn);
        spinWheel = findViewById(R.id.imgSpin);
        tvView = findViewById(R.id.wheel);

        Collections.reverse(Arrays.asList(sectors));

        spinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                final int degree = random.nextInt(360);

                RotateAnimation rotateAnimation = new RotateAnimation(0,degree + 720,
                        RotateAnimation.RELATIVE_TO_SELF,0.5f,
                        RotateAnimation.RELATIVE_TO_SELF,0.5f);

                rotateAnimation.setDuration(3000);
                rotateAnimation.setFillAfter(true);
                rotateAnimation.setInterpolator(new DecelerateInterpolator());

                rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        CalculatePoint(degree);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                spinWheel.startAnimation(rotateAnimation);

            }
            public void CalculatePoint(int degree){
                int initialPoint = 0;
                int endPoint = 90;
                int i = 0;
                String res = null;

                do{
                    if(degree >initialPoint && degree<endPoint){
                        res = sectors[i];
                    }
                    initialPoint += 90;
                    endPoint +=90;
                    i++;
                }while (res == null);
                tvView.setText(res);
            }
        });
    }

}