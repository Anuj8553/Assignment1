package com.example.growgh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

public class onBoarding extends AppCompatActivity {
    Button button,nextbtn;
    ViewPagerAdapter viewPagerAdapter;
    ViewPager mSlideViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        mSlideViewPager=(ViewPager) findViewById(R.id.viewPager);
        nextbtn=findViewById(R.id.nextButton);

        nextbtn.setOnClickListener(v -> {
            if (getItem(0)<2){
                mSlideViewPager.setCurrentItem(getItem(1),true);
                nextbtn.setText("Next");

            }
            else{
                nextbtn.setText("Ready");
                startActivity(new Intent(onBoarding.this,MainActivity.class));
                finish();
            }
        });

        mSlideViewPager.setOnPageChangeListener(viewListener);
        button=findViewById(R.id.button);
        button.setOnClickListener(v -> {
            startActivity(new Intent(onBoarding.this,MainActivity.class));
            finish();
        });


      viewPagerAdapter = new ViewPagerAdapter(this);
      mSlideViewPager.setAdapter(viewPagerAdapter);

      mSlideViewPager.addOnPageChangeListener(viewListener);

    }
    ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    private int getItem(int i){
        return mSlideViewPager.getCurrentItem()+i;
    }

}