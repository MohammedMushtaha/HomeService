package com.voise.homeservisegraduateproject.ui.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.voise.homeservisegraduateproject.bojo.CategoryData;

import java.util.List;

public class HomeViewModel extends ViewModel {

    MutableLiveData<List<CategoryData>> listMutableLiveData = new MutableLiveData<>();



}