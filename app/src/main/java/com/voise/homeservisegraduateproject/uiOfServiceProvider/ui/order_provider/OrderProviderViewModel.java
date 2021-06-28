package com.voise.homeservisegraduateproject.uiOfServiceProvider.ui.order_provider;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OrderProviderViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OrderProviderViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}