package com.hack1.project;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.HashMap;

public class Moodtracker extends AppCompatActivity implements View.OnClickListener {
public int moodScore = 0;
SharedPreferences pref;
SharedPreferences.Editor editor;
public ImageButton verysad,sad,neutral,happy,delighted;
HashMap<View,Integer> moodChanges = new HashMap<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
         pref = getSharedPreferences("DATA",MODE_PRIVATE);
         editor = pref.edit();
        moodScore = pref.getInt("Mood",0);
/*
        ConstraintLayout constraintLayout =(ConstraintLayout)findViewById(R.id.mood_activity_screen);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
*/

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moodtracker);
moodChanges.put(findViewById(R.id.verysad),-2);
moodChanges.put(findViewById(R.id.sad),-1);
moodChanges.put(findViewById(R.id.neutral),0);
moodChanges.put(findViewById(R.id.happy),1);
moodChanges.put(findViewById(R.id.delighted),1);
for(View v:moodChanges.keySet()){
    v.setOnClickListener(this);
}





}
public void onClick(View v){
        if(moodChanges.get(v)>=0) {
            moodScore = 0;
        }else {
            moodScore += moodChanges.get(v);
        }
        editor.putInt("Mood",moodScore);
        editor.apply();
        editor.commit();

    if (moodScore <= -10){

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
                        startActivity(new Intent(Moodtracker.this, MainAct.class));

                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

    }else {
        startActivity(new Intent(this, MainAct.class));
    }

}


        }


