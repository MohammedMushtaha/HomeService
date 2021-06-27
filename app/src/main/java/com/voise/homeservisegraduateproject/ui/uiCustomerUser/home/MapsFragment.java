package com.voise.homeservisegraduateproject.ui.uiCustomerUser.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.voise.homeservisegraduateproject.R;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsFragment extends Fragment     {
    FusedLocationProviderClient fusedLocationProviderClient;
    View view;
    LocationManager locationManager;
    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng sydney = new LatLng(-34, 151);
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 50), 6000, null);
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(sydney);
            markerOptions.title("asd");
            markerOptions.snippet("mo");
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
          view= inflater.inflate(R.layout.fragment_maps, container, false);

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
        Button b=view.findViewById(R.id.b);
         b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());

            }
        });
    }


    private void getLocation() {
        Log.e("wer", "cb");

        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                Log.e("uiasdasds", "f");

                if (location != null) {

                    Geocoder geocoder = new Geocoder(getContext(), Locale.getDefault());
                    try {
                        Log.e("vbn", "fg");

                        List<Address> addresses = geocoder.getFromLocation(
                                location.getLatitude(), location.getLongitude(), 1
                        );
                        Toast.makeText(getActivity(), "" + addresses.get(0).getLongitude(), Toast.LENGTH_SHORT).show();
                        Log.e("sdfsdf", "" + addresses.get(0).getLatitude());
                        Log.e("sdfsqwewedf", "" + addresses.get(0).getCountryName());
                    } catch (IOException e) {
                        e.printStackTrace();
                        Log.e("vbnmd", "");

                    }
                } else {
                    Toast.makeText(getActivity(), "sdf", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}