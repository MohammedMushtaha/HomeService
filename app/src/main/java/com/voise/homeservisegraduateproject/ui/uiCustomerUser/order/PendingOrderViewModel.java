package com.voise.homeservisegraduateproject.ui.uiCustomerUser.order;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.voise.homeservisegraduateproject.bojo.DataPendingOrderResponse;
import com.voise.homeservisegraduateproject.bojo.PendingOrderResponse;
import com.voise.homeservisegraduateproject.data.FunctionServer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PendingOrderViewModel extends ViewModel {
    MutableLiveData<List<DataPendingOrderResponse>> listMutableLiveDataِAllWork = new MutableLiveData<>();

    public void getAllWorkData() {
        FunctionServer.getInstanse(false).getAllPendingRequest().enqueue(new Callback<PendingOrderResponse>() {
            @Override
            public void onResponse(Call<PendingOrderResponse> call, Response<PendingOrderResponse> response) {
                List<DataPendingOrderResponse> dataWorks = new ArrayList<>(response.body().getData());
                listMutableLiveDataِAllWork.setValue(dataWorks);
                for (int i = 0; i < dataWorks.size(); i++) {
//                    Log.e("sdf435345", "" + dataWorks.get(i).getName());
                }
            }

            @Override
            public void onFailure(Call<PendingOrderResponse> call, Throwable t) {

            }
        });
    }
}