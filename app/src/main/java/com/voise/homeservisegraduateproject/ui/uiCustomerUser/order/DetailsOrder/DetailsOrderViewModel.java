package com.voise.homeservisegraduateproject.ui.uiCustomerUser.order.DetailsOrder;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.voise.homeservisegraduateproject.bojo.AllOfferResponse;
import com.voise.homeservisegraduateproject.bojo.AuthResponseProvider;
import com.voise.homeservisegraduateproject.bojo.DataOfferResponse;
import com.voise.homeservisegraduateproject.bojo.FinishOrderResponse;
import com.voise.homeservisegraduateproject.data.FunctionServer;
import com.voise.homeservisegraduateproject.data.LiveDataModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsOrderViewModel extends ViewModel {

    MutableLiveData<List<DataOfferResponse>> listMutableLiveDataِAllWork = new MutableLiveData<>();
     LiveDataModel<FinishOrderResponse> finishOrderProvider = new LiveDataModel<>();

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



    public void  FunctionFinishOrder(int order_id){

        FunctionServer.getInstanse(false).FinishOrderRequest(order_id).enqueue(new Callback<FinishOrderResponse>() {
            @Override
            public void onResponse(Call<FinishOrderResponse> call, Response<FinishOrderResponse> response) {
                if (response.isSuccessful()) {
                    finishOrderProvider.setValue(response.body());

                  } else {
                    Log.e("error2", response.message());
                }
            }

            @Override
            public void onFailure(Call<FinishOrderResponse> call, Throwable t) {
                Log.e("error1", t.getMessage());
            }
        });
    }
}
