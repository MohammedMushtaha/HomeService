package com.voise.homeservisegraduateproject.ui.ui.home;

import android.Manifest;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.SharedPreferanse.SharedPreferanse;
import com.voise.homeservisegraduateproject.adapter.CategoriesAdapter;
import com.voise.homeservisegraduateproject.adapter.ImageUploadAdapter;
import com.voise.homeservisegraduateproject.bojo.DataWork;
import com.voise.homeservisegraduateproject.databinding.FragmentAddOrderProblemBinding;
import com.voise.homeservisegraduateproject.ui.MainActivity;

import java.util.ArrayList;
import java.util.List;

import gun0912.tedbottompicker.TedBottomPicker;
import gun0912.tedbottompicker.TedBottomSheetDialogFragment;

public class AddOrderProblemActivity extends AppCompatActivity {
    private DataWork dataWork;
    AddOrderProblemViewModel addOrderProblemViewModel;
    FragmentAddOrderProblemBinding addOrderProblemBinding;
    ArrayList<Uri> uriArrayList = new ArrayList<>();
    ImageUploadAdapter imageUploadAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addOrderProblemViewModel = ViewModelProviders.of(this).get(AddOrderProblemViewModel.class);
        addOrderProblemBinding = DataBindingUtil.setContentView(this, R.layout.fragment_add_order_problem);


        RelativeLayout toolbar = findViewById(R.id.toolbar);
        TextView text_toolbar = toolbar.findViewById(R.id.text_toolbar);
        ImageView image_back = toolbar.findViewById(R.id.image_back);
        image_back.setVisibility(View.VISIBLE);
        dataWork = (DataWork) getIntent().getSerializableExtra("data");
        text_toolbar.setText(SharedPreferanse.read(SharedPreferanse.NameCruft, ""));
        int idCruft=Integer.parseInt(String.valueOf(dataWork.getId()));

        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddOrderProblemActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        addOrderProblemBinding.uploadPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PermissionListener permissionlistener = new PermissionListener() {
                    @Override
                    public void onPermissionGranted() {
                        TedBottomPicker.with((FragmentActivity) AddOrderProblemActivity.this)
                                .showTitle(false)
//                                .setSelectedUriList(uriArrayList)
                                .setSelectMaxCount(3)
                                .setSelectMinCount(1)
                                .setCompleteButtonText(getString(R.string.done))
                                .setEmptySelectionText("No Select")
                                .showMultiImage(new TedBottomSheetDialogFragment.OnMultiImageSelectedListener() {
                                    @Override
                                    public void onImagesSelected(List<Uri> uriList) {
                                        // here is selected image uri list
                                        uriArrayList.clear();
                                        uriArrayList = (ArrayList<Uri>) uriList;
                                        if (uriList.size() > 0) {
//                                            addOrderProblemBinding.imagesRv.setVisibility(View.VISIBLE);
//                                            addOrderProblemBinding.uploadPicturesTv.setVisibility(View.GONE);
//                                            addCamelImagesAdapter = new AddCamelImagesAdapter(getActivity(), uriList);
//                                            binding.imagesRv.setAdapter(addCamelImagesAdapter);

                                            imageUploadAdapter = new ImageUploadAdapter();
                                            GridLayoutManager mLayoutManager = new GridLayoutManager(AddOrderProblemActivity.this, 3);
                                            addOrderProblemBinding.recyclerViewUpload.setLayoutManager(mLayoutManager);
                                            imageUploadAdapter.setList(AddOrderProblemActivity.this, uriArrayList);
                                            addOrderProblemBinding.recyclerViewUpload.setAdapter(imageUploadAdapter);
                                        } else {
//                                            binding.uploadPicturesTv.setVisibility(View.VISIBLE);
//                                            binding.imagesRv.setVisibility(View.GONE);
                                        }
                                    }
                                });

                    }

                    @Override
                    public void onPermissionDenied(List<String> deniedPermissions) {

                    }


                };

                TedPermission.with(AddOrderProblemActivity.this)
                        .setPermissionListener(permissionlistener)
                        .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                        .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
                        .check();
            }
        });

        addOrderProblemBinding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (uriArrayList.size() == 0||addOrderProblemBinding.inputTextProblem.getText().toString().equals("")) {
                    Toast.makeText(AddOrderProblemActivity.this, "Must Upload photo And Text Problem", Toast.LENGTH_SHORT).show();
                } else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.edit_frame3, new AddOrderProblemLocation(uriArrayList, addOrderProblemBinding.inputTextProblem.getText().toString(),idCruft)).addToBackStack(null).commit();

                }

            }
        });

    }
}