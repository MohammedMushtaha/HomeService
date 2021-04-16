package com.voise.homeservisegraduateproject.ui.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.ui.auth.login.LoginActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        },2000);

    }
}