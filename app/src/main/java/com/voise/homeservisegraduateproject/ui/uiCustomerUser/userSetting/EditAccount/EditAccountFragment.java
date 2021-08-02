package com.voise.homeservisegraduateproject.ui.uiCustomerUser.userSetting.EditAccount;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.voise.homeservisegraduateproject.R;


public class EditAccountFragment extends Fragment {

    public EditAccountFragment() {
        // Required empty public constructor
    }


//    public static EditAccountFragment newInstance(String param1, String param2) {
//        EditAccountFragment fragment = new EditAccountFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_edit_account, container, false);
        RelativeLayout relativeLayout =view.findViewById(R.id.mainLayout);
       relativeLayout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });
        return view;
    }
}