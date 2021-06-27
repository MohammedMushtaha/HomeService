package com.voise.homeservisegraduateproject.ui.auth.register;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.SharedPreferanse.SharedPreferanse;
import com.voise.homeservisegraduateproject.adapter.SpinnerAdapter;
import com.voise.homeservisegraduateproject.bojo.AuthResponseCustomer;
import com.voise.homeservisegraduateproject.bojo.AuthResponseProvider;
import com.voise.homeservisegraduateproject.bojo.DataWork;
import com.voise.homeservisegraduateproject.data.LiveDataModel;
import com.voise.homeservisegraduateproject.databinding.FragmentRegisterBinding;
import com.voise.homeservisegraduateproject.ui.MainActivity;
import com.voise.homeservisegraduateproject.ui.auth.login.LoginActivity;
import com.voise.homeservisegraduateproject.ui.uiCustomerUser.MainActivity2;
import com.voise.homeservisegraduateproject.utils.Functions;

import java.util.List;


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
        SharedPreferanse.write(SharedPreferanse.RegisterChoice, "2");
        registerViewModel.getAllWorkData();
        getAllWorkData();
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

        fragmentRegisterBinding.ServiceProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentRegisterBinding.lineService.setVisibility(View.VISIBLE);
                fragmentRegisterBinding.lineCustomer.setVisibility(View.GONE);
                SharedPreferanse.write(SharedPreferanse.RegisterChoice, "2");
                fragmentRegisterBinding.servesSpinner.setVisibility(View.VISIBLE);

            }
        });
        fragmentRegisterBinding.Customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentRegisterBinding.lineCustomer.setVisibility(View.VISIBLE);
                fragmentRegisterBinding.lineService.setVisibility(View.GONE);
                SharedPreferanse.write(SharedPreferanse.RegisterChoice, "1");
                fragmentRegisterBinding.servesSpinner.setVisibility(View.GONE);


            }
        });
        fragmentRegisterBinding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {
                    if (fragmentRegisterBinding.editName1.getText().toString().equals("") || fragmentRegisterBinding.editEmail1.getText().toString().equals("") || fragmentRegisterBinding.editPassword1.getText().toString().equals("") || fragmentRegisterBinding.editPhone1.getText().toString().equals("")) {

                        Functions.getInstanse().diaLog(getActivity(), "فشلت عملية تسجيل الدخول", "جميع الحقول مطلوبة", "موافق");


                    } else {
                        RegisterResponse();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    private void LoadFragment() {
        Intent i = new Intent(getActivity(), MainActivity.class);
        startActivity(i);
    }
    private void LoadFragmentProvider() {
        Intent i = new Intent(getActivity(), MainActivity2.class);
        startActivity(i);
    }
    public void getAllWorkData() {

        registerViewModel.listMutableLiveData.observe(getActivity(), new Observer<List<DataWork>>() {
            @Override
            public void onChanged(List<DataWork> dataWorks) {

                SpinnerAdapter customAdapter = new SpinnerAdapter(getActivity(), R.layout.item_custome_spinner, dataWorks);
                fragmentRegisterBinding.servesSpinner.setAdapter(customAdapter);


            }
        });
    }


    public void RegisterResponse() {

        if (SharedPreferanse.read(SharedPreferanse.RegisterChoice, "1").equals("1")) {
            Functions.getInstanse().showDialog(getActivity(), "Please Waite");
            addDataCustomer();
            Log.e("ex1", "4");
            registerViewModel.authResponseMutableLiveDataRegisterCustomer.observe(getActivity(), new LiveDataModel.Observer<AuthResponseCustomer>() {
                @Override
                public void onChanged(AuthResponseCustomer authResponse) {
                    Log.e("ex1", "5");

                    if (authResponse.isStatus()) {
                        Functions.getInstanse().hideDialog();
                         Toast.makeText(getActivity(), "Donee", Toast.LENGTH_SHORT).show();
                        SharedPreferanse.write(SharedPreferanse.IDCustomer, authResponse.getData().getId() + "");
                        SharedPreferanse.write(SharedPreferanse.USERNAMECustomer, authResponse.getData().getEmail());
                        SharedPreferanse.write(SharedPreferanse.EmailCustomer, authResponse.getData().getName());
                        SharedPreferanse.write(SharedPreferanse.IMAGECustomer, authResponse.getData().getPhoto());
                        SharedPreferanse.write(SharedPreferanse.MOBILECustomer, authResponse.getData().getPhone());
                        SharedPreferanse.write(SharedPreferanse.active, authResponse.getData().getActive());
                        SharedPreferanse.write(SharedPreferanse.TOKEN, "Bearer "+authResponse.getData().getToken());
                        LoadFragment();

                    } else {
                        Functions.getInstanse().hideDialog();
                        Functions.getInstanse().diaLog(getActivity(), "فشلت عملية تسجيل الدخول", authResponse.getMessage(), "موافق");
                        Log.e("sdsdsdsd", "1111");
                        Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();

                    }

                }
            });
        }

        else {

            Functions.getInstanse().showDialog(getActivity(), "Please Waite");
            Log.e("ex1", "3");
            addDataServiceProvider();
            registerViewModel.authResponseMutableLiveDataRegisterProvider.observe(getActivity(), new LiveDataModel.Observer<AuthResponseProvider>() {
                @Override
                public void onChanged(AuthResponseProvider authResponse) {
                    Log.e("ex1", "2");

                    if (authResponse.isStatus()) {
                        Functions.getInstanse().hideDialog();
                        Log.e("ex1", "00");
                        Toast.makeText(getActivity(), "Done", Toast.LENGTH_SHORT).show();
                        SharedPreferanse.write(SharedPreferanse.IDProvider, authResponse.getData().getId() + "");
                        SharedPreferanse.write(SharedPreferanse.USERNAMEProvider, authResponse.getData().getEmail());
                        SharedPreferanse.write(SharedPreferanse.EmailProvider, authResponse.getData().getName());
                        SharedPreferanse.write(SharedPreferanse.IMAGEProvider, authResponse.getData().getPhoto());
                        SharedPreferanse.write(SharedPreferanse.MOBILEProvider, authResponse.getData().getPhone());
                        SharedPreferanse.write(SharedPreferanse.active, authResponse.getData().getActive());
                        SharedPreferanse.write(SharedPreferanse.WorkId, authResponse.getData().getActive());
                        SharedPreferanse.write(SharedPreferanse.TOKEN, "Bearer "+authResponse.getData().getToken());
                        LoadFragmentProvider();

                    } else {
                        Functions.getInstanse().hideDialog();

                        Functions.getInstanse().diaLog(getActivity(), "فشلت عملية تسجيل الدخول", authResponse.getMessage(), "موافق");
                        Log.e("ex1", "1111");
                        Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();

                    }

                }
            });

        }
    }


    public void addDataCustomer() {

        String name = fragmentRegisterBinding.editName1.getText().toString();
        String email = fragmentRegisterBinding.editEmail1.getText().toString();
        String pass = fragmentRegisterBinding.editPassword1.getText().toString();
        String phone = fragmentRegisterBinding.editPhone1.getText().toString();

        registerViewModel.RegisterFunctionServiceUser(name, email, pass, phone);
    }

    public void addDataServiceProvider() {
        String name = fragmentRegisterBinding.editName1.getText().toString();
        String email = fragmentRegisterBinding.editEmail1.getText().toString();
        String pass = fragmentRegisterBinding.editPassword1.getText().toString();
        String phone = fragmentRegisterBinding.editPhone1.getText().toString();
        int work_id = fragmentRegisterBinding.servesSpinner.getSelectedItemPosition() + 1;
        registerViewModel.RegisterFunctionServiceProvider(name, email, pass, phone, work_id);

    }
}