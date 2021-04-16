package com.voise.homeservisegraduateproject.ui.auth.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;

import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.databinding.ActivityLoginBinding;
import com.voise.homeservisegraduateproject.ui.auth.register.RegisterFragment;
import com.voise.homeservisegraduateproject.utils.Functions;

public class LoginActivity extends AppCompatActivity {
    LoginViewModel loginViewModel;
    ActivityLoginBinding activityLoginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        onClick();
    }

    public void onClick() {
        activityLoginBinding.editFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.getInstanse().click_out(LoginActivity.this);
            }
        });

        activityLoginBinding.btnSignIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.editFrame, new RegisterFragment()).addToBackStack(null).commit();

            }
        });
    }
}