package com.voise.homeservisegraduateproject.ui.uiCustomerUser.order.DetailsOrder;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.voise.homeservisegraduateproject.bojo.AllOfferResponse;
import com.voise.homeservisegraduateproject.bojo.DataOfferResponse;
import com.voise.homeservisegraduateproject.data.FunctionServer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsOrderViewModel extends ViewModel {

    MutableLiveData<List<DataOfferResponse>> listMutableLiveDataِAllWork = new MutableLiveData<>();

    public void getAllWorkData(int order_id) {
        FunctionServer.getInstanse(false).getAllOfferUserRequest(order_id).enqueue(new Callback<AllOfferResponse>() {
            @Override
            public void onResponse(Call<AllOfferResponse> call, Response<AllOfferResponse> response) {
                List<DataOfferResponse> dataWorks = new ArrayList<>(response.body().getData());
                listMutableLiveDataِAllWork.setValue(dataWorks);
                for (int i = 0; i < dataWorks.size(); i++) {
                    Log.e("sdf435345", "" + dataWorks.get(i).getName());
                }
            }

            @Override
            public void onFailure(Call<AllOfferResponse> call, Throwable t) {

            }
        });
    }
}
