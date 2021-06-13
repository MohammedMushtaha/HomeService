package com.voise.homeservisegraduateproject.ui.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.adapter.AdapterSliderHome;
import com.voise.homeservisegraduateproject.adapter.CategoriesAdapter;
import com.voise.homeservisegraduateproject.adapter.SpinnerAdapter;
import com.voise.homeservisegraduateproject.bojo.CategoryData;
import com.voise.homeservisegraduateproject.bojo.DataWork;
import com.voise.homeservisegraduateproject.bojo.ImageModel_slider;
import com.voise.homeservisegraduateproject.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    Context context;
    ArrayList<ImageModel_slider> modelsliders = new ArrayList<>();
    AdapterSliderHome lettersUserAnswer;
    CategoriesAdapter categoriesAdapter;
    FragmentHomeBinding fragmentHomeBinding;
    View root;

    LinearLayoutManager horizontalLayoutManagaer;

    public HomeFragment(Context context) {
        this.context = context;

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        fragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
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

        modelsliders.add(new ImageModel_slider(R.drawable.shape_slider_white));
        modelsliders.add(new ImageModel_slider(R.drawable.shape_slider_white));
        modelsliders.add(new ImageModel_slider(R.drawable.shape_slider_white));
        modelsliders.add(new ImageModel_slider(R.drawable.shape_slider_white));
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