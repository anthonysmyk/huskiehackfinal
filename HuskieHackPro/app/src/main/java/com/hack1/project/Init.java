package com.hack1.project;

import android.app.Application;

import com.google.firebase.FirebaseApp;

public class Init extends Application {
    public void onCreate(){
        super.onCreate();
        FirebaseApp.initializeApp(this);
    }
}
