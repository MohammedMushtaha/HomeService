package com.voise.homeservisegraduateproject.ui.uiCustomerUser.moreApp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.developer.kalert.KAlertDialog;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.voise.homeservisegraduateproject.R;
//import com.voise.homeservisegraduateproject.databinding.FragmentMoreBinding;
import com.voise.homeservisegraduateproject.SharedPreferanse.SharedPreferanse;
import com.voise.homeservisegraduateproject.databinding.FragmentMoreCustomerBinding;
import com.voise.homeservisegraduateproject.ui.MainActivity;
import com.voise.homeservisegraduateproject.ui.auth.login.LoginActivity;
import com.voise.homeservisegraduateproject.ui.uiCustomerUser.moreApp.AboutApp.AboutAppFragment;
import com.voise.homeservisegraduateproject.ui.uiCustomerUser.userSetting.UserSettingFragment;
import com.voise.homeservisegraduateproject.utils.Functions;

public class MoreFragment extends Fragment {

    private MoreViewModel dashboardViewModel;
    Context context;

    public MoreFragment(Context context) {
        this.context = context;

    }

    private View bottomSheet1;

    FragmentMoreCustomerBinding binding;
    private BottomSheetBehavior bottomSheetBehavior;

    View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(MoreViewModel.class);

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_more_customer, container, false);
        root = binding.getRoot();
        binding.setLifecycleOwner(getActivity());
        bottomSheet1 = root.findViewById(R.id.buttomSheet1);

        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet1);

        ovClick();
        return root;
    }

    public void ovClick() {
        binding.changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (SharedPreferanse.read(SharedPreferanse.gist, "1").equals("1")) {
                    new KAlertDialog(getActivity())
                            .setTitleText("?????? ???????? ??????????????")
                            .setContentText("?????? ?????????? ???????? ")
                            .setConfirmText("??????????")
                            .setCancelClickListener(new KAlertDialog.KAlertClickListener() {
                                @Override
                                public void onClick(KAlertDialog kAlertDialog) {
                                    getActivity().finish();
                                }
                            })
                            .confirmButtonColor(R.color.colorRed)
                            .cancelButtonColor(R.color.colorRed)
                            .show();

                } else {


                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    binding.maskBackground.setVisibility(View.VISIBLE);
                }


            }
        });


        binding.relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                binding.maskBackground.setVisibility(View.GONE);
                Functions.getInstanse().click_out(getActivity());
            }
        });

        binding.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.getInstanse().click_out(getActivity());

            }
        });
        binding.relative4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferanse.write(SharedPreferanse.p_y_a, "2");
                AboutAppFragment fragment2 = new AboutAppFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction().addToBackStack(null);
//        Bundle args = new Bundle();
//        args.putString("m", m);
//        fragment2.setArguments(args);
                fragmentTransaction.replace(R.id.edit_frame, fragment2);
                fragmentTransaction.commit();
            }
        });
        binding.relative5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferanse.write(SharedPreferanse.p_y_a, "3");
                AboutAppFragment fragment2 = new AboutAppFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction().addToBackStack(null);
//        Bundle args = new Bundle();
//        args.putString("m", m);
//        fragment2.setArguments(args);
                fragmentTransaction.replace(R.id.edit_frame, fragment2);
                fragmentTransaction.commit();
            }
        });

        binding.maskBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                binding.maskBackground.setVisibility(View.GONE);
                Functions.getInstanse().click_out(getActivity());
            }
        });


        binding.aboutApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferanse.write(SharedPreferanse.p_y_a, "1");
                AboutAppFragment fragment2 = new AboutAppFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction().addToBackStack(null);
//        Bundle args = new Bundle();
//        args.putString("m", m);
//        fragment2.setArguments(args);
                fragmentTransaction.replace(R.id.edit_frame, fragment2);
                fragmentTransaction.commit();
            }
        });
        TextView title_toolbar = root.findViewById(R.id.text_toolbar);
        title_toolbar.setText(getResources().getString(R.string.more));

    }
}