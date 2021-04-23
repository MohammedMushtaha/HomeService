package com.voise.homeservisegraduateproject.ui.ui.moreApp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

 import com.voise.homeservisegraduateproject.R;

public class MoreFragment extends Fragment {

    private MoreViewModel dashboardViewModel;
    Context context;

    public MoreFragment(Context context) {
        this.context = context;

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(MoreViewModel.class);
        View root = inflater.inflate(R.layout.fragment_more, container, false);

        return root;
    }
}