package com.voise.homeservisegraduateproject.ui.auth.register;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.databinding.FragmentRegisterBinding;
import com.voise.homeservisegraduateproject.ui.MainActivity;
import com.voise.homeservisegraduateproject.ui.auth.login.LoginActivity;


public class RegisterFragment extends Fragment {

    RegisterViewModel registerViewModel;
    FragmentRegisterBinding fragmentRegisterBinding;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        registerViewModel = ViewModelProviders.of(this).get(RegisterViewModel.class);
        fragmentRegisterBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false);
        view = fragmentRegisterBinding.getRoot();
        fragmentRegisterBinding.setLifecycleOwner(getActivity());
        onClick();
        return view;
    }

    private void onClick() {
        fragmentRegisterBinding.imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), LoginActivity.class);
                startActivity(i);
                getActivity().finish();
            }
        });

        fragmentRegisterBinding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        Intent i=new Intent(getActivity(), MainActivity.class);
        startActivity(i);
            }
        });
    }
}