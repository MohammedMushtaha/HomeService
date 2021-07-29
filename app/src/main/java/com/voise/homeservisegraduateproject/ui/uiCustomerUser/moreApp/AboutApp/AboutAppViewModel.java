package com.voise.homeservisegraduateproject.ui.uiCustomerUser.moreApp.AboutApp;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.voise.homeservisegraduateproject.bojo.AllWorkDataResponse;
import com.voise.homeservisegraduateproject.bojo.DataInformation;
import com.voise.homeservisegraduateproject.bojo.DataWork;
import com.voise.homeservisegraduateproject.bojo.InformationApp;
import com.voise.homeservisegraduateproject.data.FunctionServer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AboutAppViewModel extends ViewModel {
    MutableLiveData<List<DataInformation>> listMutableLiveDataِInformationAllWork = new MutableLiveData<>();

    public void getAllInformationkData() {
        FunctionServer.getInstanse(false).getAllDataInformationResponse().enqueue(new Callback<InformationApp>() {
            @Override
            public void onResponse(Call<InformationApp> call, Response<InformationApp> response) {
                List<DataInformation> dataWorks = new ArrayList<>(response.body().getData());
                listMutableLiveDataِInformationAllWork.setValue(dataWorks);
                for (int i = 0; i < dataWorks.size(); i++) {
                    Log.e("sdf43sa5345", "" + dataWorks.get(i).getName());
                }
            }

            @Override
            public void onFailure(Call<InformationApp> call, Throwable t) {
                Log.e("sdf412e45", "" +t);

            }
        });
    }
}
