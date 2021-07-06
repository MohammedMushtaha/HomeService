package com.voise.homeservisegraduateproject.ui.uiCustomerUser.order.DetailsOrder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.SharedPreferanse.SharedPreferanse;
import com.voise.homeservisegraduateproject.adapter.AdapterSliderDetails;
import com.voise.homeservisegraduateproject.adapter.AllOfferUserAdapter;
import com.voise.homeservisegraduateproject.bojo.DataCompletedResponse;
import com.voise.homeservisegraduateproject.bojo.DataOfferResponse;
import com.voise.homeservisegraduateproject.bojo.DataPendingOrderResponse;
import com.voise.homeservisegraduateproject.bojo.DataUnCompletedResponse;
import com.voise.homeservisegraduateproject.bojo.PhotoOrderResponse;
import com.voise.homeservisegraduateproject.databinding.ActivityDetailsOrdertBinding;

import java.util.ArrayList;
import java.util.List;

public class DetailsOrdertActivity extends AppCompatActivity {
    DataPendingOrderResponse dataPendingOrderResponse;
    DataUnCompletedResponse dataUnCompletedResponse;
    DataCompletedResponse dataCompletedResponse;
    DetailsOrderViewModel detailsOrderViewModel;
    ActivityDetailsOrdertBinding detailsOrdertBinding;
    AdapterSliderDetails adapterSliderDetails;
    AllOfferUserAdapter allOfferUserAdapter;
    LinearLayoutManager horizontalLayoutManagaer;
//    PhotoOrderResponse photoOrderResponse;

    private  List<PhotoOrderResponse> photoOrderResponse = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_details_ordert);

        detailsOrderViewModel = ViewModelProviders.of(this).get(DetailsOrderViewModel.class);
        detailsOrdertBinding = DataBindingUtil.setContentView(this, R.layout.activity_details_ordert);

        int Position=Integer.parseInt(String.valueOf(SharedPreferanse.read2(SharedPreferanse.Position,1)));
