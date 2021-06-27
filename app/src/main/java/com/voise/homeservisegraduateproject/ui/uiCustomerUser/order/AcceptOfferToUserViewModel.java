package com.voise.homeservisegraduateproject.ui.uiCustomerUser.order;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.voise.homeservisegraduateproject.bojo.AcceptUserResponse;
import com.voise.homeservisegraduateproject.data.FunctionServer;
import com.voise.homeservisegraduateproject.data.LiveDataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AcceptOfferToUserViewModel extends ViewModel {
    LiveDataModel<AcceptUserResponse> authResponseMutableLiveDataProvider = new LiveDataModel<>();

    public void loginFunctionServiceProvider(String delivery_id ,String order_id){

        FunctionServer.getInstanse(false).AcceptOfferUserRequest(delivery_id, order_id).enqueue(new Callback<AcceptUserResponse>() {
            @Override
            public void onResponse(Call<AcceptUserResponse> call, Response<AcceptUserResponse> response) {
                if (response.isSuccessful()) {
                    authResponseMutableLiveDataProvider.setValue(response.body());
                    Log.e("response2", response.body().getMessage());
                } else {
                    Log.e("error2", response.message());
                }
            }

            @Override
            public void onFailure(Call<AcceptUserResponse> call, Throwable t) {
                Log.e("error1", t.getMessage());
            }
        });
    }
}
