package com.voise.homeservisegraduateproject.ui.uiCustomerUser.order;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.adapter.OrderCompletedAdapter;
import com.voise.homeservisegraduateproject.bojo.CompletedOrder;
import com.voise.homeservisegraduateproject.bojo.DataPendingOrderResponse;
import com.voise.homeservisegraduateproject.databinding.FragmentPendingOrderBinding;

import java.util.ArrayList;
import java.util.List;


public class PendingOrderFragment extends Fragment {


    public PendingOrderFragment() {
        // Required empty public constructor
    }


    PendingOrderViewModel pendingOrderViewModel;
    FragmentPendingOrderBinding fragmentPendingOrderBinding;

    View root;
    OrderCompletedAdapter orderCompletedAdapter;
    private List<CompletedOrder> completedOrders = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        root = inflater.inflate(R.layout.fragment_pending_order, container, false);

        pendingOrderViewModel = ViewModelProviders.of(this).get(PendingOrderViewModel.class);
        fragmentPendingOrderBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_pending_order, container, false);
        root = fragmentPendingOrderBinding.getRoot();
        fragmentPendingOrderBinding.setLifecycleOwner(getActivity());


        initCurrent();
        getAllWorkData();
        return root;
    }

    private void initCurrent() {

    }

    public void getAllWorkData() {
        pendingOrderViewModel.getAllWorkData();
        orderCompletedAdapter = new OrderCompletedAdapter();
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        fragmentPendingOrderBinding.recyclerPending.setLayoutManager(mLayoutManager);
        fragmentPendingOrderBinding.recyclerPending.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        fragmentPendingOrderBinding.recyclerPending.setItemAnimator(new DefaultItemAnimator());
        fragmentPendingOrderBinding.recyclerPending.setAdapter(orderCompletedAdapter);
        pendingOrderViewModel.listMutableLiveDataِAllWork.observe(getActivity(), new Observer<List<DataPendingOrderResponse>>() {
            @Override
            public void onChanged(List<DataPendingOrderResponse> dataWorks) {

                orderCompletedAdapter.setList(getActivity(), dataWorks);


            }
        });
    }

}