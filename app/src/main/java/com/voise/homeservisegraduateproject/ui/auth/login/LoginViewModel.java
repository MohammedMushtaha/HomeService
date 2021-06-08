package com.voise.homeservisegraduateproject.ui.auth.login;

import android.util.Log;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.voise.homeservisegraduateproject.bojo.AuthResponse;
import com.voise.homeservisegraduateproject.data.FunctionServer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {

    MutableLiveData<AuthResponse> authResponseMutableLiveData = new MutableLiveData<>();
    public final ObservableField<String> emailEdit = new ObservableField<>("");
    public final ObservableField<String> passEdit = new ObservableField<>("");


    public void loginFunction() {

        FunctionServer.getInstanse(false).loginAsServiceProvider(String.valueOf(emailEdit), String.valueOf(passEdit)).enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                if (response.isSuccessful()) {
                    authResponseMutableLiveData.setValue(response.body());
                    Log.e("response2", response.body().getMessage());
                } else {
                    Log.e("error2", response.message());
                }
            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {
                Log.e("error1", t.getMessage());
            }
        });
    }





    public void loginFunctionAsCustomer() {

        FunctionServer.getInstanse(false).loginAsCustomer(String.valueOf(emailEdit), String.valueOf(passEdit)).enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                if (response.isSuccessful()) {
                    authResponseMutableLiveData.setValue(response.body());
                    Log.e("response2", response.body().getMessage());

                } else {
                    Log.e("error2", response.message());
                }
            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {
                Log.e("error1", t.getMessage());

            }
        });
    }
}