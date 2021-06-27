package com.voise.homeservisegraduateproject.ui.uiCustomerUser.home;

import android.net.Uri;
import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.voise.homeservisegraduateproject.bojo.AddOrderResponse;
import com.voise.homeservisegraduateproject.data.FunctionServer;
import com.voise.homeservisegraduateproject.data.LiveDataModel;
import com.voise.homeservisegraduateproject.utils.Functions;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddOrderProblemLocationViewModel extends ViewModel {
    LiveDataModel<AddOrderResponse> authResponseMutableLiveDataRegisterCustomer = new LiveDataModel<>();

    public  void AddOrder(int id_work  , String details, String details_address, ArrayList<Uri> photo, String phone, long latitude, long longitude){
        Log.e("error33sads6","safsdfsdfsdfsdfsdf");
        FunctionServer.authorization1 = true;

        FunctionServer.getInstanse(true).AddOrder(id_work,details,details_address, photo,phone,latitude,longitude).enqueue(new Callback<AddOrderResponse>() {
            @Override
            public void onResponse(Call<AddOrderResponse> call, Response<AddOrderResponse> response) {
                Log.e("error33s11ads6","safsddd111fsdfsdfsdfsdf");

                if (response.isSuccessful()) {
                    authResponseMutableLiveDataRegisterCustomer.setValue(response.body());
                    Log.e("error336", response.message());

                } else {
                    Functions.getInstanse().hideDialog();

//                    Log.e("error3", response.+"");
                }
            }

            @Override
            public void onFailure(Call<AddOrderResponse> call, Throwable t) {
                Log.e("errordd3", t.getMessage());

            }
        });
    }

}
