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
import com.voise.homeservisegraduateproject.bojo.CategoryData;
import com.voise.homeservisegraduateproject.bojo.ImageModel_slider;
import com.voise.homeservisegraduateproject.databinding.FragmentHomeBinding;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    Context context;
    ArrayList<ImageModel_slider> modelsliders = new ArrayList<>();
    ArrayList<CategoryData> categoryData = new ArrayList<>();
    AdapterSliderHome lettersUserAnswer;
    CategoriesAdapter categoriesAdapter;
    FragmentHomeBinding binding;
    View root;

    LinearLayoutManager horizontalLayoutManagaer;

    public HomeFragment(Context context) {
        this.context = context;

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        root = binding.getRoot();
        binding.setLifecycleOwner(getActivity());


        //        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        loadData();

        horizontalLayoutManagaer
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        binding.recyclerView.setLayoutManager(horizontalLayoutManagaer);
        modelsliders.add(new ImageModel_slider(R.drawable.shape_slider_white));

        lettersUserAnswer = new AdapterSliderHome(getActivity(), modelsliders);
        binding.recyclerView.setAdapter(lettersUserAnswer);


        loadDataCategory();

        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 3);

        binding.recyclerViewCategory.setLayoutManager(mLayoutManager);
        categoriesAdapter = new CategoriesAdapter();

        categoriesAdapter.setList(getActivity(),categoryData);
        binding.recyclerViewCategory.setAdapter(categoriesAdapter);




        return root;
    }

    public void loadData() {

        modelsliders.add(new ImageModel_slider(R.drawable.shape_slider_white));
        modelsliders.add(new ImageModel_slider(R.drawable.shape_slider_white));
        modelsliders.add(new ImageModel_slider(R.drawable.shape_slider_white));
        modelsliders.add(new ImageModel_slider(R.drawable.shape_slider_white));
    }


    public void loadDataCategory() {

        categoryData.add(new CategoryData(1,R.drawable.ic_logo,"Electricity"));
        categoryData.add(new CategoryData(1,R.drawable.ic_electricity_logo,"Electricity"));
        categoryData.add(new CategoryData(1,R.drawable.ic_electricity_logo,"Electricity"));
        categoryData.add(new CategoryData(1,R.drawable.ic_electricity_logo,"Electricity"));
        categoryData.add(new CategoryData(1,R.drawable.ic_electricity_logo,"Electricity"));
        categoryData.add(new CategoryData(1,R.drawable.ic_electricity_logo,"Electricity"));
        categoryData.add(new CategoryData(1,R.drawable.ic_electricity_logo,"Electricity"));

    }

}