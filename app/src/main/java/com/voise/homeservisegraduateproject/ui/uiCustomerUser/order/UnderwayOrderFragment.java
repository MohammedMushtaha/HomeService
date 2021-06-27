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
import com.voise.homeservisegraduateproject.adapter.UnderwayOrderAdapter;
import com.voise.homeservisegraduateproject.bojo.DataUnCompletedResponse;
import com.voise.homeservisegraduateproject.databinding.FragmentUnderwayOrderBinding;

import java.util.List;

public class UnderwayOrderFragment extends Fragment {

    public UnderwayOrderFragment() {
    }

    View root;
     UnderwayOrderAdapter underwayOrderAdapter;

    UnderwayOrderViewModel underwayOrderViewModel;
    FragmentUnderwayOrderBinding fragmentUnderwayOrderBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//          root = inflater.inflate(R.layout.fragment_underway_order, container, false);

        underwayOrderViewModel = ViewModelProviders.of(this).get(UnderwayOrderViewModel.class);
        fragmentUnderwayOrderBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_underway_order, container, false);
        root = fragmentUnderwayOrderBinding.getRoot();
        fragmentUnderwayOrderBinding.setLifecycleOwner(getActivity());

        getAllWorkData();
           return root;
    }
//
    public void getAllWorkData() {
        underwayOrderViewModel.getAllWorkData();
        underwayOrderAdapter = new UnderwayOrderAdapter();
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        fragmentUnderwayOrderBinding.recyclerUnDerway.setLayoutManager(mLayoutManager);
        fragmentUnderwayOrderBinding.recyclerUnDerway.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        fragmentUnderwayOrderBinding.recyclerUnDerway.setItemAnimator(new DefaultItemAnimator());
        fragmentUnderwayOrderBinding.recyclerUnDerway.setAdapter(underwayOrderAdapter);
        underwayOrderViewModel.listMutableLiveDataِAllWork.observe(getActivity(), new Observer<List<DataUnCompletedResponse>>() {
            @Override
            public void onChanged(List<DataUnCompletedResponse> dataWorks) {

                underwayOrderAdapter.setList(getActivity(), dataWorks);


            }
        });
    }










//    private void initCurrent() {
//            recyclerCompleted = root.findViewById(R.id.recyclerUnDerway);
//            completedOrders.add(new CompletedOrder(1, "28 Nov 2019","Order #52001","Carpenter"));
//            completedOrders.add(new CompletedOrder(1, "28 Nov 2019","Order #52001","Carpenter"));
//            completedOrders.add(new CompletedOrder(1, "28 Nov 2019","Order #52001","Carpenter"));
//            completedOrders.add(new CompletedOrder(1, "28 Nov 2019","Order #52001","Carpenter"));
//            completedOrders.add(new CompletedOrder(1, "28 Nov 2019","Order #52001","Carpenter"));
//            completedOrders.add(new CompletedOrder(1, "28 Nov 2019","Order #52001","Carpenter"));
//            completedOrders.add(new CompletedOrder(1, "28 Nov 2019","Order #52001","Carpenter"));
//            completedOrders.add(new CompletedOrder(1, "28 Nov 2019","Order #52001","Carpenter"));
//
//
////            orderCompletedAdapter = new OrderCompletedAdapter(getActivity(), completedOrders
////                    , new ItemClickLisener() {
////                @Override
////                public void onClick(View view, int Position, boolean isLongClick) {
////                    Toast.makeText(getContext(), "12", Toast.LENGTH_SHORT).show();
////                }
////            });
//            LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
//            recyclerCompleted.setLayoutManager(mLayoutManager);
//            recyclerCompleted.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
//            recyclerCompleted.setItemAnimator(new DefaultItemAnimator());
//            recyclerCompleted.setAdapter(orderCompletedAdapter);
//        }
}