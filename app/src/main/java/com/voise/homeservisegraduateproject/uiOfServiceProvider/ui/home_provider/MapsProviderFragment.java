package com.voise.homeservisegraduateproject.uiOfServiceProvider.ui.home_provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.voise.homeservisegraduateproject.R;

public class MapsProviderFragment extends Fragment {
    Context context;
    double longitude,latitude;
    View view;
    public MapsProviderFragment(Context context,double longitude,double latitude) {
        this.context = context;
        this.latitude=latitude;
        this.longitude=longitude;


    }
    private OnMapReadyCallback callback = new OnMapReadyCallback() {


        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng sydney = new LatLng(latitude, longitude);
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 10), 6000, null);
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(sydney);
            markerOptions.title("dfg");
            markerOptions.snippet("234");
            googleMap.addMarker(markerOptions);
            googleMap.getUiSettings().setCompassEnabled(true);
            googleMap.getUiSettings().setZoomControlsEnabled(true);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
      view = inflater.inflate(R.layout.fragment_maps_provider, container, false);
        Toast.makeText(context, ""+longitude+latitude, Toast.LENGTH_SHORT).show();
        try {
            loadNavigationView(31.5111637,34.4415131);

        } catch (Exception e) {
            Log.e("Map", "Error");
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }

    public void loadNavigationView(double lat, double lng) {
        Uri navigation = Uri.parse("google.navigation:q=" + 31.5111637 + "," + 34.4415131 + "");
        Intent navigationIntent = new Intent(Intent.ACTION_VIEW, navigation);
        navigationIntent.setPackage("com.google.android.apps.maps");
        startActivity(navigationIntent);
    }

}