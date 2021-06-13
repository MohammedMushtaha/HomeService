package com.voise.homeservisegraduateproject.ui.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.voise.homeservisegraduateproject.bojo.AllWorkDataResponse;
import com.voise.homeservisegraduateproject.bojo.CategoryData;
import com.voise.homeservisegraduateproject.bojo.DataWork;
import com.voise.homeservisegraduateproject.data.FunctionServer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {

    MutableLiveData<List<CategoryData>> listMutableLiveData = new MutableLiveData<>();
    MutableLiveData<List<DataWork>> listMutableLiveDataِAllWork = new MutableLiveData<>();

    public void getAllWorkData() {
        FunctionServer.getInstanse(false).getAllWorkResponse().enqueue(new Callback<AllWorkDataResponse>() {
            @Override
            public void onResponse(Call<AllWorkDataResponse> call, Response<AllWorkDataResponse> response) {
                List<DataWork> dataWorks = new ArrayList<>(response.body().getData());
                listMutableLiveDataِAllWork.setValue(dataWorks);
                for (int i = 0; i < dataWorks.size(); i++) {
                    Log.e("sdf435345", "" + dataWorks.get(i).getName());
                }
            }

            @Override
            public void onFailure(Call<AllWorkDataResponse> call, Throwable t) {

            }
        });
    }

}