package com.voise.homeservisegraduateproject.adapter;


import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.SharedPreferanse.SharedPreferanse;
import com.voise.homeservisegraduateproject.bojo.DataHomeProviderResponse;
import com.voise.homeservisegraduateproject.bojo.DataWork;
import com.voise.homeservisegraduateproject.interfaces.ItemClickLisener;
import com.voise.homeservisegraduateproject.ui.uiCustomerUser.home.AddOrderProblemActivity;

import java.util.ArrayList;
import java.util.List;


public class HomeProviderAdapter extends RecyclerView.Adapter<HomeProviderAdapter.PostViewHolder> {
    private List<DataHomeProviderResponse> dataWorks = new ArrayList<>();
    Activity activity;

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_servisprovider, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        final DataHomeProviderResponse movie = dataWorks.get(position);

        holder.order_date.setText(movie.getCreatedAt());
        holder.name.setText(movie.getUser().getName());
        holder.orderid.setId(movie.getId());
        holder.serviceType.setText(movie.getWork().getName());

//        Picasso.with(activity).load(movie.getImage()).into(holder.image_item);
   try {
       Picasso.with(activity)
               .load(dataWorks.get(position).getPhotoOrderHome().getPhoto())
               .centerCrop()
               .resize(200, 200)
               .placeholder(R.drawable.ic_electricity_logo).into(holder.order_image);
   }catch (Exception e){
       Log.e("","");
   }



        holder.setItemClickListener(new ItemClickLisener() {
            @Override
            public void onClick(View view, int Position, boolean isLongClick) {


            }
        });
    }

    @Override
    public int getItemCount() {
        return dataWorks.size();
    }

    public void setList(Activity activity, List<DataHomeProviderResponse> moviesList) {
        this.dataWorks = moviesList;
        this.activity = activity;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {
        private TextView order_date, serviceType, orderid, name;
        private ImageView order_image;
        private ItemClickLisener itemClickLisener;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            order_date = itemView.findViewById(R.id.order_date);
            orderid = itemView.findViewById(R.id.orderid);
            name = itemView.findViewById(R.id.name);
//            date_createAt = itemView.findViewById(R.id.rating);
            serviceType = itemView.findViewById(R.id.serviceType);
            order_image = itemView.findViewById(R.id.order_image);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setItemClickListener(ItemClickLisener itemClickLicener) {
            this.itemClickLisener = itemClickLicener;
        }

        @Override
        public void onClick(View v) {
            itemClickLisener.onClick(v, getAdapterPosition(), false);

        }

        @Override
        public boolean onLongClick(View v) {
            itemClickLisener.onClick(v, getAdapterPosition(), true);
            return true;
        }
    }
}

