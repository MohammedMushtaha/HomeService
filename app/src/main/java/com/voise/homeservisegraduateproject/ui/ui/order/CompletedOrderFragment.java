package com.voise.homeservisegraduateproject.ui.ui.order;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.adapter.OrderCompletedAdapter;
import com.voise.homeservisegraduateproject.bojo.CompletedOrder;

import java.util.ArrayList;
import java.util.List;


public class CompletedOrderFragment extends Fragment {


    public CompletedOrderFragment() {
        // Required empty public constructor
    }
    View root;
    RecyclerView recyclerCompleted;
    OrderCompletedAdapter orderCompletedAdapter;
    private List<CompletedOrder> completedOrders = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
          root= inflater.inflate(R.layout.fragment_completed_order, container, false);
        initCurrent();

        return root;
    }

    private void initCurrent() {
        recyclerCompleted = root.findViewById(R.id.recyclerCurrent);
        completedOrders.add(new CompletedOrder(1, "28 Nov 2019","Order #52001","Carpenter"));
        completedOrders.add(new CompletedOrder(1, "28 Nov 2019","Order #52001","Carpenter"));
        completedOrders.add(new CompletedOrder(1, "28 Nov 2019","Order #52001","Carpenter"));
        completedOrders.add(new CompletedOrder(1, "28 Nov 2019","Order #52001","Carpenter"));
        completedOrders.add(new CompletedOrder(1, "28 Nov 2019","Order #52001","Carpenter"));
        completedOrders.add(new CompletedOrder(1, "28 Nov 2019","Order #52001","Carpenter"));
        completedOrders.add(new CompletedOrder(1, "28 Nov 2019","Order #52001","Carpenter"));
        completedOrders.add(new CompletedOrder(1, "28 Nov 2019","Order #52001","Carpenter"));


        orderCompletedAdapter = new OrderCompletedAdapter(getActivity(), completedOrders);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerCompleted.setLayoutManager(mLayoutManager);
        recyclerCompleted.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerCompleted.setItemAnimator(new DefaultItemAnimator());
        recyclerCompleted.setAdapter(orderCompletedAdapter);
    }

}