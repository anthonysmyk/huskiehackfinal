package com.hack1.project;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainAct extends AppCompatActivity {
    private Button navigatetohotline, navigatetobreathing, navigatetoabout;

    protected void onCreate(Bundle savedIn){
        super.onCreate(savedIn);
        setContentView(R.layout.activity_menu);

            navigatetobreathing = findViewById(R.id.buttontomed);
            navigatetobreathing.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainAct.this,  Breathing.class);
                    startActivity(intent);
                }
            });

            navigatetohotline = findViewById(R.id.buttontosup);
            navigatetohotline.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent Intent2 = new Intent(MainAct.this, Hotlines.class);
                    startActivity(Intent2);
                }
            });
            navigatetoabout = findViewById(R.id.abt);
            navigatetoabout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent3 = new Intent(MainAct.this,About.class);
                    startActivity(intent3);
                }
            });
            Button navigatetomed = findViewById(R.id.medbutton);
            navigatetomed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent4 = new Intent(MainAct.this,Guidedmeditation.class);
                    startActivity(intent4);
                }
            });

        }
}
