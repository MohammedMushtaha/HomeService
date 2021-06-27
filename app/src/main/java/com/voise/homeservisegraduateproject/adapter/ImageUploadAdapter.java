package com.voise.homeservisegraduateproject.adapter;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.interfaces.ItemClickLisener;

import java.util.ArrayList;

public class ImageUploadAdapter  extends RecyclerView.Adapter<ImageUploadAdapter.PostViewHolder> {
    private ArrayList<Uri> dataWorks = new ArrayList<>();
    Activity activity;

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_imageupload, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        final Uri movie = dataWorks.get(position);


//        Picasso.with(activity).load(movie.getImage()).into(holder.image_item);

        Picasso.with(activity)
                .load(dataWorks.get(position))
                .centerCrop()
                .resize(200, 200)
                .placeholder(R.drawable.ic_electricity_logo).into(holder.image_item);


    }

    @Override
    public int getItemCount() {
        return dataWorks.size();
    }

    public void setList(Activity activity, ArrayList<Uri> moviesList) {
        this.dataWorks = moviesList;
        this.activity = activity;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder  {
        private TextView text_item;
        private ImageView image_item;
        private ItemClickLisener itemClickLisener;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            image_item = itemView.findViewById(R.id.image_item);
            text_item = itemView.findViewById(R.id.text_item);
//            itemView.setOnClickListener(this);
//            itemView.setOnLongClickListener(this);
        }

        public void setItemClickListener(ItemClickLisener itemClickLicener) {
            this.itemClickLisener = itemClickLicener;
        }

//        @Override
//        public void onClick(View v) {
//            itemClickLisener.onClick(v, getAdapterPosition(), false);
//
//        }
//
//        @Override
//        public boolean onLongClick(View v) {
//            itemClickLisener.onClick(v, getAdapterPosition(), true);
//            return true;
//        }
    }
}

