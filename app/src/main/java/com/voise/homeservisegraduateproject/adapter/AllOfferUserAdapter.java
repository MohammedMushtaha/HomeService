package com.voise.homeservisegraduateproject.adapter;


import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.bojo.DataOfferResponse;
import com.voise.homeservisegraduateproject.interfaces.ItemClickLisener;
import com.voise.homeservisegraduateproject.ui.uiCustomerUser.order.AcceptOfferToUser;

import java.util.ArrayList;
import java.util.List;


public class AllOfferUserAdapter extends RecyclerView.Adapter<AllOfferUserAdapter.PostViewHolder> {
    private List<DataOfferResponse> dataWorks = new ArrayList<>();
     Activity activity;

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_useroffer, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        final DataOfferResponse movie = dataWorks.get(position);

        holder.name.setText(movie.getName());
        holder.date.setText(movie.getCreatedAt());

//        Picasso.with(activity).load(movie.getImage()).into(holder.image_item);

//        Picasso.with(activity)
//                .load(dataWorks.get(position).getPhoto())
//                .centerCrop()
//                .resize(200, 200)
//                .placeholder(R.drawable.as).into(holder.image_avatar);

        holder.setItemClickListener(new ItemClickLisener() {
            @Override
            public void onClick(View view, int Position, boolean isLongClick) {


                Intent i = new Intent(activity, AcceptOfferToUser.class);
                i.putExtra("data3", movie);
                activity.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataWorks.size();
    }

    public void setList(Activity activity, List<DataOfferResponse> moviesList) {
        this.dataWorks = moviesList;
        this.activity = activity;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {
        private TextView name,date;
        private ImageView image_avatar;
        private ItemClickLisener itemClickLisener;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            image_avatar = itemView.findViewById(R.id.image_avatar);
            name = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.date);
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

