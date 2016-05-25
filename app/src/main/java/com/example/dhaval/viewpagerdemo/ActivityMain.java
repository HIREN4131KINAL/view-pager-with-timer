package com.example.dhaval.viewpagerdemo;

import android.os.CountDownTimer;
import android.os.Handler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class ActivityMain extends AppCompatActivity {

    MyViewPager viewPager;
    PagerAdapter pagerAdapter;
    int position = 0;

    DisplayTimer displayTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (MyViewPager) findViewById(R.id.viewPager);
        pagerAdapter = new PagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());

        displayTimer = new DisplayTimer(5000, 1000);
        displayTimer.start();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public class DisplayTimer extends CountDownTimer{


        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public DisplayTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {

        }

        @Override
        public void onFinish() {

            if(position == 5){

                viewPager.setAdapter(pagerAdapter);
                position = 0;
                viewPager.setCurrentItem(position, true);
                position++;
                displayTimer = new DisplayTimer(5000, 1000);
                displayTimer.start();

            }else {

                viewPager.setCurrentItem(position, true);
                position++;
                displayTimer = new DisplayTimer(5000, 1000);
                displayTimer.start();

            }

        }
    }


}
