package com.hack1.project;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class About extends AppCompatActivity {
private Button navigatetohotline, navigatetobreathing, navigatetoanxiety, navigatetowebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        navigatetobreathing = findViewById(R.id.navigatebreathing);
        navigatetobreathing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Intent intentt = new Intent("android.intent.action.view");
Uri.parse("https://www.healthline.com/health/4-7-8-breathing#1");
startActivity(intentt);
            }
        });

    navigatetowebsite = findViewById(R.id.button2);
    navigatetowebsite.setOnClickListener(new View.OnClickListener() {
        @Override
                public void onClick(View v) {
                Intent viewIntent = new Intent("android.intent.action.VIEW",
                        Uri.parse("https://joytaylor.github.io/niuHack/"));
                startActivity(viewIntent);
            }

        });

    }
}
