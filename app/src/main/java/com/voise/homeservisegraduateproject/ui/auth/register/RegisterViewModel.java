package com.voise.homeservisegraduateproject.ui.auth.register;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.voise.homeservisegraduateproject.bojo.AllWorkDataResponse;
import com.voise.homeservisegraduateproject.bojo.AuthResponseCustomer;
import com.voise.homeservisegraduateproject.bojo.AuthResponseProvider;
import com.voise.homeservisegraduateproject.bojo.DataWork;
import com.voise.homeservisegraduateproject.data.FunctionServer;
import com.voise.homeservisegraduateproject.data.LiveDataModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterViewModel extends ViewModel {
    MutableLiveData<List<DataWork>> listMutableLiveData = new MutableLiveData<>();
    LiveDataModel<AuthResponseCustomer> authResponseMutableLiveDataRegisterCustomer = new LiveDataModel<>();
    LiveDataModel<AuthResponseProvider> authResponseMutableLiveDataRegisterProvider = new LiveDataModel<>();

    public void getAllWorkData() {
        FunctionServer.getInstanse(false).getAllWorkResponse().enqueue(new Callback<AllWorkDataResponse>() {
            @Override
            public void onResponse(Call<AllWorkDataResponse> call, Response<AllWorkDataResponse> response) {
                List<DataWork> dataWorks = new ArrayList<>(response.body().getData());
                listMutableLiveData.setValue(dataWorks);
                for (int i = 0; i < dataWorks.size(); i++) {
                    Log.e("sdf435345", "" + dataWorks.get(i).getName());
                }
            }

            @Override
            public void onFailure(Call<AllWorkDataResponse> call, Throwable t) {

            }
        });
    }

    public void RegisterFunctionServiceUser(String name, String email, String pass, String phone) {

        FunctionServer.getInstanse(false).RegisterCustomer(name, email, pass, phone).enqueue(new Callback<AuthResponseCustomer>() {
            @Override
            public void onResponse(Call<AuthResponseCustomer> call, Response<AuthResponseCustomer> response) {
                if (response.isSuccessful()) {
                    authResponseMutableLiveDataRegisterCustomer.setValue(response.body());
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


    public void RegisterFunctionServiceProvider(String name, String email, String pass, String phone,int work_id) {

        FunctionServer.getInstanse(false).RegisterProvider(name, email, pass, phone,work_id).enqueue(new Callback<AuthResponseProvider>() {
            @Override
            public void onResponse(Call<AuthResponseProvider> call, Response<AuthResponseProvider> response) {
                if (response.isSuccessful()) {
                    authResponseMutableLiveDataRegisterProvider.setValue(response.body());
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
}
