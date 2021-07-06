package com.voise.homeservisegraduateproject.ui.uiCustomerUser.userSetting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.MotionEventCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.squareup.picasso.Picasso;
import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.SharedPreferanse.SharedPreferanse;
import com.voise.homeservisegraduateproject.ui.auth.login.LoginActivity;
import com.voise.homeservisegraduateproject.ui.uiCustomerUser.home.AddOrderProblemLocationViewModel;
import com.voise.homeservisegraduateproject.ui.uiCustomerUser.moreApp.AboutApp.AboutAppFragment;
import com.voise.homeservisegraduateproject.ui.uiCustomerUser.userSetting.EditAccount.EditAccountFragment;
import com.voise.homeservisegraduateproject.utils.Functions;


public class UserSettingFragment extends Fragment {

    private UserSettingFragmentViewModel userSettingFragmentViewModel;
    Context context;
    public static BottomSheetBehavior bottomSheetBehavior;
    RelativeLayout contact_us, relative, relative_fava;
    public static LinearLayout mask_background, log_out;
    public static String dd;
    View view;
    View bottomSheet1;
    ImageView image_setting, image_notification, image_edit_profile, image_user;
    private Button btn_send;
    private EditText E_edit_name, E_edit_email, E_edit_phone, E_edit_text;
    private TextView CityOfUser, NameOfUser;

    public UserSettingFragment(Context context) {
        this.context = context;

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        userSettingFragmentViewModel =
                new ViewModelProvider(this).get(UserSettingFragmentViewModel.class);
        view = inflater.inflate(R.layout.fragment_setting_customer, container, false);


        init();
        onClick();
        return view;
    }

    public void init() {

        bottomSheet1 = view.findViewById(R.id.buttomSheet1);
        contact_us = view.findViewById(R.id.contact_us);
        image_edit_profile = view.findViewById(R.id.image_edit_profile);
        relative = view.findViewById(R.id.relative);
        NameOfUser = view.findViewById(R.id.NameOfUser);
        image_setting = view.findViewById(R.id.image_setting);
        image_notification = view.findViewById(R.id.image_notification);
        mask_background = view.findViewById(R.id.mask_background);
        image_user = view.findViewById(R.id.image_user);
        relative_fava = view.findViewById(R.id.relative_fava);
        E_edit_name = view.findViewById(R.id.E_edit_name);
        E_edit_email = view.findViewById(R.id.E_edit_email);
        E_edit_phone = view.findViewById(R.id.E_edit_phone);
        E_edit_text = view.findViewById(R.id.E_edit_text);
        CityOfUser = view.findViewById(R.id.CityOfUser);
        btn_send = view.findViewById(R.id.btn_send);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet1);
        NameOfUser.setText(SharedPreferanse.read(SharedPreferanse.USERNAMECustomer, ""));
        CityOfUser.setText(SharedPreferanse.read(SharedPreferanse.EmailCustomer, ""));

        Picasso.with(getActivity())
                .load(SharedPreferanse.read(SharedPreferanse.IMAGECustomer, ""))
                .placeholder(R.drawable.shape_setting_image_user)
                .error(R.drawable.shape_setting_image_user)
                .into(image_user);

        log_out = view.findViewById(R.id.log_out);
        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferanse.clear();

                Intent i = new Intent(getActivity(), LoginActivity.class);
                startActivity(i);
                getActivity().finish();
            }
        });

        image_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditAccountFragment fragment2 = new EditAccountFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction().addToBackStack(null);
//        Bundle args = new Bundle();
//        args.putString("m", m);
//        fragment2.setArguments(args);
                fragmentTransaction.replace(R.id.edit_frame, fragment2);
                fragmentTransaction.commit();
            }
        });

    }


    public void onClick() {


        contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                mask_background.setVisibility(View.VISIBLE);

            }
        });

        relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                mask_background.setVisibility(View.GONE);

            }
        });


        bottomSheet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.getInstanse().click_out(getActivity());

            }
        });


        mask_background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                mask_background.setVisibility(View.GONE);
            }
        });


        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    mask_background.setVisibility(View.VISIBLE);
                } else if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    mask_background.setVisibility(View.GONE);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                // React to dragging events
                bottomSheet.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        int action = MotionEventCompat.getActionMasked(event);
                        switch (action) {
                            case MotionEvent.ACTION_DOWN:
//                                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
//                                mask_background.setVisibility(View.GONE);
                                return false;
                            default:
                                return true;
                        }
                    }
                });
            }
        });
    }
}