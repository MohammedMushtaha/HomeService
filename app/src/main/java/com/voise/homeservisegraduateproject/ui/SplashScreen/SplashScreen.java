package com.voise.homeservisegraduateproject.ui.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.SharedPreferanse.SharedPreferanse;
import com.voise.homeservisegraduateproject.ui.MainActivity;
import com.voise.homeservisegraduateproject.ui.auth.login.LoginActivity;
import com.voise.homeservisegraduateproject.ui.uiCustomerUser.MainActivity2;
import com.voise.homeservisegraduateproject.uiOfServiceProvider.ServiceProviderMainActivity;

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
                    Log.e("vbnmIDCustomer",""+SharedPreferanse.read(SharedPreferanse.IDCustomer,""));
                    startActivity(i);
                    finish();

                }else  if (!SharedPreferanse.read(SharedPreferanse.IDProvider,"").equals("")) {
                    Intent i = new Intent(SplashScreen.this, ServiceProviderMainActivity.class);
                    Log.e("vbnmIDProvider",""+SharedPreferanse.read(SharedPreferanse.IDProvider,""));

                    startActivity(i);
                    finish();
                }else {
                    Intent i = new Intent(SplashScreen.this, LoginActivity.class);
                    Log.e("vbnm",""+SharedPreferanse.read(SharedPreferanse.IDCustomer,"")+SharedPreferanse.read(SharedPreferanse.IDProvider,""));

                    startActivity(i);
                    finish();
                }
            }
        },3000);
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}

