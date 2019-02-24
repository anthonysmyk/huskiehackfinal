package com.hack1.project;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class Hotlines extends AppCompatActivity {
    private Button depressionhotline, suicidehotline, anxietyhotline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotlines);
callhotline1();
callhotline2();
callhotline3();
    }
    public void callhotline1(){
depressionhotline = findViewById(R.id.depressionhotline);
        Intent dialIntent = new Intent(Intent.ACTION_CALL);
        // Set the data for the intent as the phone number.
        dialIntent.setData(Uri.parse("tel:+1-877-235-4525"));
        // If package resolves to an app, send intent.
        if (dialIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(dialIntent);
        }
    }

    public  void callhotline2(){
        suicidehotline = findViewById(R.id.suicidehotline);
        Intent dialIntent = new Intent(Intent.ACTION_CALL);
        // Set the data for the intent as the phone number.
        dialIntent.setData(Uri.parse("tel:+1-800-273-8255"));
        // If package resolves to an app, send intent.
        if (dialIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(dialIntent);
        }
    }
    public void callhotline3(){
        anxietyhotline = findViewById(R.id.anxietyhotline);
        Intent dialIntent = new Intent(Intent.ACTION_CALL);
        // Set the data for the intent as the phone number.
        dialIntent.setData(Uri.parse("tel:+1-310-855-4673"));
        // If package resolves to an app, send intent.
        if (dialIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(dialIntent);
        }
    }

    }


