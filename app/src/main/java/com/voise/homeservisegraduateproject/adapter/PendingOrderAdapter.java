package com.voise.homeservisegraduateproject.adapter;


import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.SharedPreferanse.SharedPreferanse;
import com.voise.homeservisegraduateproject.bojo.DataPendingOrderResponse;
import com.voise.homeservisegraduateproject.interfaces.ItemClickLisener;
import com.voise.homeservisegraduateproject.ui.uiCustomerUser.order.DetailsOrder.DetailsOrdertActivity;

import java.util.ArrayList;
import java.util.List;


public class PendingOrderAdapter extends RecyclerView.Adapter<PendingOrderAdapter.MyViewHolder> {

    private List<DataPendingOrderResponse> category_modelList= new ArrayList<>();
    private Activity activity;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {
        private TextView order_number, order_cat, order_date;
        private ItemClickLisener itemClickLisener;

        public MyViewHolder(View view) {
            super(view);
            order_number = view.findViewById(R.id.order_number);
            order_cat = view.findViewById(R.id.order_cat);
            order_date = view.findViewById(R.id.order_date);
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);

        }

        public void setItemClickListener(ItemClickLisener itemClickLicener) {
            this.itemClickLisener = itemClickLicener;
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickLisener.onClick(v, getAdapterPosition(), true);

            return true;
        }

        @Override
        public void onClick(View v) {
            itemClickLisener.onClick(v, getAdapterPosition(), false);

        }

    }
    public void setList(Activity activity, List<DataPendingOrderResponse> category_modelList) {
        this.category_modelList = category_modelList;
        this.activity = activity;
        notifyDataSetChanged();
    }
//////////////////AdapterIntent

//    public OrderCompletedAdapter(Activity activity, List<DataPendingOrderResponse> moviesList, ItemClickLisener lisener) {
//        this.category_modelList = moviesList;
//        this.activity = activity;
//        this.itemClickLisener = lisener;
//    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_completed, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final DataPendingOrderResponse category_model = category_modelList.get(position);
        holder.order_number.setText("# "+category_model.getId()+"");
        holder.order_date.setText(category_model.getCreatedAt());
        holder.order_cat.setText(category_model.getWork().getName());
//////////////////AdapterIntent
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                itemClickLisener.onClick(v, holder.getAdapterPosition(), false);
//            }
//        });
        holder.setItemClickListener(new ItemClickLisener() {
            @Override
            public void onClick(View view, int Position, boolean isLongClick) {
                SharedPreferanse.write2(SharedPreferanse.Position,position);

                SharedPreferanse.write(SharedPreferanse.Type_Complete_Pending_UnComplete,"2");
                Intent i =new Intent(activity, DetailsOrdertActivity.class);
                i.putExtra("data1", category_model);
                activity.startActivity(i);

            }
        });

    }

    //    public  void filterList(ArrayList<HomeCategory> filterdList){
//        category_modelList=filterdList;
//        notifyDataSetChanged();
//    }
    @Override
    public int getItemCount() {
        return category_modelList.size();
    }
}