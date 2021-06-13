package com.voise.homeservisegraduateproject.adapter;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.bojo.CompletedOrder;
import com.voise.homeservisegraduateproject.interfaces.ItemClickLisener;

import java.util.List;


public class OrderCompletedAdapter extends RecyclerView.Adapter<OrderCompletedAdapter.MyViewHolder> {

    private List<CompletedOrder> category_modelList;
    private Activity activity;
    private ItemClickLisener itemClickLisener;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {
        private TextView order_number,order_cat,order_date;
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

    public OrderCompletedAdapter(Activity activity, List<CompletedOrder> moviesList) {
        this.category_modelList = moviesList;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_completed, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final CompletedOrder category_model = category_modelList.get(position);
        holder.order_number.setText(category_model.getOrder_name());
        holder.order_date.setText(category_model.getOrder_date());
        holder.order_cat.setText(category_model.getOrder_cat());


        holder.setItemClickListener(new ItemClickLisener() {
            @Override
            public void onClick(View view, int Position, boolean isLongClick) {

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