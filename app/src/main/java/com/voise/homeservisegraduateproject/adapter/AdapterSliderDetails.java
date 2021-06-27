package com.voise.homeservisegraduateproject.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.bojo.ImageModel_slider;

import java.util.ArrayList;

/**
 * Created by acer on 3/12/2018.
 */

public class AdapterSliderDetails extends RecyclerView.Adapter<AdapterSliderDetails.MyViewHolder> {

    //    private List<Modelslider> tasksList;
    private Activity activity;
    ArrayList<ImageModel_slider> tasksList = new ArrayList<>();
    //    public static final int Header = 1;
    public static final int Normal = 2;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //        public FullscreenVideoLayout imageVideo;
        public ImageView image1;

        //        public CardView main_product;
//        public TextView text ;
        public MyViewHolder(View view) {
            super(view);
            image1 = (ImageView) view.findViewById(R.id.image4);
//            text = (TextView) view.findViewById(R.id.text);
//            VideoView.setActivity(activity);
            //            image = view.findViewById(R.id.imageView);
//            main_product = view.findViewById(R.id.card);
        }
    }


    public AdapterSliderDetails(Activity activity, ArrayList<ImageModel_slider> moviesList) {
        this.tasksList = moviesList;
        this.activity = activity;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = null;
        if (viewType == Normal) {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slider_details, parent, false);
        }
// else {
//            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemvidou, parent, false);
//        }

        return new MyViewHolder(item);
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final ImageModel_slider modelVideo = tasksList.get(position);
        holder.image1.setImageResource(modelVideo.getImageurl());


        Picasso.with(activity).load(modelVideo.getImageurl()).into(holder.image1);

        Picasso.with(activity)
                .load(tasksList.get(position).getImageurl())
                .centerCrop()
                .resize(200, 200)
                .placeholder(R.drawable.shape_slider_white).into(holder.image1);


    }

    @Override
    public int getItemCount() {
        return tasksList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
//            return Header;
        }
        return Normal;
    }

}
