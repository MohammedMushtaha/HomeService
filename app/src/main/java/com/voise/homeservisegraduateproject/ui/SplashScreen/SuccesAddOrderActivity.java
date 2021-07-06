package com.voise.homeservisegraduateproject.ui.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.ui.MainActivity;

public class SuccesAddOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_succes_add_order);
        Button button = findViewById(R.id.Go_To_Home);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SuccesAddOrderActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(SuccesAddOrderActivity.this, MainActivity.class);
        startActivity(i);
        super.onBackPressed();
    }
}