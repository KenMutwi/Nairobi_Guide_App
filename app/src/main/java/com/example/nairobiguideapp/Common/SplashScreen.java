package com.example.nairobiguideapp.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nairobiguideapp.R;
import com.example.nairobiguideapp.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIMER = 5000;
    ImageView backgroundImage;
    TextView poweredBy;

    //Animations
    Animation sideAnim,bottomAnim;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        backgroundImage = findViewById(R.id.background_image);
        poweredBy = findViewById(R.id.powered_by);

        sideAnim= AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        //set Animations on element
        backgroundImage.setAnimation(sideAnim);
        poweredBy.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sharedPreferences= getSharedPreferences("onBoardingScreen",MODE_PRIVATE);

                boolean isFirstTime = sharedPreferences.getBoolean("firstTime",true);

                if(isFirstTime) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("firstTime",false);
                    editor.commit();

                    Intent intent = new Intent(SplashScreen.this, OnBoarding.class);
                    startActivity(intent);
                    finish();

                }else{
                    Intent intent = new Intent(SplashScreen.this, UserDashboard.class);
                    startActivity(intent);
                    finish();

                }

            }
        },SPLASH_TIMER);
    }
}
