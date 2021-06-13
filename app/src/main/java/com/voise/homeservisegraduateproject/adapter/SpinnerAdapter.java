package com.voise.homeservisegraduateproject.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;
import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.bojo.DataWork;

import java.util.List;

public class SpinnerAdapter extends ArrayAdapter<DataWork> {
    LayoutInflater layoutInflater;
      Context context;

     public SpinnerAdapter(  Context context, int resource, @NonNull List<DataWork> dataWorks) {
        super(context, resource, dataWorks);
         layoutInflater = LayoutInflater.from(context);
         this.context = context;

     }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View rowView = layoutInflater.inflate(R.layout.item_custome_spinner, null,true);
        DataWork dataWork = getItem(position);
        TextView textView = (TextView)rowView.findViewById(R.id.nameTextView);
        ImageView imageView = (ImageView)rowView.findViewById(R.id.imageIcon);
        textView.setText(dataWork.getName());
//        imageView.setImageResource(dataWork.getIcon());
        Picasso.with(context).load(dataWork.getIcon()).into(imageView);

        return rowView;
    }


    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        if(convertView == null)
            convertView = layoutInflater.inflate(R.layout.item_custome_spinner, parent,false);

        DataWork dataWork = getItem(position);
        TextView textView = (TextView)convertView.findViewById(R.id.nameTextView);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.imageIcon);
        textView.setText(dataWork.getName());
        Picasso.with(context).load(dataWork.getIcon()).into(imageView);
        return convertView;
    }

}
