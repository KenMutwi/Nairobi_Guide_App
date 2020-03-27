package com.example.nairobiguideapp.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nairobiguideapp.HelperClasses.SliderAdapter;
import com.example.nairobiguideapp.R;
import com.example.nairobiguideapp.User.UserDashboard;

public class OnBoarding extends AppCompatActivity {
    ViewPager viewPager;
    LinearLayout dots;

    SliderAdapter sliderAdapter;
    TextView[] putdots;
    Button get_started_btn;
    Animation animation;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding);

        viewPager = findViewById(R.id.slider);
        dots = findViewById(R.id.dots);
        get_started_btn = findViewById(R.id.get_started_btn);

        //call adapter
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);

    }
    public void  skip(View view){
        startActivity(new Intent(this, UserDashboard.class));
        finish();

    }
    public void next(View view){

        viewPager.setCurrentItem(currentPosition+1);

    }

    private void addDots(int position) {
        putdots = new TextView[4];
        dots.removeAllViews();
        for (int i = 0; i < putdots.length; i++) {
            putdots[i] = new TextView(this);
            putdots[i].setText(Html.fromHtml("&#8226;"));
            putdots[i].setTextSize(40);
            dots.addView(putdots[i]);
        }
        if (putdots.length > 0) {
            putdots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }

    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);

            currentPosition= position;
            if (position == 0) {
                get_started_btn.setVisibility(View.INVISIBLE);

            } else if (position == 1) {
                get_started_btn.setVisibility(View.INVISIBLE);

            } else if (position == 2) {
                get_started_btn.setVisibility(View.INVISIBLE);

            } else {
                animation= AnimationUtils.loadAnimation(OnBoarding.this,R.anim.bottom_anim);
                get_started_btn.setAnimation(animation);
                get_started_btn.setVisibility(View.VISIBLE);

            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
