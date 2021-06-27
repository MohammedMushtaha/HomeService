package com.voise.homeservisegraduateproject.ui.uiCustomerUser.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.adapter.AdapterSliderHome;
import com.voise.homeservisegraduateproject.adapter.CategoriesAdapter;
import com.voise.homeservisegraduateproject.bojo.DataWork;
import com.voise.homeservisegraduateproject.bojo.ImageModel_slider;
import com.voise.homeservisegraduateproject.databinding.FragmentHomeCustomerBinding;

import java.util.ArrayList;
import java.util.List;


public class HomeFragmentCustomer extends Fragment {

    private HomeViewModel homeViewModel;
    Context context;
    ArrayList<ImageModel_slider> modelsliders = new ArrayList<>();
    AdapterSliderHome lettersUserAnswer;
    CategoriesAdapter categoriesAdapter;
    FragmentHomeCustomerBinding fragmentHomeBinding;
    View root;

    LinearLayoutManager horizontalLayoutManagaer;

    public HomeFragmentCustomer(Context context) {
        this.context = context;

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        fragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_customer, container, false);
        root = fragmentHomeBinding.getRoot();
        fragmentHomeBinding.setLifecycleOwner(getActivity());


        loadData();

        horizontalLayoutManagaer
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        fragmentHomeBinding.recyclerView.setLayoutManager(horizontalLayoutManagaer);
        modelsliders.add(new ImageModel_slider(R.drawable.shape_slider_white));

        lettersUserAnswer = new AdapterSliderHome(getActivity(), modelsliders);
        fragmentHomeBinding.recyclerView.setAdapter(lettersUserAnswer);


        getAllWorkData();


        return root;
    }

    public void loadData() {

        modelsliders.add(new ImageModel_slider(R.drawable.a));
        modelsliders.add(new ImageModel_slider(R.drawable.ac));
        modelsliders.add(new ImageModel_slider(R.drawable.as));
        modelsliders.add(new ImageModel_slider(R.drawable.az));
    }


    public void getAllWorkData() {
        homeViewModel.getAllWorkData();
        categoriesAdapter = new CategoriesAdapter();
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 3);
        fragmentHomeBinding.recyclerViewCategory.setLayoutManager(mLayoutManager);
        fragmentHomeBinding.recyclerViewCategory.setAdapter(categoriesAdapter);
        homeViewModel.listMutableLiveDataِAllWork.observe(getActivity(), new Observer<List<DataWork>>() {
            @Override
            public void onChanged(List<DataWork> dataWorks) {

                categoriesAdapter.setList(getActivity(), dataWorks);


            }
        });
    }

}