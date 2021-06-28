package com.voise.homeservisegraduateproject.uiOfServiceProvider.ui.home_provider;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.voise.homeservisegraduateproject.bojo.AllWorkDataResponse;
import com.voise.homeservisegraduateproject.bojo.DataHomeProviderResponse;
import com.voise.homeservisegraduateproject.bojo.DataWork;
import com.voise.homeservisegraduateproject.bojo.HomeProviderResponse;
import com.voise.homeservisegraduateproject.data.FunctionServer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeProviderViewModel extends ViewModel {

    MutableLiveData<List<DataHomeProviderResponse>> listMutableLiveDataِAllWork = new MutableLiveData<>();

    public void getAllWorkProvider() {
        FunctionServer.getInstanse(false).HomeProviderService("DESC").enqueue(new Callback<HomeProviderResponse>() {
            @Override
            public void onResponse(Call<HomeProviderResponse> call, Response<HomeProviderResponse> response) {
                List<DataHomeProviderResponse> dataWorks = new ArrayList<>(response.body().getData());
                listMutableLiveDataِAllWork.setValue(dataWorks);
                for (int i = 0; i < dataWorks.size(); i++) {
//                    Log.e("sdf435345", "" + dataWorks.get(i).getName());
                }
            }

            @Override
            public void onFailure(Call<HomeProviderResponse> call, Throwable t) {

            }
        });
    }
}