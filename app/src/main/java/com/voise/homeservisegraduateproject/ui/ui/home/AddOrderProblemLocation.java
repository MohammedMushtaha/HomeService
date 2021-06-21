package com.voise.homeservisegraduateproject.ui.ui.home;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.SharedPreferanse.SharedPreferanse;
import com.voise.homeservisegraduateproject.bojo.AddOrderResponse;
import com.voise.homeservisegraduateproject.bojo.AuthResponseCustomer;
import com.voise.homeservisegraduateproject.bojo.AuthResponseProvider;
import com.voise.homeservisegraduateproject.data.LiveDataModel;
import com.voise.homeservisegraduateproject.databinding.FragmentAddOrderProblemLocationBinding;
import com.voise.homeservisegraduateproject.databinding.FragmentRegisterBinding;
import com.voise.homeservisegraduateproject.ui.MainActivity;
import com.voise.homeservisegraduateproject.ui.auth.login.LoginActivity;
import com.voise.homeservisegraduateproject.ui.auth.register.RegisterViewModel;
import com.voise.homeservisegraduateproject.utils.Functions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class AddOrderProblemLocation extends Fragment implements OnMapReadyCallback {


    AddOrderProblemLocationViewModel addOrderProblemLocationViewModel;
    FragmentAddOrderProblemLocationBinding fragmentAddOrderProblemLocationBinding;
    View v;
    private GoogleMap mMap;
    ArrayList<Uri> arrayList;
    String details;
    int IdCruft;

    public AddOrderProblemLocation(ArrayList<Uri> arrayList, String details, int IdCruft) {
        this.arrayList = arrayList;
        this.details = details;
        this.IdCruft = IdCruft;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        addOrderProblemLocationViewModel = ViewModelProviders.of(this).get(AddOrderProblemLocationViewModel.class);
        fragmentAddOrderProblemLocationBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_order_problem_location, container, false);
        v = fragmentAddOrderProblemLocationBinding.getRoot();
        fragmentAddOrderProblemLocationBinding.setLifecycleOwner(getActivity());


        RelativeLayout toolbar = v.findViewById(R.id.toolbar);
        TextView text_toolbar = toolbar.findViewById(R.id.text_toolbar);
        text_toolbar.setText("Location");
        ImageView image_back = toolbar.findViewById(R.id.image_back);
        image_back.setVisibility(View.VISIBLE);
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), AddOrderProblemActivity.class);

                startActivity(i);
                Toast.makeText(getActivity(), "" + SharedPreferanse.read(SharedPreferanse.NameCruft, ""), Toast.LENGTH_SHORT).show();
            }

        });


        fragmentAddOrderProblemLocationBinding.btnAddOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDataServiceProvider();

            }
        });

        fragmentAddOrderProblemLocationBinding.map3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());
//                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//                    getLocation();
//                } else {
//                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
//                }
                MapsFragment fragment2 = new MapsFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.edit_frame, fragment2);

                fragmentTransaction.commit();

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
                    Toast.makeText(getActivity(), "Add Order Success", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getActivity(), MainActivity.class);
                    startActivity(i);
                } else {
                    Functions.getInstanse().hideDialog();
                    Functions.getInstanse().diaLog(getActivity(), "فشلت عملية اضافة طلب", authResponse.getMessage(), "موافق");
                    Log.e("sdsdsdsd", "1111");
                    Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
//        LatLng sydney = new LatLng(31.540852, 34.5065272);
//        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 10), 6000, null);
//        MarkerOptions markerOptions = new MarkerOptions();
//        markerOptions.position(sydney);
//        markerOptions.title("title2");
//        markerOptions.snippet("title");
//        googleMap.addMarker(markerOptions);
//        googleMap.getUiSettings().setCompassEnabled(true);
//        googleMap.getUiSettings().setZoomControlsEnabled(true);
//        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(31.540852, 34.5065272);
        mMap.addMarker(new MarkerOptions().position(sydney).title("string"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

//    private void getLocation() {
//        Log.e("wer", "cb");
//
//        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
//            @Override
//            public void onComplete(@NonNull Task<Location> task) {
//                Location location = task.getResult();
//                Log.e("uiasdasds", "f");
//
//                if (location != null) {
//
//                    Geocoder geocoder = new Geocoder(getContext(), Locale.getDefault());
//                    try {
//                        Log.e("vbn", "fg");
//
//                        List<Address> addresses = geocoder.getFromLocation(
//                                location.getLatitude(), location.getLongitude(), 1
//                        );
//                        Toast.makeText(context, "" + addresses.get(0).getLongitude(), Toast.LENGTH_SHORT).show();
//                        Log.e("sdfsdf", "" + addresses.get(0).getLatitude());
//                        Log.e("sdfsqwewedf", "" + addresses.get(0).getCountryName());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                        Log.e("vbnmd", "");
//
//                    }
//                } else {
//                    Toast.makeText(getActivity(), "sdf", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }

//
//    MapsFragment fragment2 = new MapsFragment();
//    FragmentManager fm = getFragmentManager();
//    FragmentTransaction fragmentTransaction = fm.beginTransaction();
//                fragmentTransaction.replace(R.id.edit_frame, fragment2);
//
//                fragmentTransaction.commit();
}