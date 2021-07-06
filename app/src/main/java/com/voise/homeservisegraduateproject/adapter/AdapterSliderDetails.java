package com.voise.homeservisegraduateproject.adapter;

        import android.app.Activity;
        import android.content.Context;
        import android.os.Build;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;

        import androidx.annotation.NonNull;
        import androidx.annotation.RequiresApi;
        import androidx.recyclerview.widget.RecyclerView;
        import androidx.viewpager.widget.PagerAdapter;
        import androidx.viewpager.widget.ViewPager;

        import com.squareup.picasso.Picasso;
        import com.voise.homeservisegraduateproject.R;
        import com.voise.homeservisegraduateproject.bojo.ImageModel_slider;
        import com.voise.homeservisegraduateproject.bojo.PhotoOrderResponse;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Objects;

/**
 * Created by acer on 3/12/2018.
 */

public class AdapterSliderDetails extends PagerAdapter {
    private Context context;
    private List<PhotoOrderResponse> model_home_sliders;

    public AdapterSliderDetails(Context context, List<PhotoOrderResponse> imageResource) {
        this.context = context;
        this.model_home_sliders = imageResource;
    }

    @Override
    public int getCount() {
        return model_home_sliders.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = Objects.requireNonNull(inflater).inflate(R.layout.item_slider_details, null);
        final PhotoOrderResponse model_home_slider = model_home_sliders.get(position);

//        TextView text_sammary = view.findViewById(R.id.text_sammary);
        ImageView image_welcome = view.findViewById(R.id.image4);

//        image_welcome.setImageResource(model_home_slider.getPhoto());

        //        holder.image4.setImageResource(modelVideo.getPhoto());

//        Picasso.with(activity).load(modelVideo.getImageurl()).into(holder.image1);

        Picasso.with(context)
                .load(model_home_slider.getPhoto())
                .centerCrop()
                .resize(200, 200)
                .placeholder(R.drawable.shape_slider_white).into(image_welcome);



        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}

