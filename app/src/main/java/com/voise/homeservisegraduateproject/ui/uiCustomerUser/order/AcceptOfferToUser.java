package com.voise.homeservisegraduateproject.ui.uiCustomerUser.order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.bojo.AcceptUserResponse;
import com.voise.homeservisegraduateproject.bojo.DataOfferResponse;
import com.voise.homeservisegraduateproject.data.LiveDataModel;
import com.voise.homeservisegraduateproject.databinding.ActivityAcceptOfferToUserBinding;
import com.voise.homeservisegraduateproject.utils.Functions;

public class AcceptOfferToUser extends AppCompatActivity {
    AcceptOfferToUserViewModel acceptOfferToUserViewModel;
    ActivityAcceptOfferToUserBinding activityAcceptOfferToUserBinding;
    DataOfferResponse dataOfferResponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_accept_offer_to_user);

        acceptOfferToUserViewModel = ViewModelProviders.of(this).get(AcceptOfferToUserViewModel.class);
        activityAcceptOfferToUserBinding = DataBindingUtil.setContentView(this, R.layout.activity_accept_offer_to_user);
        dataOfferResponse = (DataOfferResponse) getIntent().getSerializableExtra("data3");

         activityAcceptOfferToUserBinding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.getInstanse().showDialog(AcceptOfferToUser.this, "Please Waite");
                Log.e("ex1", "3");
                addDataCustomer();
                acceptOfferToUserViewModel.authResponseMutableLiveDataProvider.observe(AcceptOfferToUser.this, new LiveDataModel.Observer<AcceptUserResponse>() {
                    @Override
                    public void onChanged(AcceptUserResponse authResponse) {
                        Log.e("ex1", "2");

                        if (authResponse.getSuccess()) {
                            Functions.getInstanse().hideDialog();
                            Log.e("ex1", "00");
                            Toast.makeText(AcceptOfferToUser.this, "تم اضافة الطلب", Toast.LENGTH_SHORT).show();
//                            LoadFragment();

                        } else {
                            Functions.getInstanse().hideDialog();

                            Functions.getInstanse().diaLog(AcceptOfferToUser.this, "فشلت عملية تسجيل الدخول", authResponse.getMessage(), "موافق");
                            Log.e("ex1", "1111");
                            Toast.makeText(AcceptOfferToUser.this, "Error", Toast.LENGTH_SHORT).show();

                        }

                    }
                });
            }
        });


    }
    public void addDataCustomer() {

        acceptOfferToUserViewModel.loginFunctionServiceProvider( dataOfferResponse.getPivot().getDeliveryId(), dataOfferResponse.getPivot().getOrderId());

    }

}