//        Toast.makeText(this, "d"+SharedPreferanse.read2(SharedPreferanse.Position,1), Toast.LENGTH_SHORT).show();
        if (SharedPreferanse.read(SharedPreferanse.Type_Complete_Pending_UnComplete, "1").equals("1")) {
            dataUnCompletedResponse = (DataUnCompletedResponse) getIntent().getSerializableExtra("data1");
            detailsOrdertBinding.recyclerViewListUser.setVisibility(View.GONE);
            detailsOrdertBinding.dataUserAccept.setVisibility(View.VISIBLE);
            detailsOrdertBinding.title.setText("Craft Man" + dataUnCompletedResponse.getWork().getName());
            detailsOrdertBinding.idHash.setText("# " + dataUnCompletedResponse.getId());
            detailsOrdertBinding.date.setText(dataUnCompletedResponse.getCreatedAt());
            detailsOrdertBinding.details.setText(dataUnCompletedResponse.getDetails());
            detailsOrdertBinding.textPhone.setText(dataUnCompletedResponse.getPhone());
            detailsOrdertBinding.recommended.setText("UnderWay");

//            Picasso.with(DetailsOrdertActivity.this)
//                    .load(dataUnCompletedResponse.getPhotoOrder().get(Position).getPhoto())
//                    .placeholder(R.drawable.shape_setting_image_user)
//                    .error(R.drawable.shape_setting_image_user)
//                    .into(detailsOrdertBinding.imageViewSlider);

//            photoOrderResponse.add(new PhotoOrderResponse());
//
//            adapterSliderDetails = new AdapterSliderDetails(DetailsOrdertActivity.this,dataUnCompletedResponse.getPhotoOrder());
//            GridLayoutManager gridLayoutManager = new GridLayoutManager(DetailsOrdertActivity.this, 1);
//            detailsOrdertBinding.imageViewSlider.setLayoutManager(gridLayoutManager);
//            detailsOrdertBinding.imageViewSlider.addItemDecoration(new DividerItemDecoration(DetailsOrdertActivity.this, 0));
//            detailsOrdertBinding.imageViewSlider.setItemAnimator(new DefaultItemAnimator());
//            detailsOrdertBinding.imageViewSlider.setAdapter(adapterSliderDetails);

            adapterSliderDetails = new AdapterSliderDetails(DetailsOrdertActivity.this, dataUnCompletedResponse.getPhotoOrder());

            detailsOrdertBinding.imageViewSlider.setAdapter(adapterSliderDetails);
            detailsOrdertBinding.indicatorTabLayoutStadiumsDetails.setupWithViewPager( detailsOrdertBinding.imageViewSlider);


        } else if (SharedPreferanse.read(SharedPreferanse.Type_Complete_Pending_UnComplete, "1").equals("2")) {
            detailsOrdertBinding.recyclerViewListUser.setVisibility(View.VISIBLE);
            detailsOrdertBinding.dataUserAccept.setVisibility(View.GONE);
            dataPendingOrderResponse = (DataPendingOrderResponse) getIntent().getSerializableExtra("data1");
            detailsOrdertBinding.title.setText("Craft Man" + dataPendingOrderResponse.getWork().getName());
            detailsOrdertBinding.idHash.setText("# " + dataPendingOrderResponse.getId());
            detailsOrdertBinding.recommended.setText("Pending");
            detailsOrdertBinding.date.setText(dataPendingOrderResponse.getCreatedAt());
            detailsOrdertBinding.details.setText(dataPendingOrderResponse.getDetails());


            adapterSliderDetails = new AdapterSliderDetails(DetailsOrdertActivity.this, dataPendingOrderResponse.getPhotoOrder());

            detailsOrdertBinding.imageViewSlider.setAdapter(adapterSliderDetails);
            detailsOrdertBinding.indicatorTabLayoutStadiumsDetails.setupWithViewPager( detailsOrdertBinding.imageViewSlider);



//            Picasso.with(DetailsOrdertActivity.this)
//                    .load(dataPendingOrderResponse.getPhotoOrder().get(Position).getPhoto())
//                    .placeholder(R.drawable.shape_setting_image_user)
//                    .error(R.drawable.shape_setting_image_user)
//                    .into(detailsOrdertBinding.imageViewSlider);

            getAllWorkData();

        } else {
            dataCompletedResponse = (DataCompletedResponse) getIntent().getSerializableExtra("data1");
            detailsOrdertBinding.recyclerViewListUser.setVisibility(View.GONE);
            detailsOrdertBinding.dataUserAccept.setVisibility(View.VISIBLE);
            detailsOrdertBinding.title.setText("Craft Man" + dataCompletedResponse.getWork().getName());
            detailsOrdertBinding.idHash.setText("# " + dataCompletedResponse.getId());
            detailsOrdertBinding.date.setText(dataCompletedResponse.getCreatedAt());
            detailsOrdertBinding.details.setText(dataCompletedResponse.getDetails());
            detailsOrdertBinding.textPhone.setText(dataCompletedResponse.getPhone());
            detailsOrdertBinding.btnFinishOrder.setText("Order Is Completed");
            detailsOrdertBinding.recommended.setText("Completed");

            adapterSliderDetails = new AdapterSliderDetails(DetailsOrdertActivity.this, dataCompletedResponse.getPhotoOrder());

            detailsOrdertBinding.imageViewSlider.setAdapter(adapterSliderDetails);
            detailsOrdertBinding.indicatorTabLayoutStadiumsDetails.setupWithViewPager( detailsOrdertBinding.imageViewSlider);
//            Picasso.with(DetailsOrdertActivity.this)
//                    .load(dataCompletedResponse.getPhotoOrder().get(Position).getPhoto())
//                    .placeholder(R.drawable.shape_setting_image_user)
//                    .error(R.drawable.shape_setting_image_user)
//                    .into(detailsOrdertBinding.imageViewSlider);
        }


    }

    public void getAllWorkData() {
        detailsOrderViewModel.getAllWorkData(dataPendingOrderResponse.getId());
        allOfferUserAdapter = new AllOfferUserAdapter();
        GridLayoutManager mLayoutManager = new GridLayoutManager(DetailsOrdertActivity.this, 3);
        detailsOrdertBinding.recyclerViewListUser.setLayoutManager(mLayoutManager);
        detailsOrdertBinding.recyclerViewListUser.setAdapter(allOfferUserAdapter);
        detailsOrderViewModel.listMutableLiveDataِAllWork.observe(DetailsOrdertActivity.this, new Observer<List<DataOfferResponse>>() {
            @Override
            public void onChanged(List<DataOfferResponse> dataWorks) {

                allOfferUserAdapter.setList(DetailsOrdertActivity.this, dataWorks);


            }
        });
    }

}