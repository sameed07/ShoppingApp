package com.sameedshah.shoppingapp;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

import Adapters.SliderAdapter;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    SliderAdapter sliderAdapter;
    LinearLayout linearLayout;
    TextView[] mDots;
    Button btnNext,btnBack;
    int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.mViewPager);
        linearLayout = findViewById(R.id.dotLayout);

        btnNext = findViewById(R.id.btnNext);
        btnBack = findViewById(R.id.btnBack);

        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        addDotsIndecator(0);

        viewPager.addOnPageChangeListener(changeListener);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnNext.getText().toString().equals("Finish")){
                    Toast.makeText(MainActivity.this, "Thanks!", Toast.LENGTH_SHORT).show();
                }else {
                viewPager.setCurrentItem(currentPage + 1);
            }}
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(currentPage - 1);

            }
        });
    }

    public void addDotsIndecator(int position){
        mDots = new TextView[3];
        linearLayout.removeAllViews();
        for (int i = 0; i< mDots.length; i ++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.transparentWhite));
            linearLayout.addView(mDots[i]);
        }

        if(mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.white));
        }
    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndecator(i);
            currentPage = i;
            if(1==0){
                btnBack.setEnabled(false);
                btnNext.setEnabled(true);
                btnBack.setVisibility(View.INVISIBLE);
                btnNext.setText("Next");
            }
            else if (i==mDots.length -1){
                btnBack.setEnabled(true);
                btnNext.setEnabled(true);
                btnBack.setVisibility(View.VISIBLE);
                btnNext.setText("Finish");

            }
            else{
                btnBack.setEnabled(true);
                btnNext.setEnabled(true);
                btnBack.setVisibility(View.VISIBLE);
                btnNext.setText("Next");
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };


}
