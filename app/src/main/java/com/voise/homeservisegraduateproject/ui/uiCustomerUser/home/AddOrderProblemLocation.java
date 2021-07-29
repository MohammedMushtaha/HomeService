package com.voise.homeservisegraduateproject.ui.uiCustomerUser.home;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.SharedPreferanse.SharedPreferanse;
import com.voise.homeservisegraduateproject.bojo.AddOrderResponse;
import com.voise.homeservisegraduateproject.data.LiveDataModel;
import com.voise.homeservisegraduateproject.databinding.FragmentAddOrderProblemLocationBinding;
import com.voise.homeservisegraduateproject.ui.MainActivity;
import com.voise.homeservisegraduateproject.ui.SplashScreen.SuccesAddOrderActivity;
import com.voise.homeservisegraduateproject.utils.Functions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import www.sanju.motiontoast.MotionToast;


public class AddOrderProblemLocation extends Fragment {

    FusedLocationProviderClient fusedLocationProviderClient;
    AddOrderProblemLocationViewModel addOrderProblemLocationViewModel;
    FragmentAddOrderProblemLocationBinding fragmentAddOrderProblemLocationBinding;
    private static final int Requist_Code_Location_Permission = 1;
    private FusedLocationProviderClient client;
    View v;
    private GoogleMap mMap;
    ArrayList<Uri> arrayList;
    String details;
    int IdCruft;
     LatLng sydney;

    public AddOrderProblemLocation(ArrayList<Uri> arrayList, String details, int IdCruft) {
        this.arrayList = arrayList;
        this.details = details;
        this.IdCruft = IdCruft;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        addOrderProblemLocationViewModel = ViewModelProviders.of(this).get(AddOrderProblemLocationViewModel.class);
        fragmentAddOrderProblemLocationBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_order_problem_location, container, false);
        v = fragmentAddOrderProblemLocationBinding.getRoot();
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());

//        getLocation();

        fragmentAddOrderProblemLocationBinding.setLifecycleOwner(getActivity());
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }

        RelativeLayout toolbar = v.findViewById(R.id.toolbar);
        TextView text_toolbar = toolbar.findViewById(R.id.text_toolbar);
        text_toolbar.setText("Location");
        ImageView image_back = toolbar.findViewById(R.id.image_back);
        image_back.setVisibility(View.VISIBLE);
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }

        });


        fragmentAddOrderProblemLocationBinding.btnAddOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDataServiceProvider();

            }
        });


        return v;
    }

    public void addDataServiceProvider() {

        Functions.getInstanse().showDialog(getActivity(), "Please Waite");
        addOrderProblemLocationViewModel.AddOrder(IdCruft, details, fragmentAddOrderProblemLocationBinding.inputTextLocation.getText().toString(), arrayList, fragmentAddOrderProblemLocationBinding.editPhone1.getText().toString(), 30, 151);
        Log.e("ex1", "4");
        addOrderProblemLocationViewModel.authResponseMutableLiveDataRegisterCustomer.observe(getActivity(), new LiveDataModel.Observer<AddOrderResponse>() {
            @Override
            public void onChanged(AddOrderResponse authResponse) {
                Log.e("ex1", "5");

                if (authResponse.getSuccess()) {
                    Functions.getInstanse().hideDialog();
                    MotionToast.Companion.createToast(
                            getActivity(),
                            "Add Order Success",
                            MotionToast.TOAST_SUCCESS,
                            MotionToast.GRAVITY_BOTTOM,
                            MotionToast.SHORT_DURATION,
                            ResourcesCompat.getFont(getActivity(), R.font.helvetica_regular));
//                    Toast.makeText(getActivity(), "Add Order Success", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getActivity(), SuccesAddOrderActivity.class);
                    startActivity(i);
                } else {
                    Functions.getInstanse().hideDialog();
                    Functions.getInstanse().diaLog(getActivity(), "فشلت عملية اضافة طلب", authResponse.getMessage(), "موافق");
                    Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, Requist_Code_Location_Permission);

            } else {
                LocationRequest locationRequest = new LocationRequest();
                locationRequest.setInterval(1000);
                locationRequest.setFastestInterval(3000);
                locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
                LocationServices.getFusedLocationProviderClient(getActivity()).requestLocationUpdates(locationRequest, new LocationCallback() {
                    @Override
                    public void onLocationResult(LocationResult locationResult) {
                        super.onLocationResult(locationResult);
                        LocationServices.getFusedLocationProviderClient(getActivity()).removeLocationUpdates(this);

                        if (locationResult != null && locationResult.getLocations().size() > 0) {
                            int lastLocation = locationResult.getLocations().size() - 1;
                            double  latude =
                                    locationResult.getLocations().get(lastLocation).getLatitude();

                            double  longtude = locationResult.getLocations().get(lastLocation).getLongitude();
                            sydney = new LatLng(latude, longtude);
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 50), 6000, null);
                            MarkerOptions markerOptions = new MarkerOptions();
                            markerOptions.position(sydney);
                            markerOptions.title("location");
                            markerOptions.snippet("mo");
                            googleMap.addMarker(markerOptions);
                            googleMap.getUiSettings().setCompassEnabled(true);
                            googleMap.getUiSettings().setZoomControlsEnabled(true);
//                    textViewlong.setText(String.format("Latitude: %s\nLongitude: %s", latude, longtude));
                            Log.e("formartd", "" + String.format("Latitude: %s\nLongitude: %s", latude, longtude));
                        }
//                progressBar.setVisibility(View.GONE);
                    }
                }, Looper.getMainLooper());


            }


        }
    };


    private void getCurrentLocation() {
//        progressBar.setVisibility(View.VISIBLE);


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == Requist_Code_Location_Permission && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getCurrentLocation();

            } else {
                Toast.makeText(getActivity(), "Permission Need", Toast.LENGTH_SHORT).show();
            }
        }
    }
}