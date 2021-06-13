package com.voise.homeservisegraduateproject.ui.auth.login;

import android.util.Log;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.voise.homeservisegraduateproject.bojo.AuthResponseCustomer;
import com.voise.homeservisegraduateproject.bojo.AuthResponseProvider;
import com.voise.homeservisegraduateproject.data.FunctionServer;
import com.voise.homeservisegraduateproject.data.LiveDataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {

    LiveDataModel<AuthResponseCustomer> authResponseMutableLiveDataCustomer = new LiveDataModel<>();
    LiveDataModel<AuthResponseProvider> authResponseMutableLiveDataProvider = new LiveDataModel<>();
    public final ObservableField<String> emailEdit = new ObservableField<>("");
    public final ObservableField<String> passEdit = new ObservableField<>("");


    public void loginFunctionServiceProvider(String email ,String pass){

        FunctionServer.getInstanse(false).loginAsServiceProvider(email, pass).enqueue(new Callback<AuthResponseProvider>() {
            @Override
            public void onResponse(Call<AuthResponseProvider> call, Response<AuthResponseProvider> response) {
                if (response.isSuccessful()) {
                    authResponseMutableLiveDataProvider.setValue(response.body());
                    Log.e("response2", response.body().getMessage());
                } else {
                    Log.e("error2", response.message());
                }
            }

            @Override
            public void onFailure(Call<AuthResponseProvider> call, Throwable t) {
                Log.e("error1", t.getMessage());
            }
        });
    }





    public void loginFunctionAsCustomer(String email ,String pass) {

        FunctionServer.getInstanse(false).loginAsCustomer(email, pass).enqueue(new Callback<AuthResponseCustomer>() {
            @Override
            public void onResponse(Call<AuthResponseCustomer> call, Response<AuthResponseCustomer> response) {
                if (response.isSuccessful()) {
                    authResponseMutableLiveDataCustomer.setValue(response.body());
                    Log.e("response2", response.body().getMessage());

                } else {
                    Log.e("error2", response.message());
                }
            }

            @Override
            public void onFailure(Call<AuthResponseCustomer> call, Throwable t) {
                Log.e("error1", t.getMessage());

            }
        });
    }
}