package com.voise.homeservisegraduateproject.ui.uiCustomerUser.order;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.voise.homeservisegraduateproject.bojo.DataUnCompletedResponse;
import com.voise.homeservisegraduateproject.bojo.UnCompletedOrderResponse;
import com.voise.homeservisegraduateproject.data.FunctionServer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UnderwayOrderViewModel extends ViewModel {

    MutableLiveData<List<DataUnCompletedResponse>> listMutableLiveDataِAllWork = new MutableLiveData<>();

    public void getAllWorkData() {
        FunctionServer.getInstanse(false).getAllUnCompleteRequest().enqueue(new Callback<UnCompletedOrderResponse>() {
            @Override
            public void onResponse(Call<UnCompletedOrderResponse> call, Response<UnCompletedOrderResponse> response) {
                List<DataUnCompletedResponse> dataWorks = new ArrayList<>(response.body().getData());
                listMutableLiveDataِAllWork.setValue(dataWorks);
                for (int i = 0; i < dataWorks.size(); i++) {
//                    Log.e("sdf435345", "" + dataWorks.get(i).getName());
                }
            }

            @Override
            public void onFailure(Call<UnCompletedOrderResponse> call, Throwable t) {

            }
        });
    }
}
