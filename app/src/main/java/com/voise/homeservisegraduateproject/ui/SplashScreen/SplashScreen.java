package com.voise.homeservisegraduateproject.ui.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.SharedPreferanse.SharedPreferanse;
import com.voise.homeservisegraduateproject.ui.MainActivity;
import com.voise.homeservisegraduateproject.ui.auth.login.LoginActivity;
import com.voise.homeservisegraduateproject.ui.uiCustomerUser.MainActivity2;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        SharedPreferanse.init(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!SharedPreferanse.read(SharedPreferanse.IDCustomer,"").equals("")){
//                    SharedPreferanse.TOKEN_AUTH =  SharedPreferanse.read(SharedPreferanse.TOKEN,"");
                    Intent i = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(i);
                    finish();

                }else  if (!SharedPreferanse.read(SharedPreferanse.IDProvider,"").equals("")) {
                    Intent i = new Intent(SplashScreen.this, MainActivity2.class);
                    startActivity(i);
                    finish();
                }else {
                    Intent i = new Intent(SplashScreen.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        },3000);
    }
}

