package com.voise.homeservisegraduateproject.uiOfServiceProvider.ui.home_provider.DetailsOrderProvider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.squareup.picasso.Picasso;
import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.SharedPreferanse.SharedPreferanse;
import com.voise.homeservisegraduateproject.bojo.AcceptUserResponse;
import com.voise.homeservisegraduateproject.bojo.CreateOfferResponse;
import com.voise.homeservisegraduateproject.bojo.DataHomeProviderResponse;
import com.voise.homeservisegraduateproject.bojo.DataOfferResponse;
import com.voise.homeservisegraduateproject.data.LiveDataModel;
import com.voise.homeservisegraduateproject.ui.uiCustomerUser.moreApp.MoreFragment;
import com.voise.homeservisegraduateproject.ui.uiCustomerUser.order.AcceptOfferToUser;
import com.voise.homeservisegraduateproject.ui.uiCustomerUser.order.AcceptOfferToUserViewModel;
import com.voise.homeservisegraduateproject.uiOfServiceProvider.ui.home_provider.MapsProviderFragment;
import com.voise.homeservisegraduateproject.utils.Functions;

public class DetailsOrderServiceProvider extends AppCompatActivity {
    DataHomeProviderResponse dataHomeProviderResponse;
    private BottomSheetBehavior bottomSheetBehavior;
DetailsViewModel detailsViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailsViewModel = ViewModelProviders.of(this).get(DetailsViewModel.class);

        setContentView(R.layout.activity_details_order_service_provider);

        dataHomeProviderResponse = (DataHomeProviderResponse) getIntent().getSerializableExtra("data5");
        TextView textdet = findViewById(R.id.text);
        Button social = findViewById(R.id.social);
        LinearLayout linear_map = findViewById(R.id.linear_map);
        ImageView image_view_pager_stadiums_details = findViewById(R.id.image_view_pager_stadiums_details);
        View buttomSheet1 = findViewById(R.id.buttomSheet1);
        bottomSheetBehavior = BottomSheetBehavior.from(buttomSheet1);
        textdet.setText(dataHomeProviderResponse.getDetailsAddress());

        try {
            Picasso.with(DetailsOrderServiceProvider.this)
                    .load(dataHomeProviderResponse.getPhotoOrderHome().getPhoto())
                    .placeholder(R.drawable.shape_setting_image_user)
                    .error(R.drawable.shape_setting_image_user)
                    .into(image_view_pager_stadiums_details);

        } catch (Exception e) {

        }

        linear_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, new MapsProviderFragment(getApplication())).commit();

            }
        });

        social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.getInstanse().showDialog(DetailsOrderServiceProvider.this, "Please Waite");
                Log.e("ex1", "3");
                addDataCustomer();
                detailsViewModel.authResponseMutableLiveDataCreateOffer.observe(DetailsOrderServiceProvider.this, new LiveDataModel.Observer<CreateOfferResponse>() {
                    @Override
                    public void onChanged(CreateOfferResponse authResponse) {
                        Log.e("ex1", "2");

                        if (authResponse.getSuccess()) {
                            Functions.getInstanse().hideDialog();
                            Log.e("ex1", "00");
                            Toast.makeText(DetailsOrderServiceProvider.this, "تم اضافة الطلب", Toast.LENGTH_SHORT).show();
//                            LoadFragment();

                        } else {
                            Functions.getInstanse().hideDialog();

                            Functions.getInstanse().diaLog(DetailsOrderServiceProvider.this, "فشلت عملية ارسال الطلب", authResponse.getMessage(), "موافق");
                            Log.e("ex1", "1111");
//                            Toast.makeText(AcceptOfferToUser.this, "Error", Toast.LENGTH_SHORT).show();

                        }

                    }
                });
            }
        });

    }
    public void addDataCustomer() {

        detailsViewModel.createOfferRequest( dataHomeProviderResponse.getId());

    }
}