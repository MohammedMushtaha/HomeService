package com.voise.homeservisegraduateproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.developer.kalert.KAlertDialog;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.SharedPreferanse.SharedPreferanse;
import com.voise.homeservisegraduateproject.ui.auth.login.LoginActivity;
import com.voise.homeservisegraduateproject.ui.uiCustomerUser.home.HomeFragmentCustomer;
import com.voise.homeservisegraduateproject.ui.uiCustomerUser.moreApp.MoreFragment;
import com.voise.homeservisegraduateproject.ui.uiCustomerUser.order.PlaceholderFragment;
import com.voise.homeservisegraduateproject.ui.uiCustomerUser.userSetting.UserSettingFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_customer);
        navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_notifications1)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
////        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new HomeFragmentCustomer(getApplication())).commit();

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.navigation_home:


                            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new HomeFragmentCustomer(getApplication())).commit();


                        return true;
                    case R.id.navigation_order:

                        if (SharedPreferanse.read(SharedPreferanse.gist, "1").equals("1")) {
                            new KAlertDialog(MainActivity.this)
                                    .setTitleText("غير مصرح بالدخول")
                                    .setContentText("يجب تسجيل دخول ")
                                    .setConfirmText("موافق")
                                    .setCancelClickListener(new KAlertDialog.KAlertClickListener() {
                                        @Override
                                        public void onClick(KAlertDialog kAlertDialog) {
                                            Intent i = new Intent(MainActivity.this, LoginActivity.class);
                                            startActivity(i);
                                            finish();
                                        }
                                    })
                                    .confirmButtonColor(R.color.colorRed)
                                    .cancelButtonColor(R.color.colorRed)
                                    .show();
                        } else {
                            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new PlaceholderFragment(getApplication())).commit();


                        }


                        return true;
                    case R.id.navigation_notifications:


//                        if (SharedPreferanse.read(SharedPreferanse.gist, "1").equals("1")) {
//                            new KAlertDialog(MainActivity.this)
//                                    .setTitleText("غير مصرح بالدخول")
//                                    .setContentText("يجب تسجيل دخول ")
//                                    .setConfirmText("موافق")
//                                    .setCancelClickListener(new KAlertDialog.KAlertClickListener() {
//                                        @Override
//                                        public void onClick(KAlertDialog kAlertDialog) {
//                                            Intent i = new Intent(MainActivity.this, LoginActivity.class);
//                                            startActivity(i);
//                                            finish();
//                                        }
//                                    })
//                                    .confirmButtonColor(R.color.colorRed)
//                                    .cancelButtonColor(R.color.colorRed)
//                                    .show();
//
//                        } else {
                            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new UserSettingFragment(getApplication())).commit();

//                        }

                        return true;
                    case R.id.navigation_more:
                         getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new MoreFragment(getApplication())).commit();

                        return true;
                }
                return false;
            }
        });
    }

}