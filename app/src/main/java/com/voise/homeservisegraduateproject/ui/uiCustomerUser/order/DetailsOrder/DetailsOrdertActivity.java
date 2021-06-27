package com.voise.homeservisegraduateproject.ui.uiCustomerUser.order.DetailsOrder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.SharedPreferanse.SharedPreferanse;
import com.voise.homeservisegraduateproject.adapter.AdapterSliderDetails;
import com.voise.homeservisegraduateproject.adapter.AllOfferUserAdapter;
import com.voise.homeservisegraduateproject.bojo.DataOfferResponse;
import com.voise.homeservisegraduateproject.bojo.DataPendingOrderResponse;
import com.voise.homeservisegraduateproject.bojo.DataUnCompletedResponse;
import com.voise.homeservisegraduateproject.databinding.ActivityDetailsOrdertBinding;

import java.util.List;

public class DetailsOrdertActivity extends AppCompatActivity {
    DataPendingOrderResponse dataPendingOrderResponse;
    DataUnCompletedResponse dataUnCompletedResponse;
    DetailsOrderViewModel detailsOrderViewModel;
    ActivityDetailsOrdertBinding detailsOrdertBinding;
    AdapterSliderDetails lettersUserAnswer;
    AllOfferUserAdapter allOfferUserAdapter;
     LinearLayoutManager horizontalLayoutManagaer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_details_ordert);

        detailsOrderViewModel = ViewModelProviders.of(this).get(DetailsOrderViewModel.class);
        detailsOrdertBinding = DataBindingUtil.setContentView(this, R.layout.activity_details_ordert);
if (SharedPreferanse.read(SharedPreferanse.Type_Complete_Pending_UnComplete,"1").equals("1")){
    dataUnCompletedResponse = (DataUnCompletedResponse) getIntent().getSerializableExtra("data1");
    detailsOrdertBinding.recyclerViewListUser.setVisibility(View.GONE);
    detailsOrdertBinding.dataUserAccept.setVisibility(View.VISIBLE);
    detailsOrdertBinding.title.setText("Craft Man"+dataUnCompletedResponse.getWork().getName());
    detailsOrdertBinding.idHash.setText("# "+dataUnCompletedResponse.getId());
    detailsOrdertBinding.date.setText( dataUnCompletedResponse.getCreatedAt());
    detailsOrdertBinding.details.setText( dataUnCompletedResponse.getDetails());
    detailsOrdertBinding.textPhone.setText( dataUnCompletedResponse.getPhone());
}else {
    detailsOrdertBinding.recyclerViewListUser.setVisibility(View.VISIBLE);
    detailsOrdertBinding.dataUserAccept.setVisibility(View.GONE);
    dataPendingOrderResponse = (DataPendingOrderResponse) getIntent().getSerializableExtra("data1");
    detailsOrdertBinding.title.setText("Craft Man"+dataPendingOrderResponse.getWork().getName());
    detailsOrdertBinding.idHash.setText("# "+dataPendingOrderResponse.getId());
    detailsOrdertBinding.date.setText( dataPendingOrderResponse.getCreatedAt());
    detailsOrdertBinding.details.setText( dataPendingOrderResponse.getDetails());
    getAllWorkData();

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