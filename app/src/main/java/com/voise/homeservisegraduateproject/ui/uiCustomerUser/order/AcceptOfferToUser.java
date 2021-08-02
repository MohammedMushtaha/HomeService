package com.voise.homeservisegraduateproject.ui.uiCustomerUser.order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
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

        activityAcceptOfferToUserBinding.NameOfUser.setText(dataOfferResponse.getName());
        activityAcceptOfferToUserBinding.CityOfUser.setText(dataOfferResponse.getEmail());
        activityAcceptOfferToUserBinding.number.setText(dataOfferResponse.getPhone());

  activityAcceptOfferToUserBinding.calluser.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          onClickWhatsApp(AcceptOfferToUser.this,dataOfferResponse.getPhone());
      }
  });


        try {
            Picasso.with(AcceptOfferToUser.this)
                    .load(dataOfferResponse.getPhoto())
                    .centerCrop()
                    .resize(200, 200)
                    .placeholder(R.drawable.as).into(activityAcceptOfferToUserBinding.imageUser);
        } catch (Exception e) {

        }

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


    public static void onClickWhatsApp(Context context, String number) {

        try {
            number = number.replace(" ", "").replace("+", "");
            if (number.charAt(0) == '0') {
                number = number.substring(2);
            }
            Intent waIntent = new Intent("android.intent.action.MAIN");
            waIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
            waIntent.setPackage("com.whatsapp");
            waIntent.putExtra("jid", PhoneNumberUtils.stripSeparators(number) + "@s.whatsapp.net");
            context.startActivity(Intent.createChooser(waIntent, "contact"));
        } catch (Exception e) {
            Toast.makeText(context, "WhatsApp not Installed", Toast.LENGTH_SHORT)
                    .show();
        }

    }
}