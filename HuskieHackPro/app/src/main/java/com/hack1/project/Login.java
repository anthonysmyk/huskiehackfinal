package com.hack1.project;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.*;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class Login extends AppCompatActivity {
    public static final int EMAILREG_CODE = 10;
    private Button emailRegBtn, googleBtn, emailSignBtn;
    //private GoogleSignInClient googleSignInClient;
    private SignInButton googleSignInButton;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        linkUi();
        ConstraintLayout constraintLayout =(ConstraintLayout)findViewById(R.id.login_activity_screen);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();


    }

    public void linkUi() {
        emailRegBtn = findViewById(R.id.upemail);
        emailSignBtn = findViewById(R.id.loginemail);
        emailSignBtn.setOnClickListener(view->{
            Intent i = new Intent(Login.this,EmailReg.class);
            i.putExtra("Login",true);
            startActivityForResult(i,EMAILREG_CODE);
        });


        emailRegBtn.setOnClickListener(view -> {

            Intent i = new Intent(Login.this, EmailReg.class);
            i.putExtra("Login",false);
            startActivityForResult(i,EMAILREG_CODE);


        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case EMAILREG_CODE:
                    startActivity(new Intent(this,Moodtracker.class));
                    finish();

                    break;

            }
        }
    }
    public void setGoogleBtn(){



    }
}













