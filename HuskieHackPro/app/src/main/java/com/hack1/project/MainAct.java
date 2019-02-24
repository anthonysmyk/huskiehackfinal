package com.hack1.project;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainAct extends AppCompatActivity {

    protected void onCreate(Bundle savedIn){
        super.onCreate(savedIn);
        setContentView(R.layout.activity_menu);

           Button navigatetobreathing = findViewById(R.id.buttontomed);
            navigatetobreathing.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainAct.this,  Breathing.class);
                    startActivity(intent);
                }
            });

          Button  navigatetohotline = findViewById(R.id.buttontosup);
            navigatetohotline.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent Intent2 = new Intent(MainAct.this, Hotlines.class);
                    startActivity(Intent2);
                }
            });
        Button   navigatetochat = findViewById(R.id.chat);
            navigatetochat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent3 = new Intent(MainAct.this,ChatScreen.class);
                    startActivity(intent3);
                }
            });
            Button about = findViewById(R.id.about);
            about.setOnClickListener(view->{
                Intent viewIntent = new Intent("android.intent.action.VIEW",
                        Uri.parse("https://joytaylor.github.io/niuHack/"));
                startActivity(viewIntent);
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
