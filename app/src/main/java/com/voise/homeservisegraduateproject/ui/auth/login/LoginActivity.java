package com.voise.homeservisegraduateproject.ui.auth.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.SharedPreferanse.SharedPreferanse;
import com.voise.homeservisegraduateproject.bojo.AuthResponse;
import com.voise.homeservisegraduateproject.databinding.ActivityLoginBinding;
import com.voise.homeservisegraduateproject.ui.MainActivity;
import com.voise.homeservisegraduateproject.utils.Functions;



public class LoginActivity extends AppCompatActivity {
    LoginViewModel loginViewModel;
    ActivityLoginBinding activityLoginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        activityLoginBinding.setViewModel(loginViewModel);
        activityLoginBinding.setLifecycleOwner(this);
        SharedPreferanse.write(SharedPreferanse.LoginChoice, "1");

        onClick();
    }

    public void onClick() {
        activityLoginBinding.ServiceProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityLoginBinding.lineService.setVisibility(View.VISIBLE);
                activityLoginBinding.lineCustomer.setVisibility(View.GONE);
                SharedPreferanse.write(SharedPreferanse.LoginChoice, "1");

            }
        });
        activityLoginBinding.Customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityLoginBinding.lineCustomer.setVisibility(View.VISIBLE);
                activityLoginBinding.lineService.setVisibility(View.GONE);
                SharedPreferanse.write(SharedPreferanse.LoginChoice, "2");


            }
        });
        activityLoginBinding.editFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.getInstanse().click_out(LoginActivity.this);
            }
        });

        activityLoginBinding.btnSignIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "sd", Toast.LENGTH_SHORT).show();
                try {
                    if (activityLoginBinding.editEmail.getText().toString().equals("") && activityLoginBinding.editPassword.getText().toString().equals("")) {

                        Functions.getInstanse().diaLog(LoginActivity.this, "فشلت عملية تسجيل الدخول", "كلمة المرور مطلوبة\nو الإيميل مطلوب", "موافق");

                    } else if (activityLoginBinding.editEmail.getText().toString().equals("")) {

                        Functions.getInstanse().diaLog(LoginActivity.this, "فشلت عملية تسجيل الدخول", "كلمة المرور مطلوبة", "موافق");

                    } else if (activityLoginBinding.editPassword.getText().toString().equals("")) {

                        Functions.getInstanse().diaLog(LoginActivity.this, "فشلت عملية تسجيل الدخول", "الإيميل مطلوب", "موافق");

                    } else {
                        LoginResponse();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void LoadFragment() {
        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(i);
    }

    public void LoginResponse() {

        if (SharedPreferanse.read(SharedPreferanse.LoginChoice, "1").equals("1")) {
            Functions.getInstanse().showDialog(LoginActivity.this, "Please Waite");
            loginViewModel.loginFunction();
            Log.e("ex1", "4");
            loginViewModel.authResponseMutableLiveData.observe(this, new Observer<AuthResponse>() {
                @Override
                public void onChanged(AuthResponse authResponse) {
                    Log.e("ex1", "5");

                    if (authResponse.isStatus()) {
                        Functions.getInstanse().hideDialog();
                        Log.e("ex1", "6");
                        Toast.makeText(LoginActivity.this, "Done", Toast.LENGTH_SHORT).show();
                        SharedPreferanse.write(SharedPreferanse.ID, authResponse.getData().getId() + "");
                        SharedPreferanse.write(SharedPreferanse.EMAIL, authResponse.getData().getName());
                        SharedPreferanse.write(SharedPreferanse.USERNAME, authResponse.getData().getEmail());
                        SharedPreferanse.write(SharedPreferanse.IMAGE, authResponse.getData().getPhoto());
                        SharedPreferanse.write(SharedPreferanse.MOBILE, authResponse.getData().getPhone());
                        SharedPreferanse.write(SharedPreferanse.active, authResponse.getData().getActive());
                        SharedPreferanse.write(SharedPreferanse.TOKEN, authResponse.getData().getToken());
                        LoadFragment();

                    } else {
                        Functions.getInstanse().hideDialog();

                        Functions.getInstanse().diaLog(LoginActivity.this, "فشلت عملية تسجيل الدخول", authResponse.getMessage(), "موافق");
                        Log.e("sdsdsdsd", "1111");
                        Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();

                    }

                }
            });
        } else {

            Functions.getInstanse().showDialog(LoginActivity.this, "Please Waite");
            loginViewModel.loginFunctionAsCustomer();
            Log.e("ex1", "3");
            loginViewModel.authResponseMutableLiveData.observe(this, new Observer<AuthResponse>() {
                @Override
                public void onChanged(AuthResponse authResponse) {
                    Log.e("ex1", "2");

                    if (authResponse.isStatus()) {
                        Functions.getInstanse().hideDialog();
                        Log.e("ex1", "00");
                        Toast.makeText(LoginActivity.this, "Done", Toast.LENGTH_SHORT).show();
                        SharedPreferanse.write(SharedPreferanse.ID, authResponse.getData().getId() + "");
                        SharedPreferanse.write(SharedPreferanse.EMAIL, authResponse.getData().getName());
                        SharedPreferanse.write(SharedPreferanse.USERNAME, authResponse.getData().getEmail());
                        SharedPreferanse.write(SharedPreferanse.IMAGE, authResponse.getData().getPhoto());
                        SharedPreferanse.write(SharedPreferanse.MOBILE, authResponse.getData().getPhone());
                        SharedPreferanse.write(SharedPreferanse.active, authResponse.getData().getActive());
                        SharedPreferanse.write(SharedPreferanse.TOKEN, authResponse.getData().getToken());
                        LoadFragment();

                    } else {
                        Functions.getInstanse().hideDialog();

                        Functions.getInstanse().diaLog(LoginActivity.this, "فشلت عملية تسجيل الدخول", authResponse.getMessage(), "موافق");
                        Log.e("ex1", "1111");
                        Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();

                    }

                }
            });


        }

    }
    public void addData(){

    }

}