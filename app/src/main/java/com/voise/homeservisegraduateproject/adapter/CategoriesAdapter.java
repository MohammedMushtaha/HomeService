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

import com.developer.kalert.KAlertDialog;
import com.squareup.picasso.Picasso;
import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.SharedPreferanse.SharedPreferanse;
import com.voise.homeservisegraduateproject.bojo.DataWork;
import com.voise.homeservisegraduateproject.interfaces.ItemClickLisener;
import com.voise.homeservisegraduateproject.ui.MainActivity;
import com.voise.homeservisegraduateproject.ui.auth.login.LoginActivity;
import com.voise.homeservisegraduateproject.ui.uiCustomerUser.home.AddOrderProblemActivity;
import com.voise.homeservisegraduateproject.ui.uiCustomerUser.order.PlaceholderFragment;

import java.util.ArrayList;
import java.util.List;


public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.PostViewHolder> {
    private List<DataWork> dataWorks = new ArrayList<>();
     Activity activity;

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        final DataWork movie = dataWorks.get(position);

        holder.text_item.setText(movie.getName());

//        Picasso.with(activity).load(movie.getImage()).into(holder.image_item);

        Picasso.with(activity)
                .load(dataWorks.get(position).getIcon())
                .centerCrop()
                .resize(200, 200)
                .placeholder(R.drawable.ic_electricity_logo).into(holder.image_item);

        holder.setItemClickListener(new ItemClickLisener() {
            @Override
            public void onClick(View view, int Position, boolean isLongClick) {
                 SharedPreferanse.write(SharedPreferanse.NameCruft, movie.getName());
                 SharedPreferanse.write(SharedPreferanse.IDCruft, movie.getId());


                if (SharedPreferanse.read(SharedPreferanse.gist, "1").equals("1")) {
                    new KAlertDialog(activity)
                            .setTitleText("غير مصرح بالدخول")
                            .setContentText("يجب تسجيل دخول ")
                            .setConfirmText("موافق")
                            .setCancelClickListener(new KAlertDialog.KAlertClickListener() {
                                @Override
                                public void onClick(KAlertDialog kAlertDialog) {
                                    Intent i = new Intent(activity, LoginActivity.class);
                                   activity. startActivity(i);
                                    activity.finish();
                                }
                            })
                            .confirmButtonColor(R.color.colorRed)
                            .cancelButtonColor(R.color.colorRed)
                            .show();
                } else {

                    Intent i = new Intent(activity, AddOrderProblemActivity.class);
                    i.putExtra("data", movie);
                    activity.startActivity(i);

                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return dataWorks.size();
    }

    public void setList(Activity activity, List<DataWork> moviesList) {
        this.dataWorks = moviesList;
        this.activity = activity;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {
        private TextView text_item;
        private ImageView image_item;
        private ItemClickLisener itemClickLisener;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            image_item = itemView.findViewById(R.id.image_item);
            text_item = itemView.findViewById(R.id.text_item);
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

