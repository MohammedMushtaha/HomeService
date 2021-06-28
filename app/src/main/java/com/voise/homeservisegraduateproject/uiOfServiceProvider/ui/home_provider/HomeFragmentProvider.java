package com.voise.homeservisegraduateproject.uiOfServiceProvider.ui.home_provider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.SharedPreferanse.SharedPreferanse;
import com.voise.homeservisegraduateproject.adapter.CategoriesAdapter;
import com.voise.homeservisegraduateproject.adapter.HomeProviderAdapter;
import com.voise.homeservisegraduateproject.bojo.DataHomeProviderResponse;
import com.voise.homeservisegraduateproject.bojo.DataWork;
import com.voise.homeservisegraduateproject.ui.auth.login.LoginActivity;
import com.voise.homeservisegraduateproject.ui.uiCustomerUser.MainActivity2;
import com.voise.homeservisegraduateproject.ui.uiCustomerUser.home.HomeViewModel;

import java.util.List;

public class HomeFragmentProvider extends Fragment {

    private HomeProviderViewModel homeViewModel;
    HomeProviderAdapter homeProviderAdapter;
    RecyclerView recyclerViewServiceProvider;
    Context context;

    public HomeFragmentProvider(Context context) {
        this.context = context;

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeProviderViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

//        fragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
//        root = fragmentHomeBinding.getRoot();
//        fragmentHomeBinding.setLifecycleOwner(getActivity());
        recyclerViewServiceProvider= root.findViewById(R.id.recyclerViewServiceProvider);
        getAllWorkDataProvider();
        return root;


}

    public void getAllWorkDataProvider() {
        homeViewModel.getAllWorkProvider();
        homeProviderAdapter = new HomeProviderAdapter();

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerViewServiceProvider.setLayoutManager(mLayoutManager);
        recyclerViewServiceProvider.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerViewServiceProvider.setItemAnimator(new DefaultItemAnimator());

         recyclerViewServiceProvider.setAdapter(homeProviderAdapter);
        homeViewModel.listMutableLiveDataِAllWork.observe(getActivity(), new Observer<List<DataHomeProviderResponse>>() {
            @Override
            public void onChanged(List<DataHomeProviderResponse> dataWorks) {

                homeProviderAdapter.setList(getActivity(), dataWorks);


            }
        });
    }
    }
