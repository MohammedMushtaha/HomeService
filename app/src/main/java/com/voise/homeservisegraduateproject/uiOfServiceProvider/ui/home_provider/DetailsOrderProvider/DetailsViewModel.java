package com.voise.homeservisegraduateproject.uiOfServiceProvider.ui.home_provider.DetailsOrderProvider;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.voise.homeservisegraduateproject.bojo.AcceptUserResponse;
import com.voise.homeservisegraduateproject.bojo.CreateOfferResponse;
import com.voise.homeservisegraduateproject.data.FunctionServer;
import com.voise.homeservisegraduateproject.data.LiveDataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsViewModel extends ViewModel {
    LiveDataModel<CreateOfferResponse> authResponseMutableLiveDataCreateOffer = new LiveDataModel<>();

    public void createOfferRequest( int order_id){

        FunctionServer.getInstanse(false).createOfferRequest( order_id).enqueue(new Callback<CreateOfferResponse>() {
            @Override
            public void onResponse(Call<CreateOfferResponse> call, Response<CreateOfferResponse> response) {
                if (response.isSuccessful()) {

                    authResponseMutableLiveDataCreateOffer.setValue(response.body());
                    Log.e("response2", response.body().getMessage());
                } else {
                    Log.e("error2", response.message());
                }
            }

            @Override
            public void onFailure(Call<CreateOfferResponse> call, Throwable t) {
                Log.e("error1", t.getMessage());
            }
        });
    }


}
