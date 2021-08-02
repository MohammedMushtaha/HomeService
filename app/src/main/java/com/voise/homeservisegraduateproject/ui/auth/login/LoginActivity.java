package com.voise.homeservisegraduateproject.ui.auth.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.SharedPreferanse.SharedPreferanse;
import com.voise.homeservisegraduateproject.bojo.AuthResponseCustomer;
import com.voise.homeservisegraduateproject.bojo.AuthResponseProvider;
import com.voise.homeservisegraduateproject.data.LiveDataModel;
import com.voise.homeservisegraduateproject.databinding.ActivityLoginBinding;
import com.voise.homeservisegraduateproject.ui.MainActivity;
import com.voise.homeservisegraduateproject.ui.auth.register.RegisterFragment;
import com.voise.homeservisegraduateproject.ui.uiCustomerUser.MainActivity2;
import com.voise.homeservisegraduateproject.uiOfServiceProvider.ServiceProviderMainActivity;
import com.voise.homeservisegraduateproject.utils.Functions;

import www.sanju.motiontoast.MotionToast;


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
                activityLoginBinding.goToGist.setVisibility(View.GONE);
            }
        });

        activityLoginBinding.signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.editFrame, new RegisterFragment()).addToBackStack(null).commit();

            }
        });

        activityLoginBinding.Customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityLoginBinding.lineCustomer.setVisibility(View.VISIBLE);
                activityLoginBinding.lineService.setVisibility(View.GONE);
                SharedPreferanse.write(SharedPreferanse.LoginChoice, "2");
                activityLoginBinding.goToGist.setVisibility(View.VISIBLE);


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
                try {
                    if (activityLoginBinding.editEmail.getText().toString().equals("") && activityLoginBinding.editPassword.getText().toString().equals("")) {

                        Functions.getInstanse().diaLog(LoginActivity.this, "فشلت عملية تسجيل الدخول", "كلمة المرور مطلوبة\nو الإيميل مطلوب", "موافق");
//                        Functions.getInstanse().func2(LoginActivity.this,"فشلت عملية تسجيل الدخول" );

                    } else if (activityLoginBinding.editEmail.getText().toString().equals("")) {

                        Functions.getInstanse().diaLog(LoginActivity.this, "فشلت عملية تسجيل الدخول", "كلمة المرور مطلوبة", "موافق");
//                        Functions.getInstanse().func2(LoginActivity.this,"فشلت عملية تسجيل الدخول" );

                    } else if (activityLoginBinding.editPassword.getText().toString().equals("")) {

                        Functions.getInstanse().diaLog(LoginActivity.this, "فشلت عملية تسجيل الدخول", "الإيميل مطلوب", "موافق");
//                        Functions.getInstanse().func2(LoginActivity.this,"فشلت عملية تسجيل الدخول" );

                    } else {
                        LoginResponse();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        activityLoginBinding.goToGist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferanse.write(SharedPreferanse.gist, "1");

                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });
    }

    private void LoadFragment() {
        SharedPreferanse.write(SharedPreferanse.gist, "0");
        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(i);
        finish();

    }

    private void LoadFragmentProvider() {
        SharedPreferanse.write(SharedPreferanse.gist, "0");

        Intent i = new Intent(LoginActivity.this, ServiceProviderMainActivity.class);
        startActivity(i);
        finish();

    }

    public void LoginResponse() {

        if (SharedPreferanse.read(SharedPreferanse.LoginChoice, "1").equals("1")) {
            Functions.getInstanse().showDialog(LoginActivity.this, "Please Waite");
            addDataServiceProvider();
            Log.e("ex1", "4");
            loginViewModel.authResponseMutableLiveDataProvider.observe(this, new LiveDataModel.Observer<AuthResponseProvider>() {
                @Override
                public void onChanged(AuthResponseProvider authResponse) {
                    Log.e("ex1", "5");

                    if (authResponse.isStatus()) {
                        Functions.getInstanse().hideDialog();
                        Log.e("ex1", "6");
//                        Toast.makeText(LoginActivity.this, "Donee", Toast.LENGTH_SHORT).show();
                        SharedPreferanse.write(SharedPreferanse.IDProvider, authResponse.getData().getId() + "");
                        SharedPreferanse.write(SharedPreferanse.USERNAMEProvider, authResponse.getData().getEmail());
                        SharedPreferanse.write(SharedPreferanse.EmailProvider, authResponse.getData().getName());
                        SharedPreferanse.write(SharedPreferanse.IMAGEProvider, authResponse.getData().getPhoto());
                        SharedPreferanse.write(SharedPreferanse.MOBILEProvider, authResponse.getData().getPhone());
                        SharedPreferanse.write(SharedPreferanse.active, authResponse.getData().getActive());
                        SharedPreferanse.write(SharedPreferanse.WorkId, authResponse.getData().getActive());
                        SharedPreferanse.write(SharedPreferanse.TOKEN, "Bearer " + authResponse.getData().getToken());
                        LoadFragmentProvider();

                    } else {
                        Functions.getInstanse().hideDialog();
                        Functions.getInstanse().diaLog(LoginActivity.this, "فشلت عملية تسجيل الدخول", authResponse.getMessage(), "موافق");
//                    Functions.getInstanse().func2(LoginActivity.this,"فشلت عملية تسجيل الدخول"+authResponse.getMessage());
                        Log.e("sdsdsdsd", "1111");
//                        Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();

                    }

                }
            });
        } else {

            Functions.getInstanse().showDialog(LoginActivity.this, "Please Waite");
            Log.e("ex1", "3");
            addDataCustomer();
            loginViewModel.authResponseMutableLiveDataCustomer.observe(this, new LiveDataModel.Observer<AuthResponseCustomer>() {
                @Override
                public void onChanged(AuthResponseCustomer authResponse) {
                    Log.e("ex1", "2");

                    if (authResponse.isStatus()) {
                        Functions.getInstanse().hideDialog();
                        Log.e("ex1", "00");
//                        Toast.makeText(LoginActivity.this, "Donee", Toast.LENGTH_SHORT).show();
                        SharedPreferanse.write(SharedPreferanse.IDCustomer, authResponse.getData().getId() + "");
                        SharedPreferanse.write(SharedPreferanse.USERNAMECustomer, authResponse.getData().getEmail());
                        SharedPreferanse.write(SharedPreferanse.EmailCustomer, authResponse.getData().getName());
                        SharedPreferanse.write(SharedPreferanse.IMAGECustomer, authResponse.getData().getPhoto());
                        SharedPreferanse.write(SharedPreferanse.MOBILECustomer, authResponse.getData().getPhone());
                        SharedPreferanse.write(SharedPreferanse.active, authResponse.getData().getActive());
                        SharedPreferanse.write(SharedPreferanse.TOKEN, "Bearer " + authResponse.getData().getToken());
                        LoadFragment();

//                        MotionToast.Companion.createToast(
//                                LoginActivity.this,
//                                "You can't send empty message !",
//                                MotionToast.TOAST_ERROR,
//                                MotionToast.GRAVITY_BOTTOM,
//                                MotionToast.SHORT_DURATION,
//                                ResourcesCompat.getFont(LoginActivity.this, R.font.helvetica_regular));


                    } else {
                        Functions.getInstanse().hideDialog();

                        Functions.getInstanse().diaLog(LoginActivity.this, "فشلت عملية تسجيل الدخول", authResponse.getMessage(), "موافق");
                        Log.e("ex1", "1111");
//                        Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();

                    }

                }
            });


        }

    }

    public void addDataCustomer() {
        String email = activityLoginBinding.editEmail.getText().toString();
        String pass = activityLoginBinding.editPassword.getText().toString();
        loginViewModel.loginFunctionAsCustomer(email, pass);

    }

    public void addDataServiceProvider() {
        String email = activityLoginBinding.editEmail.getText().toString();
        String pass = activityLoginBinding.editPassword.getText().toString();
        loginViewModel.loginFunctionServiceProvider(email, pass);

    }

}