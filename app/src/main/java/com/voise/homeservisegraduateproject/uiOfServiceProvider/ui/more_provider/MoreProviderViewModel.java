package com.voise.homeservisegraduateproject.uiOfServiceProvider.ui.more_provider;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MoreProviderViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MoreProviderViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}