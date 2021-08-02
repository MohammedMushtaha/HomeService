package com.voise.homeservisegraduateproject.ui.uiCustomerUser.moreApp.AboutApp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.SharedPreferanse.SharedPreferanse;
import com.voise.homeservisegraduateproject.adapter.CategoriesAdapter;
import com.voise.homeservisegraduateproject.bojo.DataInformation;
import com.voise.homeservisegraduateproject.bojo.DataWork;
import com.voise.homeservisegraduateproject.databinding.FragmentAboutAppBinding;
import com.voise.homeservisegraduateproject.ui.uiCustomerUser.home.HomeViewModel;

import java.util.List;


public class AboutAppFragment extends Fragment {

    public AboutAppFragment() {
        // Required empty public constructor
    }

    AboutAppViewModel aboutAppViewModel;
    FragmentAboutAppBinding fragmentAboutAppBinding;
    View root;
    TextView title_toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//         root= inflater.inflate(R.layout.fragment_about_app, container, false);

        aboutAppViewModel =
                new ViewModelProvider(this).get(AboutAppViewModel.class);
        fragmentAboutAppBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_about_app, container, false);
        root = fragmentAboutAppBinding.getRoot();
        fragmentAboutAppBinding.setLifecycleOwner(getActivity());

        Toolbar toolbar = (Toolbar) root.findViewById(R.id.toolbar);
        title_toolbar = toolbar.findViewById(R.id.title_toolbar);
        ImageView image_back = toolbar.findViewById(R.id.image_back);
        title_toolbar.setText(R.string.about);
        getAllInformationData();

        return root;
    }


    public void getAllInformationData() {
        aboutAppViewModel.getAllInformationkData();
        aboutAppViewModel.listMutableLiveDataِInformationAllWork.observe(getActivity(), new Observer<List<DataInformation>>() {
            @Override
            public void onChanged(List<DataInformation> dataWorks) {
                if (SharedPreferanse.read(SharedPreferanse.p_y_a, "").equals("1")) {
                    fragmentAboutAppBinding.textAboutUs.setText(dataWorks.get(0).getDescription());
                    title_toolbar.setText(R.string.about);
                    fragmentAboutAppBinding.socialLayout.setVisibility(View.GONE);

                } else if (SharedPreferanse.read(SharedPreferanse.p_y_a, "").equals("2")) {
                    fragmentAboutAppBinding.textAboutUs.setText(dataWorks.get(0).getDescription());
                    title_toolbar.setText(R.string.Terms_and_Condition);
                    fragmentAboutAppBinding.socialLayout.setVisibility(View.GONE);

                } else if (SharedPreferanse.read(SharedPreferanse.p_y_a, "").equals("3")) {
                    fragmentAboutAppBinding.textAboutUs.setText(dataWorks.get(1).getDescription());
                    title_toolbar.setText(R.string.Privacy);

                    fragmentAboutAppBinding.socialLayout.setVisibility(View.GONE);

                }

            }
        });
    }

}