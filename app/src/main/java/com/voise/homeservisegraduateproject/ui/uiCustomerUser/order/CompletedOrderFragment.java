package com.voise.homeservisegraduateproject.ui.uiCustomerUser.order;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.adapter.CompletedOrderAdapter;
import com.voise.homeservisegraduateproject.adapter.PendingOrderAdapter;
import com.voise.homeservisegraduateproject.adapter.UnderwayOrderAdapter;
import com.voise.homeservisegraduateproject.bojo.CompletedOrder;
import com.voise.homeservisegraduateproject.bojo.DataCompletedResponse;
import com.voise.homeservisegraduateproject.bojo.DataPendingOrderResponse;
import com.voise.homeservisegraduateproject.databinding.FragmentCompletedOrderBinding;

import java.util.ArrayList;
import java.util.List;


public class CompletedOrderFragment extends Fragment {


    public CompletedOrderFragment() {
        // Required empty public constructor
    }
    View root;
     CompletedOrderViewModel completedOrderViewModel;
    CompletedOrderAdapter completedOrderAdapter;
    FragmentCompletedOrderBinding fragmentCompletedOrderBinding;
     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//          root= inflater.inflate(R.layout.fragment_completed_order, container, false);

         completedOrderViewModel = ViewModelProviders.of(this).get(CompletedOrderViewModel.class);
         fragmentCompletedOrderBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_completed_order, container, false);
         root = fragmentCompletedOrderBinding.getRoot();
         fragmentCompletedOrderBinding.setLifecycleOwner(getActivity());


        getAllCompletedOrderData();

        return root;
    }

    public void getAllCompletedOrderData() {
        completedOrderViewModel.getAllCompletedData();
        completedOrderAdapter = new CompletedOrderAdapter();
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        fragmentCompletedOrderBinding.recyclerCompletedOrder.setLayoutManager(mLayoutManager);
        fragmentCompletedOrderBinding.recyclerCompletedOrder.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        fragmentCompletedOrderBinding.recyclerCompletedOrder.setItemAnimator(new DefaultItemAnimator());
        fragmentCompletedOrderBinding.recyclerCompletedOrder.setAdapter(completedOrderAdapter);
        completedOrderViewModel.listMutableLiveDataِAllWork.observe(getActivity(), new Observer<List<DataCompletedResponse>>() {
            @Override
            public void onChanged(List<DataCompletedResponse> dataWorks) {

                completedOrderAdapter.setList(getActivity(), dataWorks);


            }
        });
    }
}