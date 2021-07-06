package com.voise.homeservisegraduateproject.ui.uiCustomerUser.order;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.voise.homeservisegraduateproject.bojo.CompletedOrderResponse;
import com.voise.homeservisegraduateproject.bojo.DataCompletedResponse;
import com.voise.homeservisegraduateproject.bojo.DataPendingOrderResponse;
import com.voise.homeservisegraduateproject.bojo.PendingOrderResponse;
import com.voise.homeservisegraduateproject.data.FunctionServer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompletedOrderViewModel extends ViewModel {
    MutableLiveData<List<DataCompletedResponse>> listMutableLiveDataِAllWork = new MutableLiveData<>();

    public void getAllCompletedData() {
        FunctionServer.getInstanse(false).getAllCompleteRequest().enqueue(new Callback<CompletedOrderResponse>() {
            @Override
            public void onResponse(Call<CompletedOrderResponse> call, Response<CompletedOrderResponse> response) {
                List<DataCompletedResponse> dataWorks = new ArrayList<>(response.body().getData());
                listMutableLiveDataِAllWork.setValue(dataWorks);
                for (int i = 0; i < dataWorks.size(); i++) {
//                    Log.e("sdf435345", "" + dataWorks.get(i).getName());
                }
            }

            @Override
            public void onFailure(Call<CompletedOrderResponse> call, Throwable t) {

            }
        });
    }
}