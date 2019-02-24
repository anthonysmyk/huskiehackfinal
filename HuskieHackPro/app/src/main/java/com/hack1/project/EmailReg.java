package com.hack1.project;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class EmailReg extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText email, password;
    private Button login;
    private ConstraintLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_reg);
        auth = FirebaseAuth.getInstance();
        linkUI();


    }

    private void linkUI() {
        login = findViewById(R.id.login);
        login.setText(getIntent().getBooleanExtra("Login",false) ? "Login" : "Register");
              email = findViewById(R.id.emailedit);
        password = findViewById(R.id.passwordedit);


        login.setOnClickListener(view -> {
            if(email.getText().toString().length()!=0&&password.getText().toString().length()!=0) {


                if (login.getText().equals("Register")) {
                    auth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(EmailReg.this, "RegSucees!", Toast.LENGTH_SHORT).show();
                            login();
                        } else {

                            Toast.makeText(EmailReg.this,email.getText().toString() +"" , Toast.LENGTH_SHORT).show();


                        }
                    });
                } else {
                    login();

                }

            }
        });



    }
    public void login(){
        auth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(task->{
            if(task.isSuccessful()){
                setResult(RESULT_OK);
                finish();
            }else{
                Toast.makeText(EmailReg.this,task.getException()+"",Toast.LENGTH_SHORT).show();
            }
        });


    }



    }

