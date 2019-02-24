package com.hack1.project;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Moodtracker extends AppCompatActivity {
public int moodscore = 0;
public ImageButton verysad,sad,neutral,happy,delighted;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences pref = getSharedPreferences("DATA",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("Mood",-2);
        editor.apply();
        editor.commit();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moodtracker);
verysad = findViewById(R.id.verysad);
        
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.mood_activity_screen);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();


verysad.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        moodscore -= 2;
        Intent navigate = new Intent(Moodtracker.this, MainAct.class);
        startActivity(navigate);
    }
});
sad = findViewById(R.id.sad);
sad.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent navigate = new Intent(Moodtracker.this, MainAct.class);
        startActivity(navigate);
        moodscore-= 1;
    }
});
neutral = findViewById(R.id.neutral);
neutral.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent navigate = new Intent(Moodtracker.this, MainAct.class);
        startActivity(navigate);
moodscore = 0;
    }
});
happy = findViewById(R.id.happy);
happy.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent navigate = new Intent(Moodtracker.this, MainAct.class);
        startActivity(navigate);
        moodscore += 1;
    }
});
delighted = findViewById(R.id.delighted);
delighted.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent navigate = new Intent(Moodtracker.this, MainAct.class);
        startActivity(navigate);
        moodscore+= 2;
    }
});


if (moodscore <= -10){

        AlertDialog.Builder builder1 = new AlertDialog.Builder(Moodtracker.this);
        builder1.setMessage("We noticed you've been kind of down lately! Do you want to get some help?");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Go get help!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    Intent nav = new Intent(Moodtracker.this,Hotlines.class);
                    startActivity(nav);
                    }
                });

        builder1.setNegativeButton(
                "I'm ok thanks!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

    }
}

        }


