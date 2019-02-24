package com.hack1.project;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class EmailReg extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText email, password;
    private Button register, login;
    private ConstraintLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_reg);
        linkUI();


    }

    private void linkUI() {

        login.setOnClickListener(view -> {


        });
        register.setOnClickListener(view -> {



        });
    }



    }

