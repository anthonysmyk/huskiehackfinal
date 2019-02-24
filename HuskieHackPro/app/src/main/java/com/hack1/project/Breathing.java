package com.hack1.project;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;

public class Breathing extends AppCompatActivity implements Runnable{

    //sets the names for elements
    private static final long START_TIME_IN_MILLS = 19000;
    public Button Start_Timer;
    public Button Stop_Timer;
    public TextView Timer;
    public int  counter = 0;
    private long timeLeftInMil = 19000;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathing);
        Start_Timer = findViewById(R.id.Start_Timer);
        Stop_Timer = findViewById(R.id.Stop_Timer);


        Start_Timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                starTimer();
                Timer.setText("" + counter);

            }
        });

        Stop_Timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTimer();
                Timer.setText("" + counter);

            }
        });

    }



        public void starTimer () {
            handler.postDelayed(this, 1000);
            counter++;
            if (counter == 4) {

            } else if (counter == 11) {

            } else if (counter == 19) {

            }
        }

        public void stopTimer () {
            handler.removeCallbacks(this);
            counter = 0;
        }
        public void run () {
            counter++;
            handler.postDelayed(this, 1000);
        }

}



