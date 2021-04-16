package com.voise.homeservisegraduateproject.ui.ui.userSetting;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.voise.homeservisegraduateproject.R;


public class UserSettingFragment extends Fragment {

    private UserSettingFragmentViewModel notificationsViewModel;
    Context context;
    public UserSettingFragment(Context context) {
        this.context = context;

    }
    View root;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(UserSettingFragmentViewModel.class);
          root = inflater.inflate(R.layout.fragment_setting, container, false);

        return root;
    }
//    private void init() {
//         change_pass = root.findViewById(R.id.change_pass);
//        faqS = root.findViewById(R.id.faqS);
//        bottomSheet1 = root.findViewById(R.id.buttomSheet1);
//        relative =root. findViewById(R.id.relative);
//        close =root. findViewById(R.id.close);
//        Policy = root.findViewById(R.id.relative5);
//        Condition = root.findViewById(R.id.relative4);
//        E_edit_current_pass = root.findViewById(R.id.E_edit_current_pass);
//        E_edit_new_pass = root.findViewById(R.id.E_edit_new_pass);
//        E_edit_confirm_pass = root.findViewById(R.id.E_edit_confirm_pass);
//        notification = root.findViewById(R.id.notification);
//
//        mask_background = findViewById(R.id.mask_background);
//        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet1);
//        about_app = findViewById(R.id.about_app);
//        btn_send = findViewById(R.id.btn_send);
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        image_back = toolbar.findViewById(R.id.image_back);
//        title_toolbar = toolbar.findViewById(R.id.title_toolbar);
//        title_toolbar.setText(getResources().getString(R.string.Setting));
}