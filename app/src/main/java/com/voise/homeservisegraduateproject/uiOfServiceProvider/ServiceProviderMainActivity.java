package com.voise.homeservisegraduateproject.uiOfServiceProvider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.voise.homeservisegraduateproject.R;
import com.voise.homeservisegraduateproject.ui.MainActivity;
import com.voise.homeservisegraduateproject.ui.uiCustomerUser.home.HomeFragmentCustomer;
import com.voise.homeservisegraduateproject.ui.uiCustomerUser.moreApp.MoreFragment;
import com.voise.homeservisegraduateproject.ui.uiCustomerUser.order.PlaceholderFragment;
import com.voise.homeservisegraduateproject.ui.uiCustomerUser.userSetting.UserSettingFragment;
import com.voise.homeservisegraduateproject.uiOfServiceProvider.ui.home_provider.HomeFragmentProvider;
import com.voise.homeservisegraduateproject.uiOfServiceProvider.ui.more_provider.MoreProviderFragment;
import com.voise.homeservisegraduateproject.uiOfServiceProvider.ui.order_provider.OrderProviderFragment;

public class ServiceProviderMainActivity extends AppCompatActivity {
    BottomNavigationView nav_view_service_provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_main);
        nav_view_service_provider = findViewById(R.id.nav_view_service_provider);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_notifications1)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
////        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_service_provider, new HomeFragmentProvider(getApplication())).commit();

        nav_view_service_provider.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_service_provider, new HomeFragmentProvider(getApplication())).commit();

                        return true;
                    case R.id.navigation_order:
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_service_provider, new OrderProviderFragment(getApplication())).commit();

                        return true;
                    case R.id.navigation_notifications:
                        Toast.makeText(ServiceProviderMainActivity.this, "6", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_service_provider, new MoreProviderFragment(getApplication())).commit();

                        return true;
                    case R.id.navigation_more:
                        Toast.makeText(ServiceProviderMainActivity.this, "66", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_service_provider, new MoreFragment(getApplication())).commit();

                        return true;
                }
                return false;
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();

    }
}