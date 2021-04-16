package com.voise.homeservisegraduateproject.ui.ui.userSetting;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserSettingFragmentViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public UserSettingFragmentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}